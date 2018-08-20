package com.lihoo.ssm.gai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lihoo.ssm.gai.model.Student;
import com.lihoo.ssm.gai.model.User;
import com.lihoo.ssm.gai.service.StudentService;
import com.lihoo.ssm.gai.service.UserService;
import com.lihoo.ssm.gai.util.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lihoo
 * @Title: StudentController
 * @ProjectName spring_springMVC_mybatis_SMM_1
 * @Description: TODO
 * @date 2018/8/8-12:54
 */

@Controller
@RequestMapping("")
public class StudentController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

//// //   ******RequestBody********
//
//   // @ResponseBody:此注解完成返回对象到json数据的转换


    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> findStudentList() throws Exception {
        logger.debug("开始获取数据！");

//        ModelAndView mav = new ModelAndView();
//        PageHelper.offsetPage(page.getStart(), 5);
        List<Student> stus = studentService.findStudentList();

//        int total_page = (int) new PageInfo<>(stu).getTotal();
//        page.caculateLast(total_page);
//                放入转发参数
//        mav.addObject("stu", stu);
//        放入jsp路径
//        mav.setViewName("listStudent");
//        return mav;
        logger.debug("OK");
        return stus;
    }


////    *****json-taglib*******

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public ModelAndView listStudent() throws Exception {
//        ModelAndView mav = new ModelAndView();
//        List<Student> stus = studentService.findStudentList();
//        mav.addObject("stus", stus);
//        mav.setViewName("jsonTaglib");
//        logger.debug("OJBK");
//        return mav;
//    }



    // @RequestBody:此注解用来接收前台传来的json数据（在此例中）
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) throws Exception {
        logger.debug("增加学生");
        studentService.addStudent(student);
//        ModelAndView mav = new ModelAndView("redirect:/student");
//        return mav;
        logger.debug("成功添加学生信息");
        return "addStudent success";
    }

    // @PathVariable:此注解可以将url路径中传过来的值绑定到方法的参数上
    // 可以写成 @PathVariable long id ；
    // 也可以 @PathVariable("id") long id   （当有多个值时使用后者）
    @ResponseBody
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable long id) throws Exception {
        studentService.deleteStudent(id);
        logger.debug("成功删除id为"+id+"的学生信息");
//        ModelAndView mav = new ModelAndView("redirect:/student");
//        return mav;
        return "delete success";
    }

    @ResponseBody
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable long id) throws Exception {
        Student stu = studentService.findStudentById(id);
//        ModelAndView mav = new ModelAndView("editStudent");
//        mav.addObject("stu", stu);
//        return mav;
        logger.debug("成功查询到id："+id+"的信息");
        return stu;
    }

    // 方法中接收了两个参数，URL路径中的和body中
    @ResponseBody
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String updateStudent(@PathVariable long id,@RequestBody Student student) throws Exception {
        // 进行更新操作时一定要对数据模型设置id，因为在使用SQL语句更新时有一个id参数
        student.setId(id);
        studentService.updateStudent(student);
        logger.debug(student);
        logger.debug("成功更新id："+id+"的学生信息");
//        ModelAndView mav = new ModelAndView("redirect:/student");
//        return mav;
        return "update success";
    }





}
