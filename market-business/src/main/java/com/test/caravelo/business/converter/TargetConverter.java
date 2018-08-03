package com.test.caravelo.business.converter;

import com.test.caravelo.business.dto.SurveyDTO;
import com.test.caravelo.business.dto.TargetDTO;
import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.model.Target;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TargetConverter {

    public TargetDTO toDto(Target target) {
        TargetDTO targetDTO = new TargetDTO();
        BeanUtils.copyProperties(target,targetDTO);
        return targetDTO;
    }

    public Target toEntity(TargetDTO targetDTO) {
        Target target = new Target();
        BeanUtils.copyProperties(targetDTO,target);
        return target;
    }
}
