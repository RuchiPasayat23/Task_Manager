package com.example.Task_Manager.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    // ✅ RELATION WITH USER
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Default constructor
    public Task() {}

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ✅ THIS WAS MISSING
    public void setUser(User user) {
        this.user = user;
    }
}