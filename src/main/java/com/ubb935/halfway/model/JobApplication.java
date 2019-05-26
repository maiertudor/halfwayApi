package com.ubb935.halfway.model;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Laura on 1/12/2018.
 */
@Entity(name = "applications")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class JobApplication extends BaseEntity {

    @ManyToOne
    @CreatedBy
    @JoinColumn(name = "provider_id")
    private Account provider;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "job_id")
    private Job job;

    @CreatedDate
    private Date createdAt;
}
