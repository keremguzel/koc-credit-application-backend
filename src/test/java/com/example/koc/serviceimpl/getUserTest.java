package com.example.koc.serviceimpl;

import com.example.koc.dto.UserDto;
import com.example.koc.entity.CreditScore;
import com.example.koc.entity.User;
import com.example.koc.repository.UserRepository;
import com.example.koc.service.CreditScoreService;
import com.example.koc.serviceImpl.CreditScoreServiceImpl;
import com.example.koc.serviceImpl.UserServiceImpl;
import com.example.koc.shared.GenericResponse;
import com.example.koc.utils.UserVerifyOperations;
import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class getUserTest {

    @Spy
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private CreditScoreService creditScoreService;


    @BeforeEach
    public void setUp() {

        initMocks(this);
    }

    @Test
    public void getUserById_thenOK(){
        GenericResponse genericResponse = new GenericResponse("CREDIT_INFO");
        CreditScore creditScore = new CreditScore();
        Mockito.when(creditScoreService.inquireCreditInfosByUser(any())).thenReturn(creditScore);

        final GenericResponse result = userService.getUserById(any());

        verify(userService,times(1)).getUserById(any());

        assertThat(result.getMessage()).isEqualTo(genericResponse.getMessage());

    }
}
