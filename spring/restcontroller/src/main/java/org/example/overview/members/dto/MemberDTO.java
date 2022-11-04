package org.example.overview.members.dto;

import org.example.overview.members.entity.Member;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.valid.GeneralValidationGroup;
import org.example.overview.valid.TestValidationGroup;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

public class MemberDTO {

//    @NotEmpty(groups = {GeneralValidationGroup.class, TestValidationGroup.class})
//    @Pattern(regexp = "[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}", groups = GeneralValidationGroup.class)
    private String uId = "";

//    @NotNull(groups = {GeneralValidationGroup.class, TestValidationGroup.class})
    private Password uPw = null;

    private Password uNewPw = null;

//    @NotEmpty(groups = {GeneralValidationGroup.class, TestValidationGroup.class})
//    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", groups = GeneralValidationGroup.class)
    private String uEmail = "";


    public MemberDTO() {
    }

    public MemberDTO(String uId) {
        this.uId = uId;
    }

    public MemberDTO(String uId, String uPw, boolean needEncode) {
        this.uId = uId;
        this.uPw = needEncode ? Password.of(uPw, true) : Password.of(uPw, false);
    }

    public MemberDTO(String uId, Password uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public MemberDTO(String uId, Password uPw, Password uNewPw) {
        this.uId = uId;
        this.uPw = uPw;
        this.uNewPw = uNewPw;
    }

    public MemberDTO(String uId, String uPw, String uEmail, boolean needEncode) {
        this.uId = uId;
        this.uPw = needEncode ? Password.of(uPw, true) : Password.of(uPw, false);
        this.uEmail = uEmail;
    }

    public MemberDTO(String uId, Password uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public Member toEntity(boolean isNewPw) {
        return isNewPw ? new Member(uId, getuNewPwStr(), uEmail) : new Member(uId, getuPwStr(), uEmail);
    }


    public MemberVO toVO() {
        return new MemberVO(uId, uPw.getuPw(), uEmail);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Password getuPw() {
        return uPw;
    }

    public String getuPwStr() {
        return uPw.getuPw();
    }

    public void setuPw(Password uPw) {
        this.uPw = uPw;
    }

    public Password getuNewPw() {
        return uNewPw;
    }
    public String getuNewPwStr() {
        return uNewPw.getuPw();
    }

    public void setuNewPw(Password uNewPw) {
        this.uNewPw = uNewPw;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }


    @Override
    public String toString() {
        return "MemberDTO{" +
                "uId='" + uId + '\'' +
                ", uPw=" + uPw +
                ", uNewPw=" + uNewPw +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
