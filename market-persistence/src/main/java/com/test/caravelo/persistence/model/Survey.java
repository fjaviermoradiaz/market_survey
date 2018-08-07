package com.test.caravelo.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SURVEY")
public class Survey implements Serializable {


    private String subject;
    private String country;

    @Id
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Survey{" +
                ", subject='" + subject + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


