package com.shopin_product_API.repository;

import com.shopin_product_API.entity.CartEntity;
import com.shopin_product_API.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity,Long> {

    @Query("SELECT a FROM CartEntity a WHERE a.userId= :userId")
    List<CartEntity> findByUserId(Long userId);

    @Query("SELECT m FROM CartEntity m Where m.productEntity.id= :productid")
    CartEntity findByproductid(Long productid);

}
