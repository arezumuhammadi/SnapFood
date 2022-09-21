package com.bootcamp.snapfood.food;

import com.bootcamp.snapfood.order_item.OrderItem;
import com.bootcamp.snapfood.supplier_category.SupplierCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FoodDTO {


    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private String price;

    @ApiModelProperty(required = true, hidden = false)
    private SupplierCategory supplierCategory;

    @ApiModelProperty(required = false, hidden = true)
    private List<OrderItem> orderItems;

    @ApiModelProperty(required = true, hidden = false)
    private String image;

}
