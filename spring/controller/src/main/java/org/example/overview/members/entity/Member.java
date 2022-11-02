package org.example.overview.members.entity;

import org.example.overview.members.dto.MemberDTO;

public class Member {
    private String uId = "";
    private String uPw = "";
    private String uEmail = "";

    public Member() {
    }

    public Member(String uId, String uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public Member(String uId, String uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
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




    @Override
    public String toString() {
        return "Member{" +
                "uId='" + uId + '\'' +
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}