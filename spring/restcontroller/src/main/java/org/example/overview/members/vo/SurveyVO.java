package org.example.overview.members.vo;

import java.util.Objects;

public class SurveyVO {

    private String uId = "";
    private String season = "";
    private String fruit = "";

    public SurveyVO() {
    }

    public SurveyVO(String season, String fruit) {
        this.season = season;
        this.fruit = fruit;
    }

    public SurveyVO(String uId, String season, String fruit) {
        this.uId = uId;
        this.season = season;
        this.fruit = fruit;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyVO surveyVO = (SurveyVO) o;
        return uId.equals(surveyVO.uId) && season.equals(surveyVO.season) && fruit.equals(surveyVO.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, season, fruit);
    }

    @Override
    public String toString() {
        return "SurveyVO{" +
                "uId='" + uId + '\'' +
                ", season='" + season + '\'' +
                ", fruit='" + fruit + '\'' +
                '}';
    }
}
