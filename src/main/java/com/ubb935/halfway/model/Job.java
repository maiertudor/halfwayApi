package com.ubb935.halfway.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Laura on 10/30/2017.
 */
@Entity(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Job extends BaseEntity {

    @NotBlank(message = "The title field must not be empty.")
    private String title;

    @NotBlank(message = "The description field must not be empty.")
    private String description;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @NotNull(message = "The end date field must not be empty.")
    private Date endsAt;

    @NotNull(message = "The price field must not be empty.")
    private Integer cost;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Account owner;

    @NotNull(message = "The category field must not be empty.")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull(message = "The location field must not be empty.")
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
