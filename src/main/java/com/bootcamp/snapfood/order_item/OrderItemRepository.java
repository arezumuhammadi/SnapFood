package com.bootcamp.snapfood.order_item;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {
}
