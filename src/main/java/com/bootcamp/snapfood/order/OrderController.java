package com.bootcamp.snapfood.order;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/")
@AllArgsConstructor
public class OrderController {
    private IOrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderDTO orderDTO) {
        val order = orderMapper.toOrder(orderDTO);
        orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO) {
        val order = orderMapper.toOrder(orderDTO);
        val dto = orderMapper.toOrderDTO(orderService.update(order));
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        val orderDTO = orderMapper.toOrderDTO(orderService.getById(id));
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        val orderDTOS = orderMapper.toOrderDTOs(orderService.findAll());
        return ResponseEntity.ok(orderDTOS);
    }
}
