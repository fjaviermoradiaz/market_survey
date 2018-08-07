package com.test.caravelo.persistence.repository;

import com.test.caravelo.persistence.model.Survey;
import com.test.caravelo.persistence.model.SurveyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyDataRepository extends JpaRepository<SurveyData,Long>, JpaSpecificationExecutor {

    List<SurveyData> findBySurvey(Survey survey);
}
