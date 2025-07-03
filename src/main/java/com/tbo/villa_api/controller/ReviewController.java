package com.tbo.villa_api.controller;

import com.tbo.villa_api.model.Review;
import com.tbo.villa_api.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/customer/{id}")
    public List<Review> getReviewsByCustomer(@PathVariable Long id) {
        return reviewService.getReviewsByCustomerId(id);
    }

    @GetMapping("/villa/{id}")
    public List<Review> getReviewsByVilla(@PathVariable Long id) {
        return reviewService.getReviewsByVillaId(id);
    }
}
