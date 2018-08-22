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

@RestController
@RequestMapping("")
public class StudentController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView findStudentList(Page page) throws Exception {
        logger.debug("开始获取数据！");
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 5);
        List<Student> stu = studentService.findStudentList();
        int total_page = (int) new PageInfo<>(stu).getTotal();
        page.caculateLast(total_page);
        //        放入转发参数
        mav.addObject("stu", stu);
//        放入jsp路径
        mav.setViewName("listStudent");
        return mav;

    }

//    ...

    // @RequestBody:此注解用来接收前台传来的json数据（在此例中）
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView addStudent(Student student) throws Exception {
        logger.debug("增加学生");
        studentService.addStudent(student);
        return new ModelAndView("redirect:/student");
    }

    // @PathVariable:此注解可以将url路径中传过来的值绑定到方法的参数上
    // 可以写成 @PathVariable long id ；
    // 也可以 @PathVariable("id") long id   （当有多个值时使用后者）
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(Student student) throws Exception {
        studentService.deleteStudent(student);
        logger.debug("成功删除学生信息");
        return new ModelAndView("redirect:/student");
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView getStudent(Student student) throws Exception {
        Student stu = studentService.findStudentById(student.getId());
        ModelAndView mav = new ModelAndView("editStudent");
        mav.addObject("stu", stu);
        return mav;
    }

    // 方法中接收了两个参数，URL路径中的和body中
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) throws Exception {
        // 进行更新操作时一定要对数据模型设置id，因为在使用SQL语句更新时有一个id参数
        studentService.updateStudent(student);
        return new ModelAndView("redirect:/student");
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


}
