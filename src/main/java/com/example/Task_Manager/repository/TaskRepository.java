package com.example.Task_Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task_Manager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
