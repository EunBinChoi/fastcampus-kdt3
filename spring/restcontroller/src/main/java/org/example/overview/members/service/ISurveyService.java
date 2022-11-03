package org.example.overview.members.service;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.dto.SurveyDTO;

import java.util.List;

public interface ISurveyService {
    boolean save(String uId, String season, String fruit);
    SurveyDTO getByUserId(String uId);

    List<SurveyDTO> getAllUsers();

    boolean updateSeason(String uId, String season);

    boolean updateFruit(String uId, String fruit);

    boolean removeByUserId(String uId);

    boolean removeUsers();

}
