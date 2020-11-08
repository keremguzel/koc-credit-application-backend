package com.example.koc.repository;

import com.example.koc.entity.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore,Long>{
    CreditScore getByUserId(Long id);
}
