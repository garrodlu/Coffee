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
    private Long id;
    @Column(name = "Price")
    private double price;
    @Column(name = "Drink")
    private String drink;
    @ManyToMany(targetEntity = MainDish.class)
    @JoinTable(name="menu_mainDish")
    private Set<MainDish> mainDishes;
    @ManyToMany(targetEntity = SideDish.class)
    @JoinTable(name="menu_sideDish")
    private Set<SideDish> sideDishes;
    @Column(name = "Day of Week")
    private String dayOfWeek;



}
