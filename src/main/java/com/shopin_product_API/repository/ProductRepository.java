package com.shopin_product_API.repository;


import com.shopin_product_API.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT m FROM ProductEntity m WHERE m.brandName = :brandName OR m.pgender = :productGender OR m.pname = :productName OR m.price = :productPrice")
    List<ProductEntity> findByAttribute(String brandName, String productGender, String productName, Integer productPrice);
}
