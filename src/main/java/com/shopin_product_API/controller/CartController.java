package com.shopin_product_API.controller;

import com.cloudinary.api.ApiResponse;
import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.CartEntity;
import com.shopin_product_API.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    public static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<CartEntity> addToCart(@RequestBody CartDto cartDto){
        try {
            logger.info("Inside addToCart() : ");
            return new ResponseEntity<>(cartService.addToCart(cartDto), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while addToCart {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
