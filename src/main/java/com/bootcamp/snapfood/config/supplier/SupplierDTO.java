package com.bootcamp.snapfood.config.supplier;

import com.bootcamp.snapfood.category.Category;
import com.bootcamp.snapfood.common.BaseDTO;
import com.bootcamp.snapfood.supplier_category.SupplierCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierDTO extends BaseDTO {


    @ApiModelProperty(required = true)
    private String title;
    @ApiModelProperty(required = true)
    private String image;

    @ApiModelProperty(hidden = true)
    private List<Category> categories;

    @ApiModelProperty(hidden = true)
    private SupplierCategory supplierCategory;

    @ApiModelProperty(hidden = true)
    private List<Category> Categories;


}
