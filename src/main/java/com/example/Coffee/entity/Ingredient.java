package com.example.Coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long idIngredient;
    @Column(name = "description")
    private String description;

    public Ingredient() {
    }

    public Ingredient(Long idIngredient, String description) {
        this.idIngredient = idIngredient;
        this.description = description;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "idIngredient=" + idIngredient +
                ", description='" + description + '\'' +
                '}';
    }
}
