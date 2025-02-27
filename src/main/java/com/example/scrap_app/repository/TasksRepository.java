package com.example.scrap_app.repository;

import com.example.scrap_app.model.TasksModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends MongoRepository<TasksModel, String> {
}

