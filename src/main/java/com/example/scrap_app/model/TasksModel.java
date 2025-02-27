package com.example.scrap_app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksModel {

    @Id
    private String id;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotBlank(message = "Recipient cannot be empty")
    private String recipient;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotNull(message = "End date cannot be empty")
    private LocalDateTime endDate;
}