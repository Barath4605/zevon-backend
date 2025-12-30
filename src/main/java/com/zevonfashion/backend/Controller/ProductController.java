package com.zevonfashion.backend.Controller;

import com.zevonfashion.backend.Dtos.ProductResponseDto;
import com.zevonfashion.backend.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/")
public class ProductController {

    private final ProductService productWatchService;

    public ProductController(ProductService productWatchService) {
        this.productWatchService = productWatchService;
    }

    @GetMapping("/{categoryName}")
    public List<ProductResponseDto> getProductsByCategory(@PathVariable String categoryName) {
        return productWatchService.getProductsByCategory(categoryName);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        ProductResponseDto product = productWatchService.getProductById(id);

        return ResponseEntity.ok(product);
    }
}
