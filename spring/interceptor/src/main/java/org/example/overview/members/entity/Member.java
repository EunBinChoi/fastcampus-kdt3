package org.example.overview.members.entity;

import lombok.Builder;
import org.example.overview.members.dto.MemberDTO;

@Builder
public class Member {

    private String uId = "";
    private String uPw = "";
    private String uEmail = "";

    private Survey surveyResult = null;

    public Member() {
    }

    public Member(String uId, String uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public Member(String uId, String uPw, String uEmail, Survey surveyResult) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
        this.surveyResult = surveyResult;
    }

    public MemberDTO toDTO() {
        return new MemberDTO(uId, uPw, uEmail, false);
    }


    public String getuId() {
        return uId;
    }

    public String getuPw() {
        return uPw;
    }

    public String getuEmail() {
        return uEmail;
    }

    public Survey getSurveyResult() {
        return surveyResult;
    }


    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setuPw(String uPw) {
        this.uPw = uPw;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public void setSurveyResult(Survey surveyResult) {
        this.surveyResult = surveyResult;
    }

    public void printWithoutSurveyResult() {
        System.out.println(String.format("uId = %s, uPw = %s, uEmail = %s", uId, uPw, uEmail));
    }

    public void printWithSurveyResult() {
        System.out.println(String.format("uId = %s, uPw = %s, uEmail = %s, surveyResult = %s", uId, uPw, uEmail, surveyResult));
    }


    @Override
    public String toString() {
        return "Member{" +
                "uId='" + uId + '\'' +
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", surveyResult=" + surveyResult +
                '}';
    }
}