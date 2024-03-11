package com.example.Coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mainDish")
public class MainDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Description")
    private String description;

    @ManyToOne(targetEntity = SideDish.class)
    @JoinColumn(name = "menu_SideDish")
    private SideDish sideDish;

    public MainDish(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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