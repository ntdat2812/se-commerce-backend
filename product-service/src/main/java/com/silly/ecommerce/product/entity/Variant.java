package com.silly.ecommerce.product.entity;

import com.silly.ecommerce.common.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "variant")
@Entity
public class Variant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "variant_name")
    private String variantName;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "base_cost")
    private Double baseCost;

    @Column(name = "img_src")
    private String imgSrc;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
