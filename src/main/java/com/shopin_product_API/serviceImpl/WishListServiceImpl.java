package com.shopin_product_API.serviceImpl;

import com.shopin_product_API.entity.*;
import com.shopin_product_API.repository.ProductRepository;
import com.shopin_product_API.repository.WishListRepository;
import com.shopin_product_API.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    public WishListEntity addTOWishList(ProductDto productDto) {
        WishListEntity WishListEntity=wishListRepository.save(populateProductData(productDto));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!1");
        return WishListEntity;
    }

    public WishListEntity populateProductData(ProductDto productDto){
        WishListEntity wishList=new WishListEntity();
        ProductEntity product = productRepository.findByproductid(productDto.getProductid());
        wishList.setUserid(productDto.getUserid());
        wishList.setProductEntity(product);
        wishList.setCreated_on(LocalDateTime.now());

        return  wishList;
    }
}
