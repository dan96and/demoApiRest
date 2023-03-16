package com.danielandres.demoapirest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    private String password;
    private String NIF;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String city;
    private String postalCode;
    private String province;
    private String country;
    private String image;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "last_login")
    private LocalDate lastLogin;
    private boolean active;

    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "user")
    private Set<Invoice> orders;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
