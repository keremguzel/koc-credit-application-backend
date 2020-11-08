package com.example.koc.serviceimpl;

import com.example.koc.dto.CreditDto;
import com.example.koc.dto.UserDto;
import com.example.koc.entity.User;
import com.example.koc.repository.CreditScoreRepository;
import com.example.koc.service.CreditScoreService;
import com.example.koc.serviceImpl.CreditScoreServiceImpl;
import com.example.koc.shared.GenericResponse;
import com.example.koc.utils.CreditScoreOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import com.github.dozermapper.core.Mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class getCreditScoreTest {

    @Spy
    @InjectMocks
    private CreditScoreServiceImpl creditScoreService;

    @Mock
    private CreditScoreOperations creditScoreOperations;
    @Mock
    private CreditScoreRepository creditScoreRepository;
    @Mock
    private Mapper map;
    @BeforeEach
    public void setUp() {

        initMocks(this);
    }

    UserDto userDto = new UserDto();

    @Test
    public void getCreditScore_thenOK(){
        User user = new User();
        GenericResponse genericResponse = new GenericResponse("CREDIT_LIMIT_SUCCESS");
            CreditDto creditDto = new CreditDto(true,10,new UserDto());
        Mockito.when(creditScoreOperations.generateCreditScore()).thenReturn(1);
        Mockito.when(map.map(any(),any())).thenReturn(user);


        final GenericResponse result = creditScoreService.getCreditScore(userDto);

        verify(creditScoreService,times(1)).getCreditScore(userDto);

        assertThat(result.getMessage()).isEqualTo(genericResponse.getMessage());

    }
}
