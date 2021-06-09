package com.example.demo.product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName="product_sequence",
            allocationSize=1
    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator ="producr_sequence"
    )
    private long id;
    private String name;
    private String ingredients;
    private String characteristics;

public Product(){}

    public Product(long id, String name, String ingredients, String characteristics) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.characteristics = characteristics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

}
