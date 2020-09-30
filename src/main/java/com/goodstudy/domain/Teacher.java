package com.goodstudy.domain;
/*
* 刘美琦
* */
public class Teacher {
    private int tId;
    private String tName;
    private String tGender;
    private String hiredate;
    private String tPhone;
    private String tInfo;
    private String tUsername;
    private String tPwd;
    private String tHeadImg;
    private int role;
    private int tState;
    private String certificate;
    private String certificateImg;
    public Teacher() {
    }

    public Teacher(int tId, String tName, String tGender, String hiredate, String tPhone, String tInfo, String tUsername, String tPwd, String tHeadImg, int role, int tState, String certificate, String certificateImg) {
        this.tId = tId;
        this.tName = tName;
        this.tGender = tGender;
        this.hiredate = hiredate;
        this.tPhone = tPhone;
        this.tInfo = tInfo;
        this.tUsername = tUsername;
        this.tPwd = tPwd;
        this.tHeadImg = tHeadImg;
        this.role = role;
        this.tState = tState;
        this.certificate = certificate;
        this.certificateImg = certificateImg;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettGender() {
        return tGender;
    }

    public void settGender(String tGender) {
        this.tGender = tGender;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public String gettInfo() {
        return tInfo;
    }

    public void settInfo(String tInfo) {
        this.tInfo = tInfo;
    }

    public String gettUsername() {
        return tUsername;
    }

    public void settUsername(String tUsername) {
        this.tUsername = tUsername;
    }

    public String gettPwd() {
        return tPwd;
    }

    public void settPwd(String tPwd) {
        this.tPwd = tPwd;
    }

    public String gettHeadImg() {
        return tHeadImg;
    }

    public void settHeadImg(String tHeadImg) {
        this.tHeadImg = tHeadImg;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int gettState() {
        return tState;
    }

    public void settState(int tState) {
        this.tState = tState;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCertificateImg() {
        return certificateImg;
    }

    public void setCertificateImg(String certificateImg) {
        this.certificateImg = certificateImg;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tGender='" + tGender + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", tPhone='" + tPhone + '\'' +
                ", tInfo='" + tInfo + '\'' +
                ", tUsername='" + tUsername + '\'' +
                ", tPwd='" + tPwd + '\'' +
                ", tHeadImg='" + tHeadImg + '\'' +
                ", role=" + role +
                ", tState=" + tState +
                ", certificate='" + certificate + '\'' +
                ", certificateImg='" + certificateImg + '\'' +
                '}';
    }
}
