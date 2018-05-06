package com.demir.tms.control;

import com.demir.tms.entity.Task;
import com.demir.tms.entity.TaskDto;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

/**
 * User: muratdemir
 * Date: 6.05.2018
 * Time: 23:05
 */

@Service
public class TaskMapper {

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";


    public TaskDto dto(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task can not be null");
        }
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().name());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        dto.setDueDate(formatter.format(task.getDueDate()));
        return dto;
    }

}
