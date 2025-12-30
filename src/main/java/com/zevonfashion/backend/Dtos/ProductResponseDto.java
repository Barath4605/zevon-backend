package com.zevonfashion.backend.Dtos;

import java.math.BigDecimal;
import java.time.Instant;


public record ProductResponseDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        Integer stockLeft,
        Long categoryId,
        String categoryName,
        Instant createdAt
) {
}
