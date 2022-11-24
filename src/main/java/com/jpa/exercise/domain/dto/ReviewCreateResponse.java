package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReviewCreateResponse {

    private Long id;
    private String title;
    private String content;
    private String patientName;
    private String message;


    public static ReviewCreateResponse of(Review review) {
        return ReviewCreateResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .message("조회 성공")
                .build();
    }
}
