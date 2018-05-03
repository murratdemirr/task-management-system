package com.demir.tms;

import com.demir.tms.control.TaskRepository;
import com.demir.tms.entity.Status;
import com.demir.tms.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
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


    @Inject
    TaskRepository repository;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Task task = new Task();
        task.setTitle("Issue-" + randomId());
        task.setDescription("As Demir, I want " + UUID.randomUUID().toString() + " so that ...");
        task.setStatus(Status.WAITING);
        repository.save(task);
        LOG.debug("Random a task created");
    }


    private Integer randomId(){
       return  new Random().nextInt(9999);
    }

}
