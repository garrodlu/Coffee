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

    public Poke() {
    }

    public Poke(Long idPoke, String description, Menu menu, Set<Ingredient> ingredients) {
        this.idPoke = idPoke;
        this.description = description;
        this.menu = menu;
        this.ingredients = ingredients;
    }

    public Long getIdPoke() {
        return idPoke;
    }

    public void setIdPoke(Long idPoke) {
        this.idPoke = idPoke;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Poke{" +
                "idPoke=" + idPoke +
                ", description='" + description + '\'' +
                ", menu=" + menu +
                ", ingredients=" + ingredients +
                '}';
    }
}
