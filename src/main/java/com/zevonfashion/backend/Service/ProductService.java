package com.zevonfashion.backend.Service;

import com.zevonfashion.backend.Dtos.ProductResponseDto;
import com.zevonfashion.backend.Entity.ProductEntity;
import com.zevonfashion.backend.Exception.NotFoundException;
import com.zevonfashion.backend.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDto> getProductsByCategory(String categoryName) {
        List<ProductEntity> entities = productRepository.findAllByCategoryNameManual(categoryName);

        return entities.stream().map(entity -> new ProductResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImageUrl(),
                entity.getStockLeft(),
                (entity.getCategory() != null) ? entity.getCategory().getId() : null,
                (entity.getCategory() != null) ? entity.getCategory().getCategoryName() : null,
                entity.getCreatedAt()
        )).collect(Collectors.toList());
    }

    public ProductResponseDto getProductById(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Oops.. Product not found :("));

        return new ProductResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImageUrl(),
                entity.getStockLeft(),
                (entity.getCategory() != null) ? entity.getCategory().getId() : null,
                (entity.getCategory() != null) ? entity.getCategory().getCategoryName() : null,
                entity.getCreatedAt()
        );
    }
}
