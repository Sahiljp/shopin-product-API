package com.shopin_product_API.entity;


import java.util.List;

public class CartDto {

    private Long productid;
    private  Integer quantity;

    public CartDto(Long productid, Integer quantity) {
        this.productid = productid;
        this.quantity = quantity;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
