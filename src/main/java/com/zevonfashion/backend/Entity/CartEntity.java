package com.zevonfashion.backend.Entity;

import jakarta.persistence.*;

@Entity
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true, name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

}
