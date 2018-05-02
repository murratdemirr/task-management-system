package com.demir.tms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * User: muratdemir
 * Date: 1.05.2018
 * Time: 18:36
 */

@Entity
@Table(name = "TASKS")
public class Task implements Serializable {

    private static final String PREFIX = "Task.";

    @Id
    @Column(name = "ID", length = 42)
    private String id;

    @Version
    private Long version;

    @Column(name = "CREATED_DATE")
    private LocalDate creaatedDate;

    @Column(name = "UPDATED_DATE")
    private LocalDate uptadedDate;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "RESOLVED_DATE")
    private LocalDate resoolvedDate;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRIORTY")
    private Integer priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDate getCreaatedDate() {
        return creaatedDate;
    }

    public void setCreaatedDate(LocalDate creaatedDate) {
        this.creaatedDate = creaatedDate;
    }

    public LocalDate getUptadedDate() {
        return uptadedDate;
    }

    public void setUptadedDate(LocalDate uptadedDate) {
        this.uptadedDate = uptadedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getResoolvedDate() {
        return resoolvedDate;
    }

    public void setResoolvedDate(LocalDate resoolvedDate) {
        this.resoolvedDate = resoolvedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
