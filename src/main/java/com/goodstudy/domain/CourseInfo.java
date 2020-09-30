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
    //无参

    public CourseInfo() {
    }
    //有参

    public CourseInfo(int indoId, String video, String note, Section section, Course course) {
        this.infoId = indoId;
        this.video = video;
        this.note = note;
        this.section = section;
        this.course = course;
    }


    //toString方法

    @Override
    public String toString() {
        return "CourseInfo{" +
                "indoId=" + infoId +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", section=" + section +
                ", course=" + course +
                '}';
    }


    //get和set方法


    public int getIndoId() {
        return infoId;
    }

    public void setIndoId(int indoId) {
        this.infoId = indoId;
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
}
