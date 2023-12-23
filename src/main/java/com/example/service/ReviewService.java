package com.example.service;

import com.example.entity.Review;
import com.example.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired private ReviewRepository reviewRepository;

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getAllReview(Integer productId) {
        return reviewRepository.findByProductId(productId);
    }
}
