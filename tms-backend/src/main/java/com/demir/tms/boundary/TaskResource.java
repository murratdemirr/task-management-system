package com.demir.tms.boundary;

import com.demir.tms.control.TaskService;
import com.demir.tms.entity.Task;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: muratdemir
 * Date: 1.05.2018
 * Time: 18:45
 */

@Controller
@RequestMapping("api/v1/tasks")
public class TaskResource {

    @Inject
    TaskService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all tasks.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 10)")
    public @ResponseBody
    Page<Task> getAllHotel(
            @ApiParam(value = "The page number (zero-based)", required = true)
            @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
            @ApiParam(value = "Tha page size", required = true)
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size,
            HttpServletRequest request, HttpServletResponse response) {
        return this.service.findAll(page, size);
    }
}
