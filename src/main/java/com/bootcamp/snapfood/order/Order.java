package com.bootcamp.snapfood.order;

import com.bootcamp.snapfood.address.Address;
import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.order_item.OrderItem;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_order")
@Audited
@Data
public class Order extends BaseEntity {


    private OrderStatus orderStatus;
    private String user;
    private BigDecimal totalPrice;


    @OneToMany
    private List<OrderItem> items;

    @ManyToOne
    private Address address;

}
