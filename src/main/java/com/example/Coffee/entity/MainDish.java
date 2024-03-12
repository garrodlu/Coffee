package com.example.Coffee.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "maindish")
public class MainDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_maindish")
    private Long idMainDish;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    private Menu menu;

    @ManyToMany
    @JoinTable(name ="complement_mainDish", joinColumns = @JoinColumn(name = "id_mainDish"), inverseJoinColumns = @JoinColumn(name = "id_sideDish"))
    private Set<SideDish> sideDishes;



}
