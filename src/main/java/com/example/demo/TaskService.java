package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Page<TaskDTO> getAllTasks(int page, int size, String sortBy) {
        logger.info("Ανάκτηση σελίδας {} με μέγεθος {} και ταξινόμηση ανά {}", page, size, sortBy);

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

        return taskRepository.findAll(pageable)
                .map(task -> new TaskDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted()
                ));
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