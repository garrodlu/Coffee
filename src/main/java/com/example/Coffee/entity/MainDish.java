package com.example.Coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mainDish")
public class MainDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    public MainDish(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MainDish{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
