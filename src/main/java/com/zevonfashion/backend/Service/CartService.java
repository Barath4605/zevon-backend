package com.zevonfashion.backend.Service;

import com.zevonfashion.backend.Entity.CartEntity;
import com.zevonfashion.backend.Entity.CartItemEntity;
import com.zevonfashion.backend.Entity.ProductEntity;
import com.zevonfashion.backend.Entity.UserEntity;
import com.zevonfashion.backend.Repository.CartItemRepository;
import com.zevonfashion.backend.Repository.CartRepository;
import com.zevonfashion.backend.Repository.ProductRepository;
import com.zevonfashion.backend.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartService(CartItemRepository cartItemRepository, CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void addToCart(Long userId, Long productId, int quantity) {

        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        CartEntity cart = cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
        CartItemEntity cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId).orElse(null);

        if (cartItem == null) {
            cartItem = new CartItemEntity();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setCart(cart);

            cartItemRepository.save(cartItem);
        } else {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    @Transactional
    public void removeFromCart(Long userId, Long productId) {

        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("cart not found"));

        CartItemEntity cartItem = cartItemRepository
                .findByCartIdAndProductId(cart.getId(), productId)
                .orElseThrow(() -> new RuntimeException("item not in cart"));

        cartItemRepository.delete(cartItem);
    }

    @Transactional
    public void updateQuantity(Long UserId, Long productId, int quantity) {

        CartEntity cart = cartRepository.findByUserId(UserId).orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItemEntity cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId).orElseThrow(() -> new RuntimeException("item not in cart"));

        if (quantity <= 0) {
            cartItemRepository.delete(cartItem);
        } else {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }

    }
}
