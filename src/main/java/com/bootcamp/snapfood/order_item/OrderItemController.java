package com.bootcamp.snapfood.order_item;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/OrderItem/")
@AllArgsConstructor
public class OrderItemController {
    private final IOrderItemService orderItemService;

    private OrderItemMapper orderItemMapper;

    @PostMapping
    public ResponseEntity<Void> saveSupplierCategory(@RequestBody OrderItemDTO dto) {
        OrderItem item = orderItemMapper.toOrderItem(dto);
        orderItemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderItemService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<OrderItemDTO> add(@PathVariable Long id) {
        OrderItemDTO itemDTO = orderItemMapper.toOrderItemDTO(orderItemService.add(id));
        return ResponseEntity.ok(itemDTO);
    }

    @PutMapping("/minus/{id}")
    public ResponseEntity<OrderItemDTO> minus(@PathVariable Long id) {
        OrderItemDTO itemDTO = orderItemMapper.toOrderItemDTO(orderItemService.minus(id));
        return ResponseEntity.ok(itemDTO);
    }


    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> findAll() {
        val items = orderItemService.findAll();
        return ResponseEntity.ok(orderItemMapper.toOrderItemDTOs(items));
    }


}
