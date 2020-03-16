package com.van.shoponline.audit.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity_log")
@Data
public class ActivityLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Basic
    private String type;

    @Column(name = "search_by")
    @Basic
    private String searchBy;

    @Column(name = "search_query")
    @Basic
    private String searchQuery;

    @Column(name = "sort_by")
    @Basic
    private String sortBy;

    @Column(name = "sort_direction")
    @Basic
    private String sortDirection;

    @Column(name = "time_stamp")
    @Basic
    private Date timeStamp;
}
