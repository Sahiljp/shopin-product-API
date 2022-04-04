package com.shopin_product_API.feign_client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@FeignClient(name = "user-service", url = "localhost:8080")
//public interface ProductServiceClient {
//
//    @GetMapping("/user/getUserByID/{customerid}")
//    public String getUserByID(@PathVariable("customerid") String customerid);
//}
