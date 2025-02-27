package com.example.scrap_app.controller;

import com.example.scrap_app.model.TasksModel;
import com.example.scrap_app.service.TasksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TasksController {

    @Autowired
    private TasksService taskService;

    @PostMapping("/tasks/create-task")
    public ResponseEntity<Map<String, String>> createTask(@Valid @RequestBody TasksModel task) {
        taskService.create(task);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Task created successfully");
        response.put("code", "201");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tasks/get-all")
    public ResponseEntity<Map<String, Object>> getTasks() {
        List<TasksModel> data = taskService.getAll();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "All tasks retrieved");
        response.put("code", "200");
        response.put("data", data);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/tasks/delete-task")
    public ResponseEntity<Map<String, String>> deleteTask(@RequestParam String id) {
        taskService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Task deleted successfully");
        response.put("code", "200");

        return ResponseEntity.ok(response);
    }
}