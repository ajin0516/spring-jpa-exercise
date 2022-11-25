package com.jpa.exercise.domain;

import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}
