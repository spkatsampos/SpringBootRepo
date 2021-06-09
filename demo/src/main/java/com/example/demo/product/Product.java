package com.example.demo.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName="product_sequence",
            allocationSize=1
    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator ="product_sequence"
    )
    private long id;
    private String name;
    private String ingredients;
    private String characteristics;

    public Product(String name, String ingredients, String characteristics) {
        this.name = name;
        this.ingredients = ingredients;
        this.characteristics = characteristics;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", characteristics='" + characteristics + '\'' +
                '}';
    }

}
