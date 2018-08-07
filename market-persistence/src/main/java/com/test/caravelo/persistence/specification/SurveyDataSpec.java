package com.test.caravelo.persistence.specification;

import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.model.SurveyData;

import com.test.caravelo.persistence.model.Target;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Join;

public class SurveyDataSpec {

    public static Specification<SurveyData> bySurvey(String subject) {
        return (root, query, cb) -> {
            Join<Survey,SurveyData> join = root.join("survey");
            return cb.equal(join.get("subject"),subject);
        };
    }

    public static Specification<SurveyData> byGender(String gender) {
        return (root, query, cb) -> {
          Join<Target,SurveyData> join = root.join("target");
          return cb.equal(join.get("gender"), gender);
        };
    }

    public static Specification<SurveyData> byAge(Integer min, Integer max) {
        return (root, query, cb) -> {
            Join<Target,SurveyData> join = root.join("target");
            return cb.between(join.<Integer>get("age"), min,max);
        };
    }

    public static Specification<SurveyData> byIncomeCurrency(String incomeCurrency) {
        return (root, query, cb) -> {
            Join<Target, SurveyData> join = root.join("target");
            return cb.equal(join.get("incomeCurrency"), incomeCurrency);
        };
    }

    public static Specification<SurveyData> byIncomeQuantity(Integer min, Integer max) {
        return (root, query, cb) -> {
            Join<Target,SurveyData> join = root.join("target");
            return cb.between(join.<Integer>get("incomeQuantity"), min,max);
        };
    }

    public static Specification<SurveyData> byCountry(String country) {
        return (root, query, cb) -> {
            Join<Survey,SurveyData> join = root.join("survey");
            return cb.equal(join.get("country"),country);
        };
    }

}
