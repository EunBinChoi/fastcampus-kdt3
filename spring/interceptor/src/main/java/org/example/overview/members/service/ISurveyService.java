package org.example.overview.members.service;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.dto.SurveyDTO;

import java.util.List;

public interface ISurveyService {
    boolean save(String uId, String season, String fruit);
    SurveyDTO getSurveyByUserId(String uId);

    boolean updateSurveySeason(String uId, String season);

    boolean updateSurveyFruit(String uId, String fruit);

    boolean removeSurveyByUserId(String uId);

    boolean removeSurveys();

}
