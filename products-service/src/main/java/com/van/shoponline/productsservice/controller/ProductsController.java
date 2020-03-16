package com.van.shoponline.productsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping(value = "/")
    public String home() {
        return "products service";
    }
}
