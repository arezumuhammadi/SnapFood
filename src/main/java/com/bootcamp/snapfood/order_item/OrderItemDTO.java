package com.bootcamp.snapfood.order_item;

import com.bootcamp.snapfood.category.Category;
import com.bootcamp.snapfood.order.Order;
import lombok.Data;

@Data
public class OrderItemDTO {

    private Integer count;

    private Category category;

    private Order order;
}
