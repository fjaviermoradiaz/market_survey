package com.test.caravelo.business.service.impl;

import com.test.caravelo.business.converter.SurveyConverter;
import com.test.caravelo.business.dto.SurveyDTO;
import com.test.caravelo.business.service.SurveyService;
import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

   @Autowired
   private SurveyConverter surveyConverter;

   @Autowired
   private SurveyRepository surveyRepositor;

   public List<SurveyDTO> getSurveyList(){
        List<Survey> surveyList = surveyRepositor.findAll();
        List<SurveyDTO> surveyDTOList = new ArrayList<>();

        if(surveyList != null) {
            for(Survey survey : surveyList) {
                surveyDTOList.add(surveyConverter.toDto(survey));
            }
        }

        return surveyDTOList;
   }

}
