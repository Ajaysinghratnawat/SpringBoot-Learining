package com.prod_ready_feature.prod_ready_feeature.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class) //Start auditing
@Audited
public class AuditableEntity {
    @CreatedDate //Audit
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate //Audit
    private LocalDateTime updatedDate;

    @CreatedBy //Audit
    private String createdBy;

    @LastModifiedBy //Audit
    private String updatedBy;
}
