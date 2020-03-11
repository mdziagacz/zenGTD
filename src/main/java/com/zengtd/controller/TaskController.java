package com.zengtd.controller;

import com.zengtd.domain.TaskDto;
import com.zengtd.mapper.TaskMapper;
import com.zengtd.service.DbService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class TaskController {
    private DbService dbService;
    private TaskMapper taskMapper;

    public TaskController(DbService dbService, TaskMapper taskMapper) {
        this.dbService = dbService;
        this.taskMapper = taskMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto){
        dbService.saveTask(taskMapper.mapToTask(taskDto));
    }

    @GetMapping
    public List<TaskDto> getAllTasks(){
        return taskMapper.mapToListTaskDto(dbService.getAllTasks());
    }
}
