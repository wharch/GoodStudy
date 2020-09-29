package com.goodstudy.domain;
/*
* 孙向锋
* */

public class CourseInfo {
    private int info_id;
    private String video;
    private String note;
    private Section section;
    private Course course;
    //无参

    public CourseInfo() {
    }
    //有参

    public CourseInfo(int info_id, String video, String note, Section section, Course course) {
        this.info_id = info_id;
        this.video = video;
        this.note = note;
        this.section = section;
        this.course = course;
    }
    //toString方法

    @Override
    public String toString() {
        return "Course_Info{" +
                "info_id=" + info_id +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", section=" + section +
                ", course=" + course +
                '}';
    }
    //get和set方法

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
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
