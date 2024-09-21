package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/api/tasks/{taskId}")
    public String getTaskById(@PathVariable String taskId) {
        return "Task with ID: " + taskId;
    }
}
