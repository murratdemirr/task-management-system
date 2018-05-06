package com.demir.tms.entity;

import java.io.Serializable;
import java.util.List;

/**
 * User: muratdemir
 * Date: 6.05.2018
 * Time: 23:13
 */
public class TaskResult implements Serializable {

    private Long totalElements;
    private List<TaskDto> content;

    public TaskResult(Long totalElements, List<TaskDto> content) {
        this.totalElements = totalElements;
        this.content = content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<TaskDto> getContent() {
        return content;
    }

    public void setContent(List<TaskDto> content) {
        this.content = content;
    }
}
