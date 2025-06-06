package com.juanTrejo95.task_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.juanTrejo95.task_manager.model.Task;
import com.juanTrejo95.task_manager.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository repository;
    
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task taskData) {
        Task task = repository.findById(id).orElseThrow();
        task.setTitle(taskData.getTitle());
        task.setDescription(taskData.getDescription());
        task.setCompleted(taskData.isCompleted());
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }    
    
}
