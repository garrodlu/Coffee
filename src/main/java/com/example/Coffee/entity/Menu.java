package com.example.Coffee.entity;

import com.sun.tools.javac.Main;
import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.ForeignKeyDescriptor;

import java.util.Set;

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Long idMenu;
    @Column(name = "Day of Week")
    private String dayOfWeek;

    @OneToMany(mappedBy = "menu")
    private Set<MainDish> mainDishes;
    @OneToMany(mappedBy = "menu")
    private Set<Poke> pokes;
    @Column(name = "Price")
    private double price;
    @Column(name = "Drink")
    private String drink;



}
