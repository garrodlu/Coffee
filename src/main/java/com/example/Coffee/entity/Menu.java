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

    @Column(name="dish1")
    private String dish1;
    @Column(name="dish2")
    private String dish2;
    @Column(name="dish3")
    private String dish3;
    @Column(name="dish4")
    private String dish4;

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

    public String getDish1() {
        return dish1;
    }

    public void setDish1(String dish1) {
        this.dish1 = dish1;
    }

    public String getDish2() {
        return dish2;
    }

    public void setDish2(String dish2) {
        this.dish2 = dish2;
    }

    public String getDish3() {
        return dish3;
    }

    public void setDish3(String dish3) {
        this.dish3 = dish3;
    }

    public String getDish4() {
        return dish4;
    }

    public void setDish4(String dish4) {
        this.dish4 = dish4;
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
                ", dish1='" + dish1 + '\'' +
                ", dish2='" + dish2 + '\'' +
                ", dish3='" + dish3 + '\'' +
                ", dish4='" + dish4 + '\'' +
                ", price=" + price +
                '}';
    }
}
