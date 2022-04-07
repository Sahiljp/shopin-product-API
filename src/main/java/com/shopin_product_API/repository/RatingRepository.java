package com.shopin_product_API.repository;

import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepository extends JpaRepository<RatingEntity,Long> {

    @Query("SELECT COUNT(m.productEntity.id) FROM RatingEntity m Where m.productEntity.id= :productid")
    Integer getCountofrate(Long productid);

}
