package com.shopin_product_API.service;

import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.ProductDto;
import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.entity.WishListEntity;

public interface WishListService {
    WishListEntity addTOWishList(ProductDto productDto);
}
