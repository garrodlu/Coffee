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

}
