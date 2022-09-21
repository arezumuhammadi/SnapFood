package com.bootcamp.snapfood.order;

import java.util.List;

public interface IOrderService {

    Order save(Order order);
    Order update(Order order);
    void delete(Long id);
    Order getById(Long id);
    List<Order> findAll();
}
