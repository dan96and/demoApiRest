package com.danielandres.demoapirest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Invoice")
@Table(name="invoices")
public class Invoice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private String name;
    private String surname;
    @Column(nullable = false)
    private String email;
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
    private float subTotal;
    private  float total;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "due_date")
    private  LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
