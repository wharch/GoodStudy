package com.goodstudy.domain;

/**
 * 刘美琦
 */
public class Collection {
    private int collectionId;
    private Course course;
    private Student student;

    public Collection() {
    }

    public Collection(int collectionId, Course course, Student student) {
        this.collectionId = collectionId;
        this.course = course;
        this.student = student;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collectionId=" + collectionId +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
