package com.example.Coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sideDish")
public class SideDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_SideDish")
    private Long idSideDish;

    @Column(name = "Description")
    private String description;

    public SideDish() {
    }

    public SideDish(Long idSideDish, String description) {
        this.idSideDish = idSideDish;
        this.description = description;
    }

    public Long getIdSideDish() {
        return idSideDish;
    }

    public void setIdSideDish(Long idSideDish) {
        this.idSideDish = idSideDish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SideDish{" +
                "idSideDish=" + idSideDish +
                ", description='" + description + '\'' +
                '}';
    }
}
