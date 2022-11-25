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
    // Review(dao) 의 hospital 이 있기 때문에 dto.getHospitalId()을 사용하기 위해 HospitalRepository 필요
    public ReviewCreateResponse add(ReviewCreateRequest dto) {
        // Hospital 불러오기 ( Review 의 Hospital 사용하기 위해 Hospital 찾아야 함 )
        Optional<Hospital> hospital = hospitalRepository.findById(dto.getHospitalId());
        // dto를 Entity로 변환
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .patientName(dto.getPatientName())
                .hospital(hospital.get())
                .build();
        // 저장
        Review saveReview = reviewRepository.save(review);

        return new ReviewCreateResponse(saveReview.getId(), saveReview.getTitle(),
                saveReview.getContent(), saveReview.getPatientName(),"리뷰 등록 성공");
    }

    public Review getReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("해당 id 가 없습니다."));
        return review;
//        if (optionalReview.isPresent()) {
//            return ReviewCreateResponse.of(optionalReview.get());
//        }else {
//            return ReviewCreateResponse.builder().message("존재하지 않는 리뷰 id입니다").build();
//        }
    }
}
