package com.example.Coffee.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="menu")
public class Poke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;
    @ManyToMany
    @JoinTable(name = "ingredients_poke", joinColumns = @JoinColumn(name = "id_poke"), inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private Set<Ingredient> ingredients;
}
