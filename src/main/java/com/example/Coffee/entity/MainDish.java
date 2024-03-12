package com.example.Coffee.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "mainDish")
public class MainDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @ManyToMany
    @JoinTable(name ="complement_mainDish", joinColumns = @JoinColumn(name = "id_mainDish"), inverseJoinColumns = @JoinColumn(name = "id_sideDish"))
    private Set<SideDish> sideDishes;

}
