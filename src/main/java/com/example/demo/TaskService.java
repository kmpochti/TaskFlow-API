package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(TaskDTO taskDto) {
        logger.info("Προσπάθεια δημιουργίας νέας εργασίας: {}", taskDto.getTitle());
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        logger.warn("Διαγραφή εργασίας με ID: {}", id);
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, TaskDTO taskDto) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskDto.getTitle());
                    task.setDescription(taskDto.getDescription());
                    task.setCompleted(taskDto.isCompleted());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
}