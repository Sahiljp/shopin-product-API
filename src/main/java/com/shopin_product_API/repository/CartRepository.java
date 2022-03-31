package com.shopin_product_API.repository;

import com.shopin_product_API.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
