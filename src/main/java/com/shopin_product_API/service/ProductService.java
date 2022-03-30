package com.shopin_product_API.service;

import com.shopin_product_API.entity.ProductEntity;
import com.stripe.exception.StripeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ProductService {

    public Map<String, String> addProduct(String productEntity, MultipartFile file) throws StripeException, IOException;

    public Map<String, Object> getProduct(String brandName, String productGender, String productName, Integer productPrice);
}
