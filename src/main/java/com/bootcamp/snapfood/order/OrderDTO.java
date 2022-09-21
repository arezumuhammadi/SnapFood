package com.bootcamp.snapfood.order;

import com.bootcamp.snapfood.address.Address;
import com.bootcamp.snapfood.order_item.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class OrderDTO {

    private OrderStatus orderStatus;
    private List<OrderItem> items;
    private Address address;
    private BigDecimal totalPrice;
}
