package com.drool.model;

public class InterestDetail {
    private Integer amount;
    private String bankName;
    private Integer interestRate;
    private Integer newAmount;

    public InterestDetail(String bankName, Integer amount) {
        this.bankName = bankName;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(Integer newAmount) {
        this.newAmount = newAmount;
    }




}
