package com.shopin_product_API.repository;

import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.entity.RatingEntity;
import com.shopin_product_API.entity.RatingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<RatingEntity,Long> {

    @Query("SELECT new com.shopin_product_API.entity.RatingResponse(COUNT(rating) as count ,AVG(rating) as avg) FROM RatingEntity m Where m.productEntity.id= :productid")
    RatingResponse getCountandAvgOfRating(@Param("productid")Long productid);

    @Query("SELECT AVG(m.rating) FROM RatingEntity m Where m.productEntity.id= :productid")
    Double getAvgRating(Long productid);
}
