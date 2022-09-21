package com.bootcamp.snapfood.category;

import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.order_item.OrderItem;
import com.bootcamp.snapfood.config.supplier.Supplier;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO extends BaseEntity {

    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)
    private String image;

    @ApiModelProperty(required = true, hidden = false)
    private List<Supplier> suppliers;
}
