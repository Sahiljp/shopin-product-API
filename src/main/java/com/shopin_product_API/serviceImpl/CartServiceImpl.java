package com.shopin_product_API.serviceImpl;

import com.shopin_product_API.constant.ApplicationConstant;
import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.CartEntity;
import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.repository.CartRepository;
import com.shopin_product_API.repository.ProductRepository;
import com.shopin_product_API.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

    @Override
    public Map<String, Object> editCartProduct(Long id, Integer quantity) {
        ProductEntity productEntity = productRepository.findByproductid(id);
        CartEntity cartEntity = cartRepository.findByproductid(productEntity.getId());
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            if (cartEntity != null) {
                cartEntity.setQuantity(quantity);
                cartRepository.save(cartEntity);
                map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
                map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.CART_EDIT_SUCCESS);
                map.put(ApplicationConstant.RESPONSE_DATA, new ArrayList<>());
            }
        } catch (Exception e) {

            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_400);
            map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.SOMETING_WENT_WRONG);
            map.put(ApplicationConstant.RESPONSE_DATA, new ArrayList<>());
        }
        return map;

    }

    @Override
    public List<CartEntity> getallproductToCart(Long userId) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<CartEntity> cartEntities = cartRepository.findByUserId(userId);
            if (!cartEntities.isEmpty()) {
                map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
                map.put(ApplicationConstant.RESPONSE_DATA, cartEntities);
                return  cartEntities;
            } else {
                map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
                map.put(ApplicationConstant.RESPONSE_DATA, cartEntities);
                return cartEntities;
            }
    }

    @Override
    public Map<String, Object> deleteCartProduct(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            cartRepository.deleteById(id);
            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
            map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.PRODUCT_DELETE_SUCCESS);
            map.put(ApplicationConstant.RESPONSE_DATA, new ArrayList<>());
        } catch (Exception e) {
            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_400);
            map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.SOMETING_WENT_WRONG);
            map.put(ApplicationConstant.RESPONSE_DATA, new ArrayList<>());
        }
        return map;
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
