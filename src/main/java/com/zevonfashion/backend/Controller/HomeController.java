package com.zevonfashion.backend.Controller;

import com.zevonfashion.backend.Dtos.ProductResponseDto;
import com.zevonfashion.backend.Service.HomePageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/")
public class HomeController {

    private final HomePageService homePageService;

    public HomeController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping()
    public Map<String, List<ProductResponseDto>> getLatestProducts() {
        return homePageService.getLatestProducts();
    }

}
