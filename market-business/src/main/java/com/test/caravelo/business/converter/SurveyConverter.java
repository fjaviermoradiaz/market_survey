package com.test.caravelo.business.converter;

import com.test.caravelo.business.dto.SurveyDTO;
import com.test.caravelo.persistence.model.Survey;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SurveyConverter {

    public SurveyDTO toDto(Survey survey) {
        SurveyDTO surveyDTO = new SurveyDTO();
        BeanUtils.copyProperties(survey,surveyDTO);
        return surveyDTO;
    }

    public Survey toEntity(SurveyDTO surveyDTO) {
        Survey survey = new Survey();
        BeanUtils.copyProperties(surveyDTO,survey);
        return survey;
    }
}
