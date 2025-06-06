package com.juanTrejo95.task_manager.service;

import com.juanTrejo95.task_manager.model.Task;
import com.juanTrejo95.task_manager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; 

import java.util.List;
import java.util.Optional;

public class TaskServiceTest {

    private final TaskRepository repository = mock(TaskRepository.class);
    private final TaskService service = new TaskService(repository);

    @Test
    void testGetAllTasks() {
        when(repository.findAll()).thenReturn(List.of(new Task()));
        assertEquals(1, service.getAllTasks().size());
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        when(repository.save(task)).thenReturn(task);
        assertEquals(task, service.createTask(task));
    }

    @Test
    void testGetTaskById() {
        Task task = new Task();
        when(repository.findById(1L)).thenReturn(Optional.of(task));
        assertTrue(service.getTaskById(1L).isPresent());
    }
}
