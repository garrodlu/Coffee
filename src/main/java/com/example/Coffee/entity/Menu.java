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

    public Menu() {
    }

    public Menu(Long idMenu, String dayOfWeek, Set<MainDish> mainDishes, Set<Poke> pokes, double price, String drink) {
        this.idMenu = idMenu;
        this.dayOfWeek = dayOfWeek;
        this.mainDishes = mainDishes;
        this.pokes = pokes;
        this.price = price;
        this.drink = drink;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Set<MainDish> getMainDishes() {
        return mainDishes;
    }

    public void setMainDishes(Set<MainDish> mainDishes) {
        this.mainDishes = mainDishes;
    }

    public Set<Poke> getPokes() {
        return pokes;
    }

    public void setPokes(Set<Poke> pokes) {
        this.pokes = pokes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", mainDishes=" + mainDishes +
                ", pokes=" + pokes +
                ", price=" + price +
                ", drink='" + drink + '\'' +
                '}';
    }
}
