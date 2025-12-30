package com.zevonfashion.backend.Repository;

import com.zevonfashion.backend.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findTop5ByOrderByCreatedAtDesc();

    List<ProductEntity> findTop4ByCategory_CategoryNameOrderByStockLeftAsc(String categoryName);

    @Query("SELECT p FROM ProductEntity p JOIN p.category c WHERE LOWER(c.categoryName) = LOWER(:categoryName)")
    List<ProductEntity> findAllByCategoryNameManual(@Param("categoryName") String categoryName);


}
