package com.test.caravelo.business.dto.filter;

import java.util.List;

public class TargetFilterDTO {

    private String gender;
    private List<Integer> age;
    private IncomeFilterDTO income;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Integer> getAge() {
        return age;
    }

    public void setAge(List<Integer> age) {
        this.age = age;
    }

    public IncomeFilterDTO getIncome() {
        return income;
    }

    public void setIncome(IncomeFilterDTO income) {
        this.income = income;
    }
}
