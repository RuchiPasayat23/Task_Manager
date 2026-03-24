package com.example.Task_Manager.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    // ✅ ADD THIS (User relation)
    @ManyToOne
    private User user;

    // getters setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    // ✅ ADD THESE (IMPORTANT 🔥)
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}