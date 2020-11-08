package com.example.koc.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CreditScoreOperations {

    public Integer generateCreditScore() {
        Random rand = new Random();
        int rand_int = rand.nextInt(1500);
        return rand_int;
    }

}
