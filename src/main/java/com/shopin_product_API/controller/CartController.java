package com.shopin_product_API.controller;

import com.cloudinary.api.ApiResponse;
import com.shopin_product_API.entity.CartDto;
import com.shopin_product_API.entity.CartEntity;
import com.shopin_product_API.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    public static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<CartEntity> addToCart(@RequestBody CartDto cartDto) {
        try {
            logger.info("Inside addToCart() : ");
            return new ResponseEntity<>(cartService.addToCart(cartDto), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while addToCart {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/getAllProductFromCart")
    public ResponseEntity<List<CartEntity>> getAllProductFromCart(@RequestParam("userId") Long userId) {
        try {
            logger.info("Inside getAllProductFromCart() : ");
            return new ResponseEntity<>(cartService.getallproductToCart(userId), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while getAllProductFromCart {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping(value = "/editCartProduct")
    public ResponseEntity<Map<String, Object>> editCartProduct(@RequestParam("id") Long id,
                                                           @RequestParam("quantity") Integer quantity) {
        try {
            logger.info("editCartProduct : " + id);
            return new ResponseEntity<Map<String, Object>>(cartService.editCartProduct(id,quantity), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occured while editCartProduct {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deleteCartProduct")
    public ResponseEntity<Map<String, Object>> deleteCartProduct(@RequestParam(value = "id") Long id) {
        try {
            logger.info("Inside deleteCartProduct cartId : " + id);
            return new ResponseEntity<>(cartService.deleteCartProduct(id), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while deleteCartProduct cartId {} :Reason :{}", id, e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
