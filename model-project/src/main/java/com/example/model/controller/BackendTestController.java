package com.example.model.controller;


import com.example.model.service.ProductService;
import com.example.model.entity.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/database")
@RestController
public class BackendTestController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ProductModel save(@RequestBody ProductModel productModel){
        return productService.addProductModel(productModel);
    }

    @GetMapping("/getAllProducts")
    public List<ProductModel> getAllProducts(){
        return productService.getAllProducts();
    }


    @PutMapping({"/update"})
    public void updateProduct(ProductModel productModel){
        productService.updateProduct(productModel);
    }

    @DeleteMapping({"/delete/{id}"})
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }
}
