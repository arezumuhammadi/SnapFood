package com.bootcamp.snapfood.order_item;

import com.bootcamp.snapfood.address.IAddressService;
import com.bootcamp.snapfood.common.exception.NotFoundException;
import com.bootcamp.snapfood.order.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemService implements IOrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem item) {
        return orderItemRepository.save(item);
    }

    @Override
    public OrderItem add(Long id) {
        OrderItem savedBefore = getById(id);
        savedBefore.setCount(savedBefore.getCount() + 1);
        return orderItemRepository.save(savedBefore);
    }

    @Override
    public OrderItem minus(Long id) {
        OrderItem savedBefore = getById(id);
        savedBefore.setCount(savedBefore.getCount() - 1);
        return orderItemRepository.save(savedBefore);
    }

    private OrderItem getById(Long id) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
        if (optionalOrderItem.isEmpty()) throw new NotFoundException("Order Item not found");
        return optionalOrderItem.get();
    }

    @Override
    public void delete(Long id) {
        OrderItem item = getById(id);
        orderItemRepository.delete(item);
    }

    @Override
    public List<OrderItem> findAll() {
        return (List<OrderItem>) orderItemRepository.findAll();
    }
}
