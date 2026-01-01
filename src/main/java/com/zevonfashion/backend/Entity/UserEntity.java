package com.zevonfashion.backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Size(min = 1, max = 20)
    @Column(nullable = false, name = "displayName")
    private String displayName;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Size(min = 8, max = 255)
    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

}
