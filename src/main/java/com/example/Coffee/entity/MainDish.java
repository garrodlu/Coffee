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

    public MainDish() {
    }

    public MainDish(Long idMainDish, String description, Menu menu, Set<SideDish> sideDishes) {
        this.idMainDish = idMainDish;
        this.description = description;
        this.menu = menu;
        this.sideDishes = sideDishes;
    }

    public Long getIdMainDish() {
        return idMainDish;
    }

    public void setIdMainDish(Long idMainDish) {
        this.idMainDish = idMainDish;
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

    public Set<SideDish> getSideDishes() {
        return sideDishes;
    }

    public void setSideDishes(Set<SideDish> sideDishes) {
        this.sideDishes = sideDishes;
    }

    @Override
    public String toString() {
        return "MainDish{" +
                "idMainDish=" + idMainDish +
                ", description='" + description + '\'' +
                ", menu=" + menu +
                ", sideDishes=" + sideDishes +
                '}';
    }
}
