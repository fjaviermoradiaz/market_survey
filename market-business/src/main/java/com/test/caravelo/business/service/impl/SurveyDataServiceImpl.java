package com.test.caravelo.business.service.impl;

import com.test.caravelo.business.builder.SurveyDataQueryBuilder;
import com.test.caravelo.business.converter.SurveyConverter;
import com.test.caravelo.business.converter.TargetConverter;
import com.test.caravelo.business.dto.ProviderDTO;
import com.test.caravelo.business.dto.filter.ProviderFilterDTO;
import com.test.caravelo.business.dto.filter.SurveyDataFilterDTO;
import com.test.caravelo.business.dto.SurveyDataDTO;
import com.test.caravelo.business.exception.EntityNotFoundException;
import com.test.caravelo.business.service.SurveyDataService;
import com.test.caravelo.business.thread.SendSurveyDataThread;
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

   @Autowired
   private SurveyDataQueryBuilder surveyDataQueryBuilder;

   @Autowired
   private ProviderServiceImpl providerService;

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

   public SurveyDataDTO getSurveyDataFilter(SurveyDataFilterDTO filter) {
       Survey survey = surveyRepository.findBySubject(filter.getSurvey().getSubject());

       List<SurveyData> results = surveyDataRepository.findAll(surveyDataQueryBuilder.prepareFilterQuery(filter));

       SurveyDataDTO surveyDataDTO = new SurveyDataDTO();
       surveyDataDTO.setSurvey(surveyConverter.toDto(survey));

       for(SurveyData surveyData : results) {
           surveyDataDTO.addToTargetDTOList(targetConverter.toDto(surveyData.getTarget()));
       }

       sendSurveyDataProvider(surveyDataDTO,filter.getProvider());

       return surveyDataDTO;
   }

   private void sendSurveyDataProvider(SurveyDataDTO surveyDataDTO, List<ProviderFilterDTO> providerFilterDTOList) {

       for(ProviderFilterDTO providerFilterDTO : providerFilterDTOList) {
            try {
                ProviderDTO providerDTO = providerService.getProviderById(providerFilterDTO.getId());
                SendSurveyDataThread surveyDataThread = new SendSurveyDataThread(providerDTO);
                surveyDataThread.start();
                //TODO: This functionality must be implemented sending info to AWS SQS for lambda process
            }catch (EntityNotFoundException e) {
                //LOG entidad no encontrada
            }
       }

   }

}
