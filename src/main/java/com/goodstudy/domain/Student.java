package com.goodstudy.domain;

/*
* 孙向锋
* */
public class Student {
private int stu_id;
private String stu_name;
private String stu_gender;
private String stu_birthday;
private String stu_username;
private String stu_pwd;
private String stu_email;
private String stu_head_img;
//空构造
    public Student() {
    }
//有参构造

    public Student(int stu_id, String stu_name, String stu_gender, String stu_birthday, String stu_username, String stu_pwd, String stu_email, String stu_head_img) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_gender = stu_gender;
        this.stu_birthday = stu_birthday;
        this.stu_username = stu_username;
        this.stu_pwd = stu_pwd;
        this.stu_email = stu_email;
        this.stu_head_img = stu_head_img;
    }


//toString方法

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_gender='" + stu_gender + '\'' +
                ", stu_birthday=" + stu_birthday +
                ", stu_username='" + stu_username + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_email='" + stu_email + '\'' +
                ", stu_head_img='" + stu_head_img + '\'' +
                '}';
    }
//grt和set方法

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(String stu_gender) {
        this.stu_gender = stu_gender;
    }

    public String getStu_birthday() {
        return stu_birthday;
    }

    public void setStu_birthday(String stu_birthday) {
        this.stu_birthday = stu_birthday;
    }

    public String getStu_username() {
        return stu_username;
    }

    public void setStu_username(String stu_username) {
        this.stu_username = stu_username;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getStu_email() {
        return stu_email;
    }

    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }

    public String getStu_head_img() {
        return stu_head_img;
    }

    public void setStu_head_img(String stu_head_img) {
        this.stu_head_img = stu_head_img;
    }
}
