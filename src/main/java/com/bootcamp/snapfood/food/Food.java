package com.bootcamp.snapfood.food;

import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.order_item.OrderItem;
import com.bootcamp.snapfood.supplier_category.SupplierCategory;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "tbl_foods")
@Data
@Entity
public class Food extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private String price;



    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_category_id")
    private SupplierCategory supplierCategory;

    @OneToMany
    private List<OrderItem> orderItems;

}
