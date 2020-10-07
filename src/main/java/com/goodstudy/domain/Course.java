package com.goodstudy.domain;

/**
 * 作者:wh
 * 课程实体类
 */
public class Course {
    private int cId;//课程编号
    private String cName;//课程名称
    private Kind kind;//类别类
    private Teacher teacher;//教师类
    private String cMaster;//课程缩略图
    private String cInfo;//课程简介
    private double cPrice;//课程价格
    private int cStatus;//课程状态

    public Course() {
    }

    public Course(int cId) {
        this.cId = cId;
    }

    public Course(int cId, String cName, Kind kind, Teacher teacher, String cMaster, String cInfo, double cPrice, int cStatus) {
        this.cId = cId;
        this.cName = cName;
        this.kind = kind;
        this.teacher = teacher;
        this.cMaster = cMaster;
        this.cInfo = cInfo;
        this.cPrice = cPrice;
        this.cStatus = cStatus;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getcMaster() {
        return cMaster;
    }

    public void setcMaster(String cMaster) {
        this.cMaster = cMaster;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public double getcPrice() {
        return cPrice;
    }

    public void setcPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public int getcStatus() {
        return cStatus;
    }

    public void setcStatus(int cStatus) {
        this.cStatus = cStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", kind=" + kind +
                ", teacher=" + teacher +
                ", cMaster='" + cMaster + '\'' +
                ", cInfo='" + cInfo + '\'' +
                ", cPrice=" + cPrice +
                ", cStatus=" + cStatus +
                '}';
    }
}
