package com.shopin_product_API.service;

import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.CartEntity;

import java.util.List;
import java.util.Map;

public interface CartService {

  public CartEntity addToCart(CartDto cartDto);

  public  Map<String, Object> editCartProduct(Long id, Integer quantity);


  public List<CartEntity> getallproductToCart (Long userId);

  Map<String, Object> deleteCartProduct(Long id);
}
