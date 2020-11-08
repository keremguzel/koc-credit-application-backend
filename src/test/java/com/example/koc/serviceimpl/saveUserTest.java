package com.example.koc.serviceimpl;

import com.example.koc.dto.UserDto;
import com.example.koc.entity.User;
import com.example.koc.repository.UserRepository;
import com.example.koc.service.CreditScoreService;
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
import org.junit.jupiter.api.Test;
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
public class saveUserTest {

    @Spy
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserVerifyOperations userVerifyOperations;

    @Mock
    private Mapper mapper;
    @Mock
    CreditScoreService creditScoreService;
    @BeforeEach
    public void setUp() {

        initMocks(this);
    }

    Long id = 1l ;
    Optional<User> userEntity = Optional.of(new User());
    UserDto userDto = new UserDto();
    User user  =new User();

    @Test
    public void saveUserFirstTime_thenOK() {

        GenericResponse genericResponse = new GenericResponse("Success");


        Mockito.when(userRepository.findById(ArgumentMatchers.anyLong())).thenReturn(userEntity);
        Mockito.when(userVerifyOperations.isTCKNCorrect(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(userVerifyOperations.isPhoneNumberCorrect(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(mapper.map(any(),any())).thenReturn(user);

        Mockito.when(creditScoreService.getCreditScore(any())).thenReturn(genericResponse);

        final GenericResponse result = userService.saveUser(userDto);

        verify(userService,times(1)).saveUser(userDto);

        assertThat(result).isEqualTo(genericResponse);
    }

     @Test
     public void saveUserIdNotUniq_thenOK(){

        GenericResponse genericResponse = new GenericResponse("SALARY_UPDATED");
        User user = new User();

        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(mapper.map(any(),any())).thenReturn(userEntity.get());

        final GenericResponse result = userService.saveUser(userDto);

        verify(userService,times(1)).saveUser(userDto);

        assertThat(result.getMessage()).isEqualTo(genericResponse.getMessage());

     }
}
