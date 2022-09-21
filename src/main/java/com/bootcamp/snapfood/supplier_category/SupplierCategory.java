package com.bootcamp.snapfood.supplier_category;

import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.config.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Data
@Audited
@Entity
@Table()
public class SupplierCategory extends BaseEntity {
    private String title;
    private String icon_image;

    @ManyToOne
    private Supplier supplier;

    @OneToMany
    private List<Supplier> suppliers;


}
