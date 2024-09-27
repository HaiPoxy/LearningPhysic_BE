//package com.vti.be.controller;
//
//
//import com.vti.be.dto.CartItemDTO;
//import com.vti.be.service.CartItemService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/cart-items")
//@RequiredArgsConstructor
//public class CartItemController {
//
//    private final CartItemService cartItemService;
//
//    @PostMapping
//    public ResponseEntity<CartItemDTO> createCartItem(@RequestBody CartItemDTO cartItemDTO) {
//        CartItemDTO createdCartItem = cartItemService.createCartItem(cartItemDTO);
//        return ResponseEntity.ok(createdCartItem);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Integer id, @RequestBody CartItemDTO cartItemDTO) {
//        CartItemDTO updatedCartItem = cartItemService.updateCartItem(id, cartItemDTO);
//        return ResponseEntity.ok(updatedCartItem);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CartItemDTO> getCartItemById(@PathVariable Integer id) {
//        CartItemDTO cartItem = cartItemService.getCartItemById(id);
//        return ResponseEntity.ok(cartItem);
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<CartItemDTO>> getAllCartItemsByUserId(@PathVariable Integer userId) {
//        List<CartItemDTO> cartItems = cartItemService.getAllCartItemsByUserId(userId);
//        return ResponseEntity.ok(cartItems);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CartItemDTO>> getAllCartItems() {
//        List<CartItemDTO> cartItems = cartItemService.getAllCartItems();
//        return ResponseEntity.ok(cartItems);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCartItemById(@PathVariable Integer id) {
//        cartItemService.deleteCartItemById(id);
//        return ResponseEntity.noContent().build();
//    }
//}