package com.test.caravelo.business.service.impl;

import com.test.caravelo.business.converter.ProviderConverter;
import com.test.caravelo.business.converter.SurveyConverter;
import com.test.caravelo.business.dto.ProviderDTO;
import com.test.caravelo.business.dto.SurveyDTO;
import com.test.caravelo.business.exception.EntityNotFoundException;
import com.test.caravelo.business.service.ProviderService;
import com.test.caravelo.business.service.SurveyService;
import com.test.caravelo.persistence.model.Provider;
import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.repository.ProviderRepository;
import com.test.caravelo.persistence.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

   @Autowired
   private ProviderConverter providerConverter;

   @Autowired
   private ProviderRepository providerRepository;

   @Override
   public ProviderDTO getProviderById(String id) throws EntityNotFoundException {
       Provider provider = providerRepository.findOne(id);

       if(provider == null)
           throw new EntityNotFoundException(id);
       return providerConverter.toDto(provider);
   }

}
