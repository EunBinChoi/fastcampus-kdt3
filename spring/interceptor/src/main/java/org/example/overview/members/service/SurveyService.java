package org.example.overview.members.service;

import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service
public class SurveyService implements ISurveyService {

    private MemberDAO memberDAO;

    @Autowired
    public SurveyService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    @Transactional
    public boolean save(String uId, String season, String fruit) {
        if (uId == null || season == null || fruit == null) return false;

        Survey survey = new Survey(season, fruit);
        System.out.println(survey);
        int res = memberDAO.insertSurvey(uId, survey);
        return res > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public SurveyDTO getSurveyByUserId(String uId) {
        if (uId == null) return null;

        BigInteger sId = memberDAO.selectSurveyIdWithUserId(uId);
        if (sId == null) return null;

        Survey survey = memberDAO.selectSurvey(sId);
        if (survey == null) return null;

        return survey.toDTO();
    }

    @Override
    @Transactional
    public boolean updateSurveySeason(String uId, String season) {
        if (uId == null || season == null) return false;

        BigInteger sId = memberDAO.selectSurveyIdWithUserId(uId);
        if (sId == null) return false;

        int res = memberDAO.updateSurveySeason(sId, season);
        return res > 0;
    }

    @Override
    @Transactional
    public boolean updateSurveyFruit(String uId, String fruit) {
        if (uId == null || fruit == null) return false;

        BigInteger sId = memberDAO.selectSurveyIdWithUserId(uId);
        if (sId == null) return false;

        int res = memberDAO.updateSurveyFruit(sId, fruit);
        return res > 0;
    }

    @Override
    @Transactional
    public boolean removeSurveyByUserId(String uId) {
        if (uId == null) return false;

        BigInteger sId = memberDAO.selectSurveyIdWithUserId(uId);
        if (sId == null) return false;

        int res = memberDAO.deleteSurvey(sId);
        return res > 0;
    }

    @Override
    @Transactional
    public boolean removeSurveys() {
        int res = memberDAO.deleteSurveys();
        return res > 0;
    }
}