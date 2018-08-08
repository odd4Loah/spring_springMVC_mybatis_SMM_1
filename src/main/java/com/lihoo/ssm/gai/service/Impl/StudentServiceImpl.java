package com.lihoo.ssm.gai.service.Impl;

import com.lihoo.ssm.gai.dao.StudentDao;
import com.lihoo.ssm.gai.service.StudentService;
import com.lihoo.ssm.gai.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihoo
 * @Title: StudentServiceImpl
 * @ProjectName spring_mybatis_1
 * @Description: TODO
 * @date 2018/8/3-19:10
 */

@Service
public class StudentServiceImpl implements StudentService {

    //使用注解的方式注入属性，就不需要手动生成set方法。
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findStudentList() throws Exception {
        return studentDao.findStudentList();
    }

    @Override
    public Student findStudentById(int id) throws Exception {
        return studentDao.findStudentById(id);
    }

    @Override
    public Student findStudentByName(String username) throws Exception {
        return studentDao.findStudentByName(username);
    }

    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(Student student) throws Exception {
        studentDao.deleteStudent(student);
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        studentDao.updateStudent(student);
    }
}
