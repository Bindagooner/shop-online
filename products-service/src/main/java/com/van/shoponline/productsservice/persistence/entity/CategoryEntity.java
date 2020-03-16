package com.van.shoponline.productsservice.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "description")
    @Basic
    private String description;
}
