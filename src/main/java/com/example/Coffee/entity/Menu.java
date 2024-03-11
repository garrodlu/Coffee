package com.example.Coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;
    private String drink;
    @ManyToOne
    @JoinColumn(name = "id_mainDish")
    private MainDish mainDish;
    private String dayOfWeek;

}
