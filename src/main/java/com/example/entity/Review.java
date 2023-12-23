package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review_t")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username_f")
    private String username;

    @Column(name = "comment_f")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    //get & set
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", product=" + product +
                '}';
    }
}
