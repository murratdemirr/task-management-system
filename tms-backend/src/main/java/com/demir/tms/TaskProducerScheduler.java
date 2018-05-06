package com.demir.tms;

import com.demir.tms.control.TaskRepository;
import com.demir.tms.entity.Status;
import com.demir.tms.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * User: muratdemir
 * Date: 3.05.2018
 * Time: 22:49
 */

@Component
public class TaskProducerScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(TaskProducerScheduler.class);

    private static final Integer ID_RANGE = 9999;
    private static final Integer NEX_DAY_RANGE = 10;
    private static final Integer PRIORITY_RANGE = 99;


    @Inject
    TaskRepository repository;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Task task = new Task();
        task.setTitle("Issue-" + random(ID_RANGE));
        task.setDescription("As Demir, I want " + UUID.randomUUID().toString() + " so that ...");
        task.setStatus(Status.WAITING);
        task.setDueDate(LocalDateTime.now().plusDays(random(NEX_DAY_RANGE)));
        task.setPriority(random(PRIORITY_RANGE));
        repository.save(task);
        LOG.debug("Random a task created");
    }


    private Integer random(Integer range){
       return  new Random().nextInt(range);
    }


}
