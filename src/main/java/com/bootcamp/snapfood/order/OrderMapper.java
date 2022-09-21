package com.bootcamp.snapfood.order;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTOs(List<Order> orders);
}
