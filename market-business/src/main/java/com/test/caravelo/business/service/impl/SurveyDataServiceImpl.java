package com.test.caravelo.business.service.impl;

import com.test.caravelo.business.converter.SurveyConverter;
import com.test.caravelo.business.converter.TargetConverter;
import com.test.caravelo.business.dto.SurveyDataDTO;
import com.test.caravelo.business.service.SurveyDataService;
import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.model.SurveyData;
import com.test.caravelo.persistence.repository.SurveyDataRepository;
import com.test.caravelo.persistence.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyDataServiceImpl implements SurveyDataService {

   @Autowired
   private SurveyDataRepository surveyDataRepository;

   @Autowired
   private SurveyRepository surveyRepository;

   @Autowired
   private SurveyConverter surveyConverter;

   @Autowired
   private TargetConverter targetConverter;

   public SurveyDataDTO getSurveyDataBySurvey(String subject) {
       Survey survey = surveyRepository.findBySubject(subject);

       if(survey == null)
           return null;
           //TODO: lanzar excepción

       List<SurveyData> surveyDataList = surveyDataRepository.findBySurvey(survey);
       SurveyDataDTO surveyDataDTO = new SurveyDataDTO();
       surveyDataDTO.setSurvey(surveyConverter.toDto(survey));
       for(SurveyData surveyData : surveyDataList) {
           surveyDataDTO.addToTargetDTOList(targetConverter.toDto(surveyData.getTarget()));
       }

       return surveyDataDTO;
   }

}
