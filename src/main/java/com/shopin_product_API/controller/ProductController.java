package com.shopin_product_API.controller;

import com.shopin_product_API.entity.ProductEntity;
import com.shopin_product_API.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping(value = "/addproduct", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Map<String, String>> addProduct(@RequestParam(value = "productEntity") String productEntity, @RequestParam(value = "file") MultipartFile file) {
        try {
            logger.info("Inside addProduct() : ");
            return new ResponseEntity<>(productService.addProduct(productEntity, file), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while addproduct {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Map<String, Object>> getallProduct(@RequestParam(value = "brandName", required = false) String brandName, @RequestParam(value = "productGender", required = false) String productGender, @RequestParam(value = "productName", required = false) String productName, @RequestParam(value = "productPrice", required = false) Integer productPrice) {
        try {
            logger.info("Inside addProduct() : ");
            return new ResponseEntity<>(productService.getProduct(brandName, productGender, productName, productPrice), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while addproduct {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
