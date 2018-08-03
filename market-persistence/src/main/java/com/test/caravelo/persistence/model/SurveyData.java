package com.test.caravelo.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SURVEY_DATA")
public class SurveyData implements Serializable {

    private Long id;
    private Survey survey;
    private Target target;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "SurveyData{" +
                "id=" + id +
                ", survey=" + survey +
                ", target=" + target +
                '}';
    }
}


