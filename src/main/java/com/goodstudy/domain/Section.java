package com.goodstudy.domain;

/**
 * 作者:wh
 * 章节实体类
 */
public class Section {
    private int sectionId;//章节编号
    private String sectionName;//章节名称
    private Course course;//课程类

    public Section() {
    }

    public Section(int sectionId, String sectionName, Course course) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.course = course;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionName='" + sectionName + '\'' +
                ", course=" + course +
                '}';
    }
}
