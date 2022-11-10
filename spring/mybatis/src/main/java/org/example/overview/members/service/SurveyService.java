package org.example.overview.members.service;

import org.example.overview.members.dao.SurveyDAO;
import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService implements ISurveyService {

    private SurveyDAO surveyDAO;

    @Autowired
    public SurveyService(SurveyDAO surveyDAO) {
        this.surveyDAO = surveyDAO;
    }

    @Override
    @Transactional
    public boolean save(String uId, String season, String fruit) {
        if (uId == null || season == null || fruit == null) return false;

        Survey survey = new Survey(uId, season, fruit);
        System.out.println(survey);
        int res = surveyDAO.insert(survey);
        return res > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public SurveyDTO getByUserId(String uId) {
        if (uId == null) return null;

        Survey survey = surveyDAO.select(uId);
        if (survey == null) return null;

        return survey.toDTO();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SurveyDTO> getAllUsers() {
        List<Survey> surveyList = surveyDAO.selectAll();

        return surveyList.stream().map(s -> s.toDTO()).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean updateSeason(String uId, String season) {
        if (uId == null || season == null) return false;

        int res = surveyDAO.updateSeason(uId, season);
        return res > 0;
    }

    @Override
    @Transactional
    public boolean updateFruit(String uId, String fruit) {
        if (uId == null || fruit == null) return false;

        int res = surveyDAO.updateFruit(uId, fruit);
        return res > 0;
    }

    @Override
    @Transactional
    public boolean removeByUserId(String uId) {
        if (uId == null) return false;

        int res = surveyDAO.delete(uId);
        return res > 0;
    }

    @Override
    @Transactional
    public boolean removeUsers() {
        int res = surveyDAO.deleteAll();
        return res > 0;
    }

}