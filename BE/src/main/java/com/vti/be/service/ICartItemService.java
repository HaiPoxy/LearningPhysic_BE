package com.vti.be.service;

import com.vti.be.dto.CartItemDTO;

import java.util.List;

public interface ICartItemService {
    CartItemDTO createCartItem(CartItemDTO cartItemDTO);

    CartItemDTO updateCartItem(Integer id, CartItemDTO cartItemDTO);

    CartItemDTO getCartItemById(Integer id);

    List<CartItemDTO> getAllCartItemsByUserId(Integer userId);

    List<CartItemDTO> getAllCartItems();

    void deleteCartItemById(Integer id);
}
