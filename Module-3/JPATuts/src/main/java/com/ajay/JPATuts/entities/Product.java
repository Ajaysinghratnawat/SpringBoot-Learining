package com.ajay.JPATuts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Product_Table",uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique",columnNames = {"sku"})
},indexes = {
        @Index(name = "sku_index",columnList = "sku")
}
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String sku;

    @Column(name = "title_text")
    private String title;
    private BigDecimal price;
    private Integer quntity;

    @CreationTimestamp
    private LocalDateTime ceatedAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
