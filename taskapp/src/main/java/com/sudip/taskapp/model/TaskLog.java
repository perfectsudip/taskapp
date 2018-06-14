package com.sudip.taskapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class TaskLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
    private int storyNumber;
    private  String projectTask;
    private  String taskDetail;
    private Date datePost;
 private   int hours;
    @OneToOne
    User user;

    public TaskLog(int id, int storyNumber, String projectTask, String taskDetail, Date datePost, int hours, User user) {
        this.id = id;
        this.storyNumber = storyNumber;
        this.projectTask = projectTask;
        this.taskDetail = taskDetail;
        this.datePost = datePost;
        this.hours = hours;
        this.user = user;
    }

    public TaskLog() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoryNumber() {
        return storyNumber;
    }

    public void setStoryNumber(int storyNumber) {
        this.storyNumber = storyNumber;
    }

    public String getProjectTask() {
        return projectTask;
    }

    public void setProjectTask(String projectTask) {
        this.projectTask = projectTask;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


}
