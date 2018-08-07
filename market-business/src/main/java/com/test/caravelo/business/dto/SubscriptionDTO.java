package com.test.caravelo.business.dto;

import java.util.List;

public class SubscriptionDTO {

    private String frequency;
    private List<String> channel;

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public List<String> getChannel() {
        return channel;
    }

    public void setChannel(List<String> channel) {
        this.channel = channel;
    }
}
