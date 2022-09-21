package com.bootcamp.snapfood.supplier_category;

import com.bootcamp.snapfood.common.BaseDTO;
import com.bootcamp.snapfood.config.supplier.Supplier;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierCategoryDTO extends BaseDTO {
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String icon_image;
    @ApiModelProperty(hidden = true)
    private List<Supplier> suppliers;

}