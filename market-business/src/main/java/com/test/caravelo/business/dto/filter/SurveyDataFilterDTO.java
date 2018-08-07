package com.test.caravelo.business.dto.filter;

import com.test.caravelo.business.dto.RequesterDTO;
import com.test.caravelo.business.dto.SubscriptionDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SurveyDataFilterDTO {

    @ApiModelProperty(required = true)
    private RequesterDTO requester;

    @ApiModelProperty(required = true)
    private List<ProviderFilterDTO> provider;

    @ApiModelProperty(required = true)
    private SurveyFilterDTO survey;

    @ApiModelProperty(required = true)
    private SubscriptionDTO subscription;

    public RequesterDTO getRequester() {
        return requester;
    }

    public void setRequester(RequesterDTO requester) {
        this.requester = requester;
    }

    public List<ProviderFilterDTO> getProvider() {
        return provider;
    }

    public void setProvider(List<ProviderFilterDTO> provider) {
        this.provider = provider;
    }

    public SurveyFilterDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyFilterDTO survey) {
        this.survey = survey;
    }

    public SubscriptionDTO getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionDTO subscription) {
        this.subscription = subscription;
    }
}
