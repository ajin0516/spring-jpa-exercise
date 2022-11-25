package com.jpa.exercise.domain;

import com.jpa.exercise.domain.dto.HospitalItemResponse;
import com.jpa.exercise.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id
    private Long id;
    private String roadNameAddress;
    private String hospitalName;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;


    public static HospitalItemResponse ofSingle(Hospital hospital) {
        return HospitalItemResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews())
                .build();
    }

}
