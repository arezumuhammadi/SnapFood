package com.bootcamp.snapfood.config.supplier;

import com.bootcamp.snapfood.category.Category;
import com.bootcamp.snapfood.common.BaseEntity;
import com.bootcamp.snapfood.supplier_category.SupplierCategory;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_supplier")
@Data
@Audited
public class Supplier extends BaseEntity {



    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "image")
    private String image;



//    @OneToMany

    @OneToMany
    private List<Category> categories;

    @ManyToOne
    private SupplierCategory category;

    @OneToMany
    private List<Category> Categories;







}
