package com.shopin_product_API.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WishListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime created_on;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    private Long userid;

    public WishListEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public WishListEntity() {
    }

    public WishListEntity(Long id, LocalDateTime created_on, ProductEntity productEntity) {
        this.id = id;
        this.created_on = created_on;
        this.productEntity = productEntity;
    }

    @ManyToOne
    private ProductEntity productEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
