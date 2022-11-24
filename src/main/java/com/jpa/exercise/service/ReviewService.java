package com.jpa.exercise.service;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.repository.HospitalRepository;
import com.jpa.exercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse add(ReviewCreateRequest reviewCreateRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .patientName(reviewCreateRequest.getPatientName())
                .hospital(hospital.get())
                .build();
        Review saveReview = reviewRepository.save(review);
        return new ReviewCreateResponse(saveReview.getId(), saveReview.getTitle(),
                saveReview.getContent(), saveReview.getPatientName(),"리뷰 등록 성공");
    }

    public ReviewCreateResponse getReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        Review savedReview;
        if (optionalReview.isPresent()) {
            return ReviewCreateResponse.of(optionalReview.get());
        }else {
            return ReviewCreateResponse.builder().message("존재하지 않는 리뷰 id입니다").build();
        }
    }
}
