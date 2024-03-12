package com.example.Coffee.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="poke")
public class Poke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poke")
    private Long idPoke;
    @Column(name = "description")
    private String description;
    @ManyToOne
    private Menu menu;
    @ManyToMany
    @JoinTable(name = "ingredients_poke", joinColumns = @JoinColumn(name = "id_poke"), inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private Set<Ingredient> ingredients;
}
