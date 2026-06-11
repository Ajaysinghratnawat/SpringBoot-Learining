package com.prod_ready_feature.prod_ready_feeature.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Entity
@Table(name="posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
//@EntityListeners(AuditingEntityListener.class) //Start auditing
public class PostEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    @NotAudited
    private String description;
}
