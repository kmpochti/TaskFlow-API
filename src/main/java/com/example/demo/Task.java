package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private boolean completed;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    public Task() {}

    public Task(String description,boolean completed,String title){
        this.description=description;
        this.completed=completed;
        this.title = title;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public boolean isCompleted() {return completed;}
    public void setCompleted(boolean completed) {this.completed = completed;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public LocalDateTime getCreatedAt() { return createdAt; }
}
