package com.shopin_product_API.entity;

public class ProductDto {

    private Long productid;

    private Long userid;

    public ProductDto() {
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getProductid() {
        return productid;
    }

    public ProductDto(Long productid) {
        this.productid = productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }
}
