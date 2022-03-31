package com.shopin_product_API.entity;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CartEntity {

    public CartEntity(Long id, LocalDateTime created_on, Integer quantity, Long userId, ProductEntity productEntity) {
        this.id = id;
        this.created_on = created_on;
        this.quantity = quantity;
        this.userId = userId;
        this.productEntity = productEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime created_on;
    private Integer quantity;
    private Long userId;

    public CartEntity() {
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", created_on=" + created_on +
                ", quantity=" + quantity +
                ", userId=" + userId +
                ", productEntity=" + productEntity +
                '}';
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
