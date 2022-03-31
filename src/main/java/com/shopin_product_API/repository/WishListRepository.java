package com.shopin_product_API.repository;

import com.shopin_product_API.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishListEntity,Long> {
}
