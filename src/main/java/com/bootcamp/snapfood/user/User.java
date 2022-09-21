package com.bootcamp.snapfood.user;


import com.bootcamp.snapfood.address.Address;
import com.bootcamp.snapfood.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class User extends BaseEntity {

    private String name;
    private String phone;




    @OneToMany
    private List<Address> addresses;


}
