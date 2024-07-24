package com.service.productcatalogue.entity;

/**
 * Entity layer of Associated details of the product
 *
 */

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class ProductAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "association_Id")
    private Long associationId;
    @Column(unique=true)
    private String sku;
    private String relatedProducts;
    private String bundleDeals;
    private String productVariations;
}
