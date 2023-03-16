package com.danielandres.demoapirest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private String category;
    private float price;
    private float discount;
    private float taxes;
    private boolean visible;
    private int stock;
    private String image;
    @Column(name = "creation_date")
    private LocalDate creationDate;
}
