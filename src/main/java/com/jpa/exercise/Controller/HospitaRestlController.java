package com.jpa.exercise.Controller;

import com.jpa.exercise.domain.dto.HospitalResponse;
import com.jpa.exercise.domain.dto.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitaRestlController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitaRestlController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id,
                                                    @RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<HospitalResponse>> list(Pageable pageable) {
        return ResponseEntity.ok().body(new ArrayList<>());
    }

    @GetMapping("reviews/{id}")
    public ResponseEntity<ReviewCreateResponse> findReview(@PathVariable Long id) {
        return ResponseEntity.ok().body(reviewService.getReview(id));
    }
}
