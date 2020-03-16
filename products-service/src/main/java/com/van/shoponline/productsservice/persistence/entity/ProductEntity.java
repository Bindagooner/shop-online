package com.van.shoponline.productsservice.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "brand")
    @Basic
    private String brand;

    @Column(name = "color")
    @Basic
    private String color;

    @Column(name = "price")
    @Basic
    private Double price;

    @Column(name = "description")
    @Basic
    private String description;

    @JoinColumn(nullable = false, name = "category_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryEntity category;

}

