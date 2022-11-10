package org.example.overview.members.entity;

import lombok.Builder;
import org.example.overview.members.dto.SurveyDTO;

import java.math.BigInteger;

@Builder
public class NewSurvey {

    private BigInteger sId = null;
    private String season = "";
    private String fruit = "";

    public NewSurvey() {
    }

    public NewSurvey(String season, String fruit) {
        this.season = season;
        this.fruit = fruit;
    }

    public NewSurvey(BigInteger sId, String season, String fruit) {
        this.sId = sId;
        this.season = season;
        this.fruit = fruit;
    }

    public BigInteger getsId() {
        return sId;
    }

    public String getSeason() {
        return season;
    }

    public String getFruit() {
        return fruit;
    }

    // repository 단에서 맵핑하기 위해 setter 생성
    public void setsId(BigInteger sId) {
        this.sId = sId;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "NewSurvey{" +
                "sId='" + sId + '\'' +
                ", season='" + season + '\'' +
                ", fruit='" + fruit + '\'' +
                '}';
    }
}
