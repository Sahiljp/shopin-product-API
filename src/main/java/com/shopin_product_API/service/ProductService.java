package com.shopin_product_API.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.shopin_product_API.entity.ProductDto;
import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.entity.CheckOutDto;

import com.stripe.exception.StripeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProductService {

    public Map<String, Object> addProduct(String productEntity, MultipartFile file) throws StripeException, IOException;

    public Map<String, Object> getProduct(String brandName, String productGender, String productName, Integer productPrice);

    public Map<String, Object> editProduct(Long id, String productdto, MultipartFile file) throws JsonProcessingException;

    public Map<String, Object> deleteProduct(Long productid);

    public void updateQtyAndCartData(List<CheckOutDto> checkOutDto);

}
