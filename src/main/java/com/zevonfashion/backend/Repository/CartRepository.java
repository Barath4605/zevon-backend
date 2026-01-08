package com.zevonfashion.backend.Repository;

import com.zevonfashion.backend.Entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
