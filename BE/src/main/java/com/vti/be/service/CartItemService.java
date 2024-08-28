package com.vti.be.service;

import com.vti.be.dto.CartItemDTO;
import com.vti.be.entity.CartItem;
import com.vti.be.repository.ICartItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {

    private final ICartItemRepository cartItemRepository;
    private final ModelMapper modelMapper;

    @Override
    public CartItemDTO createCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = modelMapper.map(cartItemDTO, CartItem.class);
        cartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(cartItem, CartItemDTO.class);
    }

    @Override
    public CartItemDTO updateCartItem(Integer id, CartItemDTO cartItemDTO) {
        CartItem existingCartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        modelMapper.map(cartItemDTO, existingCartItem);
        existingCartItem = cartItemRepository.save(existingCartItem);
        return modelMapper.map(existingCartItem, CartItemDTO.class);
    }

    @Override
    public CartItemDTO getCartItemById(Integer id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        return modelMapper.map(cartItem, CartItemDTO.class);
    }

    @Override
    public List<CartItemDTO> getAllCartItemsByUserId(Integer userId) {
        List<CartItem> cartItems = cartItemRepository.findAllByAccountId(userId);
        return cartItems.stream()
                .map(cartItem -> modelMapper.map(cartItem, CartItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CartItemDTO> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems.stream()
                .map(cartItem -> modelMapper.map(cartItem, CartItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCartItemById(Integer id) {
        cartItemRepository.deleteById(id);
    }
}