package com.example.koc.utils;

import com.example.koc.entity.User;
import com.example.koc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
@Component
public class UserVerifyOperations {
@Autowired
UserRepository userRepository;

    public  boolean isTCKNCorrect(String id) {
        if (id == null) return false;

        if (id.length() != 11) return false;

        char[] chars = id.toCharArray();
        int[] a = new int[11];

        for(int i=0; i<11; i++) {
            a[i] = chars[i] - '0';
        }

        if(a[0] == 0) return false;
        if(a[10] % 2 == 1) return false;

        if(((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 - (a[1] + a[3] + a[5] + a[7])) % 10 != a[9]) return false;

        if((a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]) % 10 != a[10]) return false;
        //if(((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 + (a[1] + a[3] + a[5] + a[7]))*9 % 10 != a[9]) return false;

        return true;
    }

    public  boolean isPhoneNumberCorrect(Long number) {
        User user = userRepository.findByPhone(number);
        if (Objects.nonNull(user)) return false;
        return true;
    }
}
