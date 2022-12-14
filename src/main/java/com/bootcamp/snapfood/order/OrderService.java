package com.bootcamp.snapfood.order;

import com.bootcamp.snapfood.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepository repository;

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Order update(Order order) {
        Order savedBefore = getById(order.getId());
        savedBefore.setOrderStatus(order.getOrderStatus());
        savedBefore.setTotalPrice(order.getTotalPrice());
        return repository.save(savedBefore);
    }

    @Override
    public void delete(Long id) {
        Order savedBefore = getById(id);
        repository.delete(savedBefore);
    }

    @Override
    public Order getById(Long id) {
        Optional<Order> optionalOrder = repository.findById(id);
        if (optionalOrder.isEmpty()) throw new NotFoundException("Not Found Order Exception");
        return optionalOrder.get();
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) repository.findAll();
    }
}
