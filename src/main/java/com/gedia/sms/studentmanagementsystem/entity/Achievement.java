package com.gedia.sms.studentmanagementsystem.entity;

import java.util.Date;

/**
 * 成绩
 *
 * @author jiwenquan
 * @create 2018/6/28 11:33
 */
public class Achievement {
    /**
     * 主键id
     */
    private String id;
    /**
     * 考试
     */
    private String examination;
    /**
     * 科目
     */
    private String subject;
    /**
     * 学生
     */
    private String student;
    /**
     * 成绩（分数）
     */
    private Double achievement;
    /**
     * 年级
     */
    private String grade;
    private Date created;
    private Date updated;
    private String createUser;
    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Double getAchievement() {
        return achievement;
    }

    public void setAchievement(Double achievement) {
        this.achievement = achievement;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
