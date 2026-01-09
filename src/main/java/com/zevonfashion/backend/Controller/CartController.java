package com.zevonfashion.backend.Controller;

import com.zevonfashion.backend.Service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok("product added to cart");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateQuantity(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        cartService.updateQuantity(userId, productId, quantity);
        return ResponseEntity.ok("cart updated");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeItem(
            @RequestParam Long userId,
            @RequestParam Long productId
    ) {
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok("item removed");
    }
}
