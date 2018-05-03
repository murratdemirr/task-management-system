package com.demir.tms.control;

import com.demir.tms.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: muratdemir
 * Date: 1.05.2018
 * Time: 18:44
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String>, TaskRepositoryCustom {


}
