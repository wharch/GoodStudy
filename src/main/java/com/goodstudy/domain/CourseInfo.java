package com.goodstudy.domain;
/*
 * 孙向锋
 * */

public class CourseInfo {
    private int infoId;
    private String video;
    private String note;
    private Section section;
    private Course course;
    private int infoState;

    //无参
    public CourseInfo() {
    }


    //有参

    public CourseInfo(int infoId, String video, String note, Section section, Course course, int infoState) {
        this.infoId = infoId;
        this.video = video;
        this.note = note;
        this.section = section;
        this.course = course;
        this.infoState = infoState;
    }


    //toString方法

    @Override
    public String toString() {
        return "CourseInfo{" +
                "infoId=" + infoId +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", section=" + section +
                ", course=" + course +
                ", infoState=" + infoState +
                '}';
    }


    //get和set方法


    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getInfoState() {
        return infoState;
    }

    public void setInfoState(int infoState) {
        this.infoState = infoState;
    }
}
