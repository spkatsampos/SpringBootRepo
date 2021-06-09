package com.example.demo.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProducRepository repository){
        return args -> {
            Product a = new Product("linguini",
                    "Flour",
                    "regular size");
            Product b = new Product("pasta",
                    "Eggs",
                    "small size");
            Product c = new Product("lazagnia",
                    "Flour, milk, eggs",
                    "long size");
            repository.saveAll(Arrays.asList(a,b,c));
        };
    }

}
