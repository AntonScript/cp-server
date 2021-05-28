package com.example.cpserver.task.controller;

import com.example.cpserver.general.dto.Message;
import com.example.cpserver.task.controller.dto.CreateTaskDto;
import com.example.cpserver.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public Message createTheme(@RequestBody CreateTaskDto createTaskDto){
        return taskService.createTask(createTaskDto);
    }
}
