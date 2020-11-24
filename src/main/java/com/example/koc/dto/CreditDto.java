package com.example.koc.dto;

public class CreditDto {
    private boolean isApproved;
    private Integer creditScore;
    private Integer creditLimit;
    private UserDto userDto;

    public CreditDto() {
    }

    public CreditDto(boolean isApproved, Integer creditScore) {
        this.isApproved = isApproved;
        this.creditScore = creditScore;
    }

    public CreditDto(boolean isApproved, Integer creditScore, UserDto userDto) {
        this.isApproved = isApproved;
        this.creditScore = creditScore;
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }
}
