package com.example.Coffee.entity;

import com.sun.tools.javac.Main;
import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.ForeignKeyDescriptor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Long idMenu;
    @Column(name = "Day")
    private LocalDate day;

    @Column(name="Dishes")
    private Set<String> dishes;

    @Column(name = "Price")
    private double price;


    public Menu() {
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Set<String> getDishes() {
        return dishes;
    }

    public void setDishes(Set<String> dishes) {
        this.dishes = dishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", day=" + day +
                ", dishes=" + dishes +
                ", price=" + price +
                '}';
    }
}
