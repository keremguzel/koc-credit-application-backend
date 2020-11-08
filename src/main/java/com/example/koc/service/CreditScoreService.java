package com.example.koc.service;

import com.example.koc.dto.CreditDto;
import com.example.koc.dto.UserDto;
import com.example.koc.entity.CreditScore;
import com.example.koc.entity.User;
import com.example.koc.shared.GenericResponse;
import org.springframework.http.ResponseEntity;

public interface CreditScoreService {
    GenericResponse getCreditScore(UserDto user);

    GenericResponse saveCreditScore(CreditDto creditDto);

    CreditScore inquireCreditInfosByUser(Long id);
}
