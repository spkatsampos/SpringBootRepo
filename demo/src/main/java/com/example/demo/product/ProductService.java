package com.example.demo.product;

import com.sun.xml.txw2.IllegalSignatureException;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProducRepository producRepository;

    @Autowired
    public ProductService(ProducRepository producRepository) {
        this.producRepository = producRepository;
    }

    public List<Product> getProduct(){
        return producRepository.findAll();
    }

    public void addNewProduct(Product product) {
       Optional<Product> productByName = producRepository
               .findProductByName(product.getName());

       if(productByName.isPresent()){
           throw new IllegalStateException("The product already exists!!");
       }
       producRepository.save(product);

    }

    public void deleteProduct(Long productId) {

        boolean exists = producRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("This product does not exist!");
        }
        producRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId,
                              String name,
                              String characteristics,
                              String ingredients) {
    Product product = producRepository.findById(productId).orElseThrow(()->new IllegalStateException(
            "Product with id " +productId+ " does not exist!"
    ));
    if(name!=null && name.length() >0 &&
            !Objects.equals(product.getName(),name)){
        product.setName(name);
    }
    if(characteristics!=null && characteristics.length() >0 &&
            !Objects.equals(product.getCharacteristics(),characteristics)){
        product.setCharacteristics(characteristics);
    }
    if(ingredients!=null && ingredients.length() >0 &&
            !Objects.equals(product.getIngredients(),ingredients)){
        product.setIngredients(ingredients);
    }
    }

    }
