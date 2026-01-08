package com.zevonfashion.backend.Repository;

import com.zevonfashion.backend.Entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
}
