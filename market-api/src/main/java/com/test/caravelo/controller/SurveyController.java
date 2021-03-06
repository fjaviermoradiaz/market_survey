package com.test.caravelo.controller;

import com.test.caravelo.business.dto.filter.SurveyDataFilterDTO;
import com.test.caravelo.business.dto.SurveyDTO;
import com.test.caravelo.business.dto.SurveyDataDTO;
import com.test.caravelo.business.service.impl.SurveyDataServiceImpl;
import com.test.caravelo.business.service.impl.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyService;

    @Autowired
    private SurveyDataServiceImpl surveyDataService;

    @GetMapping(value = "/surveys")
    @ResponseBody
    public List<SurveyDTO> getSurveyList()  {
        return surveyService.getSurveyList();
    }

    @GetMapping(value = "/surveys/data/{subject}")
    @ResponseBody
    public SurveyDataDTO getSurveyList(@PathVariable String subject)  {
        return surveyDataService.getSurveyDataBySurvey(subject);
    }

    @PostMapping(value = "/surveys/information")
    @ResponseBody
    public SurveyDataDTO getSurveyInformation(@Valid @RequestBody SurveyDataFilterDTO filter) {
        return  surveyDataService.getSurveyDataFilter(filter);
    }

}
