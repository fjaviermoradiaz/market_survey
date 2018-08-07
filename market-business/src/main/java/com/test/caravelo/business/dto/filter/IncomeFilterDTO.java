package com.test.caravelo.business.dto.filter;

import java.util.List;

public class IncomeFilterDTO {

    private String currency;
    private List<Integer> range;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }
}
