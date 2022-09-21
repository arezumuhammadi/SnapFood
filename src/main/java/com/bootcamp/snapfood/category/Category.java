package com.bootcamp.snapfood.category;

import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.order_item.OrderItem;
import com.bootcamp.snapfood.config.supplier.Supplier;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_category")
@Data
public class Category extends BaseEntity {


    @NotNull
    @Column(name = "titel")
    private String title;

    @NotNull
    @Column(name = "image")
    private String image;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Supplier> suppliers;


}
