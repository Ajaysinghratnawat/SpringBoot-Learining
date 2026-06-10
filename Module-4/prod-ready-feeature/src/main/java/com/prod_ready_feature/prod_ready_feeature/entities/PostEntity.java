package com.prod_ready_feature.prod_ready_feeature.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private String description;
}
