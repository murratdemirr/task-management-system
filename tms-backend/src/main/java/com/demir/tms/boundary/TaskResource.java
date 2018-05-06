package com.demir.tms.boundary;

import com.demir.tms.AbstractRestHandler;
import com.demir.tms.DataFormatException;
import com.demir.tms.ResourceNotFoundException;
import com.demir.tms.control.TaskRepository;
import com.demir.tms.entity.Task;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * User: muratdemir
 * Date: 1.05.2018
 * Time: 18:45
 */

@CrossOrigin
@Controller
@RequestMapping("api/v1/tasks")
public class TaskResource extends AbstractRestHandler {

    @Inject
    TaskRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all tasks.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 10)")
    public @ResponseBody
    ResponseEntity<Page<Task>> getAllTask(
            @ApiParam(value = "The page number (zero-based)", required = true)
            @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
            @ApiParam(value = "Tha page size", required = true)
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size) {
        Page<Task> all = this.repository.findAll(new PageRequest(page, size));
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single task.", notes = "You have to provide a valid task ID.")
    public @ResponseBody
    Task getTask(@ApiParam(value = "The ID of the task.", required = true) @PathVariable("id") String id) {
        Optional<Task> byId = this.repository.findById(id);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("resource not found");
        }
        return byId.get();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a task resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createTask(@RequestBody Task task,
                            HttpServletRequest request, HttpServletResponse response) {
        Task created = this.repository.save(task);
        response.setHeader("Location", request.getRequestURL().append("/").append(created.getId()).toString());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a task resource.", notes = "You have to provide a valid task ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateTask(@ApiParam(value = "The ID of the existing task resource.", required = true) @PathVariable("id") String id, @RequestBody Task task) {
        Optional<Task> byId = this.repository.findById(id);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("resource not found");
        }
        if (id != byId.get().getId()) throw new DataFormatException("ID doesn't match!");
        this.repository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a task resource.", notes = "You have to provide a valid task ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteTask(@ApiParam(value = "The ID of the existing task resource.", required = true) @PathVariable("id") String id) {
        Optional<Task> byId = this.repository.findById(id);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("resource not found");
        }
        this.repository.deleteById(id);
    }




}
