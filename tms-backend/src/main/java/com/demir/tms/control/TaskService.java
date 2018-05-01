package com.demir.tms.control;

import com.demir.tms.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * User: muratdemir
 * Date: 1.05.2018
 * Time: 19:09
 */

@Service
public class TaskService {

    @Inject
    TaskRepository repository;

    public Page<Task> findAll(Integer page, Integer size) {
        return repository.findAll(new PageRequest(page, size));
    }
}
