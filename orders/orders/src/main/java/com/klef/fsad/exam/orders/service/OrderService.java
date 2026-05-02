package com.klef.fsad.exam.orders.service;

import com.klef.fsad.exam.orders.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long orderId);

    Order createOrder(Order order);

    Optional<Order> updateOrder(Long orderId, Order order);
}
