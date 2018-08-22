package com.lihoo.ssm.gai.aop;

/**
 * #Title: ControllerAspect
 * #ProjectName spring_springMVC_mybatis_SMM_JSON_miniClass
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/18-18:22
 */


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import static javax.management.timer.Timer.ONE_MINUTE;

/**
 * 检测方法执行耗时的spring切面类
 * 使用@Aspect注解的类，Spring将会把它当作一个特殊的Bean（一个切面），也就是不对这个类本身进行动态代理
 * @author blinkfox
 * @date 2016-07-04
 */
@Aspect
@Component
public class ControllerAspect {
    private static Logger logger = Logger.getLogger(ControllerAspect.class);

//    一分钟，60000ms
//    private static final ONE_MINUTE;

    // service层的统计耗时切面，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
    public static final String POINT = "execution (* com.lihoo.ssm.gai.service.Impl.*.*(..))";

    /**
     * 统计方法执行耗时Around环绕通知
     * @param joinPoint
     * @return
     */
    @Around(POINT)
    public Object timeAround(ProceedingJoinPoint joinPoint) {
//        定义返回对象，得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.debug("统计某方法执行耗时环绕通知出错", e);
        }

//        获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

//        打印耗时信息
        this.printExecTime(methodName, startTime, endTime);

        return obj;
    }

    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     * @param methodName
     * @param startTime
     * @param endTime
     */

    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;

        if (diffTime > ONE_MINUTE) {
            logger.debug("----" + methodName + "方法执行耗时：" + diffTime + "ms");
        }
    }

}
