package com.test.caravelo.controller;

import com.test.caravelo.business.dto.SurveyDTO;
import com.test.caravelo.business.service.impl.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyService;

    @GetMapping(value = "/surveys")
    @ResponseBody
    public List<SurveyDTO> getSurveyList()  {
        return surveyService.getSurveyList();
    }

}
