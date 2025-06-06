package com.juanTrejo95.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanTrejo95.task_manager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
