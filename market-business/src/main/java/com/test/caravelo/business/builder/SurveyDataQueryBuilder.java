package com.test.caravelo.business.builder;

import com.test.caravelo.business.dto.filter.SurveyDataFilterDTO;
import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.model.SurveyData;
import com.test.caravelo.persistence.specification.SurveyDataSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

@Component
public class SurveyDataQueryBuilder {

    public Specifications prepareFilterQuery(SurveyDataFilterDTO filter) {

        Specifications query = null;
        boolean isInitialized = false;

        if (filter.getSurvey().getSubject() != null) {
            Specification<SurveyData> surveySpecification = SurveyDataSpec.bySurvey(filter.getSurvey().getSubject());
            if (isInitialized) {
                query = query.and(surveySpecification);
            } else {
                query = Specifications.where(surveySpecification);
                isInitialized = true;
            }
        }

        if (filter.getSurvey().getTarget() != null) {
            Specification<SurveyData> genderSpecification =
                    SurveyDataSpec.byGender(filter.getSurvey().getTarget().getGender());
            if (isInitialized) {
                query = query.and(genderSpecification);
            } else {
                query = Specifications.where(genderSpecification);
                isInitialized = true;
            }
        }

        if (filter.getSurvey().getTarget().getAge() != null
                && filter.getSurvey().getTarget().getAge().size() > 0) {
            Integer min = filter.getSurvey().getTarget().getAge().get(0);
            Integer max = filter.getSurvey().getTarget().getAge().get(filter.getSurvey().getTarget().getAge().size() - 1);
            if (isInitialized) {
                query = query.and(SurveyDataSpec.byAge(min, max));
            } else {
                query = Specifications.where(SurveyDataSpec.byAge(min, max));
                isInitialized = true;
            }
        }

        if (filter.getSurvey().getTarget().getIncome().getCurrency() != null) {
            Specification<SurveyData> currencySpecification = SurveyDataSpec.byIncomeCurrency(
                    filter.getSurvey().getTarget().getIncome().getCurrency());
            if (isInitialized) {
                query = query.and(currencySpecification);

            } else {
                query = Specifications.where(currencySpecification);
            }

        }

       if(filter.getSurvey().getTarget().getIncome().getRange() != null
                && filter.getSurvey().getTarget().getIncome().getRange().size()>0) {

            Integer min = filter.getSurvey().getTarget().getIncome().getRange().get(0);
            Integer max = filter.getSurvey().getTarget().getIncome().getRange().get(filter.getSurvey().getTarget().getIncome().getRange().size() - 1);

            if(isInitialized) {
                query = query.and(SurveyDataSpec.byIncomeQuantity(min,max));
            } else {
                query = Specifications.where(SurveyDataSpec.byIncomeQuantity(min,max));
            }
        }

        if(filter.getSurvey().getCountry() != null
                && !filter.getSurvey().getCountry().isEmpty()) {
            Specification<SurveyData> countrySpecification = SurveyDataSpec.byCountry(filter.getSurvey().getCountry());

            if(isInitialized) {
                query = query.and(countrySpecification);
            } else {
                query = Specifications.where(countrySpecification);
            }
        }

        return query;
    }
}
