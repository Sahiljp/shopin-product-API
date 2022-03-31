package com.shopin_product_API.controller;

import com.shopin_product_API.entity.*;
import com.shopin_product_API.service.CartService;
import com.shopin_product_API.service.WishListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/wishList")
public class WishListController {
    public static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    WishListService wishListService;

    @PostMapping("/addTOWishList")
    public ResponseEntity<WishListEntity> addTOWishList(@RequestBody ProductDto productDto){
        try {
            logger.info("Inside addTOWishList() : ");
            return new ResponseEntity<>(wishListService.addTOWishList(productDto), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured while addTOWishList {} :Reason :{}");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
