package com.shopin_product_API.service;

import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.CartEntity;

public interface CartService {

  public CartEntity addToCart(CartDto cartDto);

}
