package com.bootcamp.snapfood.user;

import com.bootcamp.snapfood.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;


    @ApiModelProperty(required = true, hidden = false)
    private String phone;
}
