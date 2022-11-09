package org.example.overview.members.dto;

import org.example.overview.members.entity.Member;
import org.example.overview.members.vo.MemberVO;

public class WrongMemberDTO {
    private Long uId = null;
    private Password uPw = null;
    private String uEmail = "";

    public WrongMemberDTO() {
    }

    public WrongMemberDTO(Long uId, Password uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public WrongMemberDTO(Long uId, Password uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public Member toEntity() {
        return new Member(uId.toString(), getuPwStr(), uEmail);
    }

    public MemberVO toVO() {
        return new MemberVO(uId.toString(), uEmail);
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
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

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return "WrongMemberDTO{" +
                "uId=" + uId +
                ", uPw=" + uPw +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
