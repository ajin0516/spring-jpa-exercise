package com.jpa.exercise.service;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.dto.HospitalItemResponse;
import com.jpa.exercise.domain.dto.HospitalResponse;
import com.jpa.exercise.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalItemResponse findById(Integer hospitalId) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        HospitalItemResponse hospitalItemResponse = Hospital.ofSingle(optionalHospital.get());
        return hospitalItemResponse;
    }
}
