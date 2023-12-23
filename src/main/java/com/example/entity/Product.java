package com.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product_t")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f", nullable = false)
    private String name;

    @Column(name = "description_f")
    private String description;

    @Column(name = "price_f", nullable = false)
    private double price;

    @Column(name = "quantity_f", nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Review> reviewSet;


    //get & set
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Review> getReviewSet() {
        return reviewSet;
    }

    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}