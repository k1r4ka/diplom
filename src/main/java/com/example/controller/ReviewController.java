package com.example.controller;

import com.example.entity.Review;
import com.example.service.ProductNotFoundException;
import com.example.service.ProductService;
import com.example.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class ReviewController {

    @Autowired private ReviewService reviewService;
    @Autowired private ProductService productService;


    @GetMapping("{productId}/reviews/new")
    public String newReview(@PathVariable Integer productId, Model model) throws ProductNotFoundException {
        model.addAttribute("review", new Review());
        model.addAttribute("product", productService.get(productId));
        model.addAttribute("pageTitle", "добавить отзыв");
        return "review_form";
    }

    @PostMapping("{productId}/reviews/save")
    public String saveReview(@PathVariable Integer productId, Review review, RedirectAttributes redirectAttributes) throws ProductNotFoundException {
        review.setProduct(productService.get(productId));
        reviewService.addReview(review);
        redirectAttributes.addFlashAttribute("message","комментарий успешно добавлен.");
        return "redirect:/products/details/" + productId;
    }
}
