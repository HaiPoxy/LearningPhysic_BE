package com.vti.be.service;

import com.vti.be.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Integer id, OrderDTO orderDTO);

    OrderDTO getOrderById(Integer id);

    List<OrderDTO> getAllOrdersByUserId(Integer userId);

    List<OrderDTO> getAllOrders();

    void deleteOrderById(Integer id);
}
