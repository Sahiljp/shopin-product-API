package com.shopin_product_API.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String pname;
    private LocalDateTime created_on;
    private String image;
    private String brandName;
    private  String ptype;
    private String pgender;
    private LocalDateTime lastModified_on;
    private Integer price;
    private Long userId;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", created_on=" + created_on +
                ", image='" + image + '\'' +
                ", brandName='" + brandName + '\'' +
                ", ptype='" + ptype + '\'' +
                ", pgender='" + pgender + '\'' +
                ", lastModified_on=" + lastModified_on +
                ", price=" + price +
                ", userId=" + userId +
                ", qty=" + qty +
                '}';
    }

    private Long qty;

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public LocalDateTime getLastModified_on() {
        return lastModified_on;
    }

    public void setLastModified_on(LocalDateTime lastModified_on) {
        this.lastModified_on = lastModified_on;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
