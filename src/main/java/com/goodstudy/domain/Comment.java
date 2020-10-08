package com.goodstudy.domain;

/**
 * 刘美琦
 */
public class Comment {
    private int commentId;
    private Student student;
    private int score;
    private String comment;
    private String commTime;
    private Course course;

    public Comment() {
    }

    public Comment(int commentId, Student student, int score, String comment, String commTime, Course course) {
        this.commentId = commentId;
        this.student = student;
        this.score = score;
        this.comment = comment;
        this.commTime = commTime;
        this.course = course;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommTime() {
        return commTime;
    }

    public void setCommTime(String commTime) {
        this.commTime = commTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CommentDao{" +
                "commentId=" + commentId +
                ", student=" + student +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", commTime='" + commTime + '\'' +
                ", course=" + course +
                '}';
    }
}
