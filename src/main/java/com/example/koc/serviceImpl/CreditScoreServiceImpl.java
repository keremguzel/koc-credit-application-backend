package com.example.koc.serviceImpl;

import com.example.koc.dto.CreditDto;
import com.example.koc.dto.UserDto;
import com.example.koc.entity.CreditScore;
import com.example.koc.entity.User;
import com.example.koc.repository.CreditScoreRepository;
import com.example.koc.service.CreditScoreService;
import com.example.koc.shared.GenericResponse;
import com.example.koc.utils.CreditScoreOperations;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    @Autowired
    CreditScoreOperations creditScoreOperations;
    @Autowired
    Mapper map;
    @Autowired
    CreditScoreRepository creditScoreRepository;

    private final static int CREDIT_CONSTANT = 4;


    @Override
    @Transactional
    public GenericResponse getCreditScore(UserDto user) {

        Integer score = 0;
        Integer creditScore = creditScoreOperations.generateCreditScore();

        if(creditScore > 500 && creditScore <1000){
            score = 10000;
        }
        else if(creditScore >= 1000){
            score = Math.toIntExact(CREDIT_CONSTANT * user.getSalary());
        }
        CreditDto creditDto = new CreditDto();
        if (score>500) {
            creditDto.setApproved(true);
        } else {
            creditDto.setApproved(false);
        }

        creditDto.setCreditScore(score);
        creditDto.setUserDto(user);

        return  saveCreditScore(creditDto);
    }

    @Override
    @Transactional
    public GenericResponse saveCreditScore(CreditDto creditDto) {
       User userEntity = map.map(creditDto.getUserDto(),User.class);

       CreditScore creditScore = new CreditScore();
       creditScore.setUser(userEntity);
       creditScore.setApproved(creditDto.isApproved());
       creditScore.setCreditLimit(Long.valueOf(creditDto.getCreditScore()));

        creditScoreRepository.save(creditScore);

        creditScoreRepository.getOne(1l);
        GenericResponse<CreditScore> creditScoreGenericResponse = new GenericResponse("CREDIT_LIMIT_SUCCESS",creditScore);

        return creditScoreGenericResponse;
    }

    @Override
    public CreditScore inquireCreditInfosByUser(Long id) {
        return creditScoreRepository.getByUserId(id);
    }


}
