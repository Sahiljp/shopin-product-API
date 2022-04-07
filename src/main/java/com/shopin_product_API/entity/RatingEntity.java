package com.shopin_product_API.entity;

import javax.persistence.*;
@Entity
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Integer rating;
    private String comments;


    public RatingEntity(Long id, Long userId, Integer rating, String comments, ProductEntity productEntity) {
        this.id = id;
        this.userId = userId;
        this.rating = rating;
        this.comments = comments;
        this.productEntity = productEntity;
    }

    public RatingEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @ManyToOne
    private ProductEntity productEntity;

}