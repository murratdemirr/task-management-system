package com.demir.tms.control;

import com.demir.tms.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User: muratdemir
 * Date: 1.05.2018
 * Time: 18:44
 */
public interface TaskRepository  extends PagingAndSortingRepository<Task, String> {

    Page findAll(Pageable pageable);

}
