package com.test.caravelo.business.dto;

public class TargetDTO {

    private String gender;
    private Integer age;
    private String incomeCurrency;
    private Integer incomeQuantity;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIncomeCurrency() {
        return incomeCurrency;
    }

    public void setIncomeCurrency(String incomeCurrency) {
        this.incomeCurrency = incomeCurrency;
    }

    public Integer getIncomeQuantity() {
        return incomeQuantity;
    }

    public void setIncomeQuantity(Integer incomeQuantity) {
        this.incomeQuantity = incomeQuantity;
    }
}
