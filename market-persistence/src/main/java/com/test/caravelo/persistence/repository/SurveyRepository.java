package com.test.caravelo.persistence.repository;

import com.test.caravelo.persistence.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {

    Survey findBySubject(String subject);
}
