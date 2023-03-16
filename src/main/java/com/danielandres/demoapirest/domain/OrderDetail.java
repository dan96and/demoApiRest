package com.danielandres.demoapirest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orderDetail")
@Table(name = "orders_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    private float prices;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany
    @JoinColumn (name = "product_id")
    private Set<Product> products;
}
