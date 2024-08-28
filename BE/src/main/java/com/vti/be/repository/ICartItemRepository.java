package com.vti.be.repository;

import com.vti.be.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findAllByAccountId(Integer accountId);
}