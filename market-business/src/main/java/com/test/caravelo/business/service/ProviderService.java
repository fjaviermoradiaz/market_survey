package com.test.caravelo.business.service;

import com.test.caravelo.business.dto.ProviderDTO;
import com.test.caravelo.business.exception.EntityNotFoundException;

public interface ProviderService {

    ProviderDTO getProviderById(String id) throws EntityNotFoundException;

}
