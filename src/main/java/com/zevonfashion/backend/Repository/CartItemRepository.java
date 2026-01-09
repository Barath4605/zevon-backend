package com.zevonfashion.backend.Repository;

import com.zevonfashion.backend.Entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {

    Optional<CartItemEntity> findByCartIdAndProductId(Long cartId, Long productId);

    List<CartItemEntity> findByCartId(Long cartId);

    @Transactional
    @Modifying
    @Query("delete from CartItemEntity c")
    int deleteFirstBy();
}
