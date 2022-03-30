package com.shopin_product_API.serviceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.shopin_product_API.constant.ApplicationConstant;
import com.shopin_product_API.controller.ProductController;
import com.shopin_product_API.entity.ProductEntity;

import com.shopin_product_API.repository.ProductRepository;
import com.shopin_product_API.service.ProductService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    public static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Value("${stripe.apikey}")
    String stripeKey;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Map<String, String> addProduct(ProductEntity productEntity) throws StripeException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        Stripe.apiKey = stripeKey;
        Map<String, Object> params = new HashMap<>();
        params.put("name", productEntity.getPname());

//       params.put("type", productEntity.getPtype());
       logger.info("product");
        Product product = Product.create(params);
        logger.info("product 234567");
        Map<String, Object> params1 = new HashMap<>();
        params1.put("unit_amount",100*productEntity.getPrice());
        params1.put("currency", "INR");
        params1.put("product", product.getId());
        Price price = Price.create(params1);

        productEntity.setProductid(product.getId());
        productEntity.setCreated_on(LocalDateTime.now());
        productEntity.setLastModified_on(LocalDateTime.now());

        map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
        map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.REGISTRATION_SUCCESS);
        map.put(ApplicationConstant.RESPONSE_DATA, price.toJson());

        productRepository.save(productEntity);
        return map;

    }
}
