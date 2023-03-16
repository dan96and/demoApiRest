package com.danielandres.demoapirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private String category;
    private float price;
    private float discount;
    private float taxes;
    private boolean visible;
    private int stock;
    private String image;
    private LocalDate creationDate;
}
