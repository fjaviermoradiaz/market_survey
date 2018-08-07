package com.test.caravelo.business.converter;

import com.test.caravelo.business.dto.ProviderDTO;
import com.test.caravelo.business.dto.TargetDTO;
import com.test.caravelo.persistence.model.Provider;
import com.test.caravelo.persistence.model.Target;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public ProviderDTO toDto(Provider provider) {
        ProviderDTO providerDTO = new ProviderDTO();
        BeanUtils.copyProperties(provider,providerDTO);
        return providerDTO;
    }

    public Provider toEntity(ProviderDTO providerDTO) {
        Provider provider = new Provider();
        BeanUtils.copyProperties(providerDTO,provider);
        return provider;
    }
}
