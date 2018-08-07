package com.test.caravelo.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TARGET")
public class Target implements Serializable {

    private Long id;
    private String gender;
    private Integer age;
    private String incomeCurrency;
    private Integer incomeQuantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", incomeCurrency='" + incomeCurrency + '\'' +
                ", incomeQuantity='" + incomeQuantity + '\'' +
                '}';
    }
}


