package com.bootcamp.snapfood.address;

import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.user.User;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_address")
@Data
@Audited
public class Address extends BaseEntity {
    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;





    @ManyToOne
    private User user;

}
