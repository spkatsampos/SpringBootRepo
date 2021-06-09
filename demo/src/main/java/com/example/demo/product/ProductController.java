package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProduct();
    }
    @PostMapping
    public void registerNewProduct (@RequestBody Product product){
        productService.addNewProduct(product);

    }
    @DeleteMapping(path="{productID}")
    public void deleteProduct(@PathVariable("productID") Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping(path="{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String characteristics,
            @RequestParam(required = false) String ingredients
    ){
        productService.updateProduct(productId,name,characteristics,ingredients);
    }
}
