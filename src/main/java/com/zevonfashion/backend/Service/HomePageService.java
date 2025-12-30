package com.zevonfashion.backend.Service;

import com.zevonfashion.backend.Dtos.ProductResponseDto;
import com.zevonfashion.backend.Entity.ProductEntity;
import com.zevonfashion.backend.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomePageService {

    private final ProductRepository productRepository;

    public HomePageService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<String, List<ProductResponseDto>> getLatestProducts() {

        Map<String, List<ProductResponseDto>> data = new HashMap<>();

        data.put("newlyLaunched", mapToDto(productRepository.findTop5ByOrderByCreatedAtDesc()));
        data.put("watches", mapToDto(productRepository.findTop4ByCategory_CategoryNameOrderByStockLeftAsc("WATCH")));
        data.put("pendants", mapToDto(productRepository.findTop4ByCategory_CategoryNameOrderByStockLeftAsc("PENDANT")));
        data.put("shades", mapToDto(productRepository.findTop4ByCategory_CategoryNameOrderByStockLeftAsc("SHADES")));

        return data;
    }

    private List<ProductResponseDto> mapToDto(List<ProductEntity> entities) {
        return entities.stream().map(p -> new ProductResponseDto(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getImageUrl(),
                p.getStockLeft(),
                p.getCategory().getId(),
                p.getCategory().getCategoryName(),
                p.getCreatedAt()
        )).toList();
    }
}
