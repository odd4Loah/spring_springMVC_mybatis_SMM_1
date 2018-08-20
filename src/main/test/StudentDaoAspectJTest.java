import com.lihoo.ssm.gai.dao.StudentDao;
import com.lihoo.ssm.gai.model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * #Title: StudentDaoAspectJTest
 * #ProjectName spring_springMVC_mybatis_SMM_JSON_miniClass
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/18-16:40
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class StudentDaoAspectJTest {
    private static Logger logger = Logger.getLogger(StudentDaoAspectJTest.class);


    @Autowired
    StudentDao studentDao;

    @Test
    public void aspectJTestFindStudentList() throws Exception {
        logger.debug("开始查询学员----开始切面");
        List<Student> list = studentDao.findStudentList();
        for (Student studentList:  list) {
            logger.debug(studentList);
        }
        logger.debug("查询成功----结束切面");
    }

    @Test
    public void aspectJTestFindStudentById() throws Exception {
        logger.debug("开始查询学员");
        Student stu_id = studentDao.findStudentById(15);
        logger.debug(stu_id);
        logger.debug("查询成功！！！");
    }

    @Test
    public void aspectJTestAdd() throws Exception{
        logger.debug("开始切面");

        Student stu = new Student();
        stu.setUsername("希尔瓦娜斯·风行者");
        stu.setQq_num(116255377);
        stu.setStudy_type("java");
        stu.setStudy_time(1532465812);
        stu.setSchool("飞行船暗夜大学");
        stu.setStudy_id("java-852");
        stu.setDaily_link("bulizada.com");
        stu.setPromise("女王降智商");
        stu.setTeach_bro("网恋乌瑞恩");
        stu.setKnow_us_from("大酋长是你的");
        stu.setCreate_at(1534658741);
        stu.setUpdate_at(1534669512);
        studentDao.addStudent(stu);

        logger.debug("结束切面");
    }
}
