package com.example.scrap_app.service;

import com.example.scrap_app.model.TasksModel;
import com.example.scrap_app.repository.TasksRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksRepository taskRepository;

    public List<TasksModel> getAll() {
        return taskRepository.findAll();
    }

    public void create(@Valid TasksModel task) {
        try {
            taskRepository.save(task);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while saving task", e);
        }
    }

    public void delete(String id) {
        if (!taskRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while deleting task", e);
        }
    }
}