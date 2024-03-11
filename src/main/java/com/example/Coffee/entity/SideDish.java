package com.example.Coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sideDish")
public class SideDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Description")
    private String description;

    public SideDish(String description) {
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
        return "SideDish{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
