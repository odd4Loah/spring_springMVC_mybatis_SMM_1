package com.lihoo.ssm.gai.model;

import java.util.Date;

/**
 * #Title: UserX
 * #ProjectName spring_springMVC_mybatis_SMM_JSON
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/14-15:54
 */

@SuppressWarnings("unused")
public class UserX {

    private Integer id;
    private int age;
    private String userName;
    private Date birthday;

    public UserX() {
        super();
    }

    public UserX(Integer id, int age, String userName, Date birthday) {
        super();
        this.id = id;
        this.age = age;
        this.userName = userName;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
