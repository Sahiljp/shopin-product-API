package com.shopin_product_API.serviceImpl;

import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.CartEntity;
import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.repository.CartRepository;
import com.shopin_product_API.repository.ProductRepository;
import com.shopin_product_API.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public CartEntity addToCart(CartDto cartDto) {
        Map<String, String> map = new HashMap<String, String>();
        CartEntity cartEntity = cartRepository.save(populateCartData(cartDto));
        return  cartEntity;

    }
    public CartEntity populateCartData(CartDto cartDto){
        CartEntity cartEntity=new CartEntity();
        cartEntity.setQuantity(cartDto.getQuantity());
        ProductEntity product = productRepository.findByproductid(cartDto.getProductid());
        cartEntity.setProductEntity(product);
        cartEntity.setCreated_on(LocalDateTime.now());
        cartEntity.setUserId(product.getUserId());

        return  cartEntity;
    }
}
