package com.zevonfashion.backend.Repository;

import com.zevonfashion.backend.Entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {

    Optional<CartItemEntity> findByCartIdAndProductId(Long cartId, Long productId);

    List<CartItemEntity> findByCartId(Long cartId);

}
