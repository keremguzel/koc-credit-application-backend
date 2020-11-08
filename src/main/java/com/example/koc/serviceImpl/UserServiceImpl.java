package com.example.koc.serviceImpl;
import com.example.koc.config.MappingConfiguration;
import com.example.koc.dto.CreditDto;
import com.example.koc.dto.UserDto;
import com.example.koc.entity.User;
import com.example.koc.error.ApiError;
import com.example.koc.repository.UserRepository;
import com.example.koc.service.CreditScoreService;
import com.example.koc.service.UserService;
import com.example.koc.shared.GenericResponse;
import com.example.koc.type.BusinessValidationException;
import com.example.koc.utils.UserVerifyOperations;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Mapper mapper;
    @Autowired
    UserVerifyOperations userVerifyOperations;
    @Autowired
    CreditScoreService creditScoreService;


    @Override
    @Transactional
    public GenericResponse saveUser(UserDto userDto){
       Optional<User> user = userRepository.findById(userDto.getId());
       if(user.isPresent()){
           User userEntity = mapper.map(userDto,User.class);
           userRepository.save(userEntity);
           return new GenericResponse("SALARY_UPDATED");
       }

        if(!userVerifyOperations.isTCKNCorrect(String.valueOf(userDto.getId())))
            throw new BusinessValidationException("ID_IS_NOT_VALID");
        if (!userVerifyOperations.isPhoneNumberCorrect(userDto.getPhone()))
            throw new BusinessValidationException("PHONE_NUMBER_NOT_UNIQUE");

        User userEntity = mapper.map(userDto,User.class);

        userRepository.save(userEntity);

        return creditScoreService.getCreditScore(userDto);
    }

    @Override
    public GenericResponse getUserById(Long id){
     return new GenericResponse("CREDIT_INFO", creditScoreService.inquireCreditInfosByUser(id));
    }

}
