package com.demir.tms.control;

import com.demir.tms.entity.Task;
import com.demir.tms.entity.TaskDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User: muratdemir
 * Date: 6.05.2018
 * Time: 23:05
 */

@Service
public class TaskMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";


    public TaskDto dto(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task can not be null");
        }
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().name());
        dto.setPriority(task.getPriority());
        if (task.getDueDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            dto.setDueDate(formatter.format(task.getDueDate()));
        }
        return dto;
    }

    public LocalDateTime localDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(date, formatter).atStartOfDay();
    }

}
