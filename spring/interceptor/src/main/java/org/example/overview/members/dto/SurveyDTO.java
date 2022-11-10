package org.example.overview.members.dto;


import org.example.overview.members.entity.Survey;
import org.example.overview.members.vo.SurveyVO;

import java.math.BigInteger;

public class SurveyDTO {

    //@NotEmpty(groups = {GeneralValidationGroup.class, TestValidationGroup.class})
    private BigInteger sId = null;

    //@NotEmpty(groups = {GeneralValidationGroup.class, TestValidationGroup.class})
    private String season = "";
    //@NotEmpty(groups = {GeneralValidationGroup.class, TestValidationGroup.class})
    private String fruit = "";

    public SurveyDTO() {
    }

    public SurveyDTO(String season, String fruit) {
        this.season = season;
        this.fruit = fruit;
    }

    public SurveyDTO(BigInteger sId, String season, String fruit) {
        this.sId = sId;
        this.season = season;
        this.fruit = fruit;
    }

    public Survey toEntity() {
        return new Survey(sId, season, fruit);
    }

    public SurveyVO toVO() {
        return new SurveyVO(sId.toString(), season, fruit);
    }

    public BigInteger getsId() {
        return sId;
    }

    public void setsId(BigInteger sId) {
        this.sId = sId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "SurveyDTO{" +
                "sId=" + sId +
                ", season='" + season + '\'' +
                ", fruit='" + fruit + '\'' +
                '}';
    }
}
