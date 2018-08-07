package com.test.caravelo.business.dto.filter;

public class SurveyFilterDTO {

    private String subject;
    private String country;
    private TargetFilterDTO target;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TargetFilterDTO getTarget() {
        return target;
    }

    public void setTarget(TargetFilterDTO target) {
        this.target = target;
    }
}
