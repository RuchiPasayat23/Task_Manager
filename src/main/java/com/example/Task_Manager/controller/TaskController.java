package com.example.Task_Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Task_Manager.model.Task;
import com.example.Task_Manager.model.User;
import com.example.Task_Manager.repository.TaskRepository;
import com.example.Task_Manager.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    // ✅ FIXED ROOT (IMPORTANT)
    @GetMapping
    public String home() {
        return "Task Controller Working ";
    }

    // CREATE TASK
    @PostMapping("/{userId}")
    public Task createTask(@PathVariable Long userId, @RequestBody Task task) {
        User user = userRepo.findById(userId).orElseThrow();
        task.setUser(user);
        return taskRepo.save(task);
    }

    // GET ALL TASKS
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepo.findById(id).orElseThrow();
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task newTask) {
        Task task = taskRepo.findById(id).orElseThrow();

        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());

        return taskRepo.save(task);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
        return "Task deleted successfully";
    }
}