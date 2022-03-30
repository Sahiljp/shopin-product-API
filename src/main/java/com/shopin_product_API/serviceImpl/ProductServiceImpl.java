package com.shopin_product_API.serviceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopin_product_API.constant.ApplicationConstant;
import com.shopin_product_API.controller.ProductController;
import com.shopin_product_API.entity.ProductEntity;

import com.shopin_product_API.feign_client.ProductServiceClient;
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
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    public static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Value("${stripe.apikey}")
    String stripeKey;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductServiceClient productServiceClient;

    @Override
    public Map<String, String> addProduct(String productEntity, MultipartFile file) throws StripeException, IOException {
        logger.info("inside addProductServiceImpl....");
        ProductEntity newProductEntity;
        ObjectMapper obbjectMapper = new ObjectMapper();
        newProductEntity = obbjectMapper.readValue(productEntity, ProductEntity.class);
        Map<String, String> map = new HashMap<String, String>();
        Stripe.apiKey = stripeKey;
        Map<String, Object> params = new HashMap<>();
        params.put("name", newProductEntity.getPname());
        logger.info("product");
        Product product = Product.create(params);
        logger.info("product 234567");
        Map<String, Object> params1 = new HashMap<>();
        params1.put("unit_amount", 100 * newProductEntity.getPrice());
        params1.put("currency", "INR");
        params1.put("product", product.getId());
        Price price = Price.create(params1);

        newProductEntity.setProductid(product.getId());
        newProductEntity.setCreated_on(LocalDateTime.now());
        newProductEntity.setLastModified_on(LocalDateTime.now());
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", ApplicationConstant.CLOUD_NAME,
                "api_key", ApplicationConstant.API_KEY, "api_secret", ApplicationConstant.API_SECRET));
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("public_id", "product_image/" + newProductEntity.getProductid()));

            String url = uploadResult.get("url").toString();
            newProductEntity.setImage(url);
            productRepository.save(newProductEntity);
            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
            map.put(ApplicationConstant.RESPONSE_DATA, url);
            map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.PRODUCT_UPLOADED_SUCESSFULLY);
        } catch (IOException e) {
            e.printStackTrace();
            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_400);
            map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.SOMETING_WENT_WRONG);
        }

        map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
        map.put(ApplicationConstant.RESPONSE_MESSAGE, ApplicationConstant.PRODUCT_REGISTRATION_SUCCESS);
        map.put(ApplicationConstant.RESPONSE_DATA, price.toJson());

        productRepository.save(newProductEntity);
        return map;
    }


    @Override
    public Map<String, Object> getProduct(String brandName, String productGender, String productName, Integer productPrice) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ProductEntity> product = productRepository.findByAttribute(brandName, productGender, productName, productPrice);
        if (!product.isEmpty()) {
            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
            map.put(ApplicationConstant.RESPONSE_DATA, product);
            return map;
        } else {
            List<ProductEntity> product1 = productRepository.findAll();
            map.put(ApplicationConstant.RESPONSE_STATUS, ApplicationConstant.STATUS_200);
            map.put(ApplicationConstant.RESPONSE_DATA, product1);
            return map;
        }

    }
}
