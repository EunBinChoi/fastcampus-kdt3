package org.example.overview.members.entity;

import org.example.overview.members.dto.SurveyDTO;

public class Survey {

    private String uId = "";
    private String season = "";
    private String fruit = "";

    public Survey() {
    }

    public Survey(String season, String fruit) {
        this.season = season;
        this.fruit = fruit;
    }

    public Survey(String uId, String season, String fruit) {
        this.uId = uId;
        this.season = season;
        this.fruit = fruit;
    }

    public SurveyDTO toDTO() {
        return new SurveyDTO(uId, season, fruit);
    }

    public String getuId() {
        return uId;
    }

    public String getSeason() {
        return season;
    }


    public String getFruit() {
        return fruit;
    }


    @Override
    public String toString() {
        return "Survey{" +
                "uId='" + uId + '\'' +
                ", season='" + season + '\'' +
                ", fruit='" + fruit + '\'' +
                '}';
    }
}
