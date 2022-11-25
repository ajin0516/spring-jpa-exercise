package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HospitalItemResponse {  // DTO

    private Long id;
    private String roadNameAddress;
    private String hospitalName;
    private List<Review> reviews;

}
