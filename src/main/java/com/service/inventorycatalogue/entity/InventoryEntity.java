package com.service.inventorycatalogue.entity;

/**
 * Entity layer of Inventory Catalogue
 *
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_Id")
    private Long id;

    @Column(unique=true)
    private String sku;

    @Min(1)
    @Max(100)
    @Positive
    private int quantity;

    private String category;

    private String status;

    private Boolean communication;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;
}
