package com.bootcamp.snapfood.order_item;

import com.bootcamp.snapfood.category.Category;
import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.order.Order;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_order_item")
@Audited
public class OrderItem extends BaseEntity {
    private Integer count;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Order order;
}
