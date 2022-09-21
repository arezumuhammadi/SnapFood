package com.bootcamp.snapfood.order_item;

import java.util.List;

public interface IOrderItemService {

    OrderItem save(OrderItem item);

    OrderItem add(Long id);

    OrderItem minus(Long id);

    void delete(Long id);

    List<OrderItem> findAll();
}
