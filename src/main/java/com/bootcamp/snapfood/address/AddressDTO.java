package com.bootcamp.snapfood.address;

import com.bootcamp.snapfood.common.BaseDTO;
import com.bootcamp.snapfood.user.User;
import lombok.Data;

import java.util.List;
@Data
public class AddressDTO extends BaseDTO {

    private String address;
    private LocationDTO location;
    private User user;
}
