package com.test.caravelo.business.thread;

import com.test.caravelo.business.dto.ProviderDTO;

public class SendSurveyDataThread extends Thread{

    private ProviderDTO providerDTO;

    public SendSurveyDataThread(ProviderDTO providerDTO) {
        this.providerDTO = providerDTO;
    }
    public void run(){
        System.out.println("Sending survey data to: " + providerDTO.getName());
    }
}