package com.goodstudy.domain;

/*
 * 孙向锋
 * */
public class Student {
    private int stuId;
    private String stuName;
    private String stuGender;
    private String stuBirthday;
    private String stuUsername;
    private String stuPwd;
    private String stuEmail;
    private String stuHeadImg;

    //空构造
    public Student() {
    }
//有参构造

    public Student(int stuId) {
        this.stuId = stuId;
    }

    public Student(int stuId, String stuName, String stuGender, String stuBirthday, String stuUserName, String stuPwd, String stuEmail, String stuHeadImg) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuBirthday = stuBirthday;
        this.stuUsername = stuUserName;
        this.stuPwd = stuPwd;
        this.stuEmail = stuEmail;
        this.stuHeadImg = stuHeadImg;
    }

    public Student(String stuName, String stuGender, String stuBirthday, String stuUsername, String stuPwd, String stuEmail, String stuHeadImg) {
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuBirthday = stuBirthday;
        this.stuUsername = stuUsername;
        this.stuPwd = stuPwd;
        this.stuEmail = stuEmail;
        this.stuHeadImg = stuHeadImg;
    }

    //toString方法

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuBirthday='" + stuBirthday + '\'' +
                ", stuUsername='" + stuUsername + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuHeadImg='" + stuHeadImg + '\'' +
                '}';
    }


//grt和set方法

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuUsername() {
        return stuUsername;
    }

    public void setStuUserName(String stuUsername) {
        this.stuUsername = stuUsername;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuHeadImg() {
        return stuHeadImg;
    }

    public void setStuHeadImg(String stuHeadImg) {
        this.stuHeadImg = stuHeadImg;
    }

}
