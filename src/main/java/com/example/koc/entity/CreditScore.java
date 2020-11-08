package com.example.koc.entity;

import javax.persistence.*;

@Entity
@Table(name = "koc_credit_score")
public class CreditScore {


    private Long id;
    private Long creditLimit;
    private boolean isApproved;

    private User userEntity;

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }


    @OneToOne( targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "koc_user")
    public User getUser() {
        return userEntity;
    }

    public void setUser(User user) {
        this.userEntity = user;
    }
}
