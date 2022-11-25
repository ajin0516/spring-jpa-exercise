package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReviewCreateRequest {

    private Long hospitalId;
    private String title;
    private String content;
    private String patientName;


}
