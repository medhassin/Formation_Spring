package com.zeus.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name", nullable = false, length = 100)
    private String name;
    private String description;
    private double price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;
    @Temporal(TemporalType.DATE)
    private LocalDate updatedAt;
}
