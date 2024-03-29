package com.shopin_product_API.repository;


import com.shopin_product_API.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT m FROM ProductEntity m WHERE m.brandName = :brandName OR m.pgender = :productGender OR m.pname = :productName OR m.price = :productPrice")
    List<ProductEntity> findByAttribute(String brandName, String productGender, String productName, Integer productPrice);
    
    @Query("SELECT m FROM ProductEntity m Where m.id= :productid")
    ProductEntity findByproductid(Long productid);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE ProductEntity p SET p.qty = :quantity WHERE p.id = :productId")
    public void updateQty(@Param("productId") long productId,@Param("quantity") long quantity);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE ProductEntity p SET p.rating = :ratingEntity , p.avgRating = :avg WHERE p.id = :productid")
    public void addRatings(Long ratingEntity, Double avg, Long productid);



}
