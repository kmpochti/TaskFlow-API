package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private TaskDTO taskDto;

    @BeforeEach
    void setUp() {
        taskDto = new TaskDTO();
        taskDto.setTitle("Μάθημα Unit Testing");
        taskDto.setDescription("Να τελειώσω το project");
        taskDto.setCompleted(false);
    }

    @Test
    void createTask_ShouldReturnSavedTask() {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask(taskDto);

        assertNotNull(createdTask);
        assertEquals("Μάθημα Unit Testing", createdTask.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void updateTask_ShouldThrowException_WhenTaskNotFound() {
        Long id = 1L;
        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            taskService.updateTask(id, taskDto);
        });

        assertEquals("Task not found with id: " + id, exception.getMessage());
    }

}
