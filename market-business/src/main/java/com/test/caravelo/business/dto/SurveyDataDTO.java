package com.test.caravelo.business.dto;

import java.util.ArrayList;
import java.util.List;

public class SurveyDataDTO {

    private SurveyDTO survey;
    private List<TargetDTO> targetDTOList;

    public SurveyDataDTO() {
        this.targetDTOList = new ArrayList<>();
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
    }

    public List<TargetDTO> getTargetDTOList() {
        return targetDTOList;
    }

    public void setTargetDTOList(List<TargetDTO> targetDTOList) {
        this.targetDTOList = targetDTOList;
    }

    public void addToTargetDTOList(TargetDTO targetDTO) {
        this.targetDTOList.add(targetDTO);
    }
}
