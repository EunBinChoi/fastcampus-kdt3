package org.example.overview.members.vo;

import org.example.overview.members.dto.MemberDTO;

import java.util.Objects;

public class MemberVO {
    private String uId = "";
    private String uEmail = "";

    public MemberVO() {
    }

    public MemberVO(String uId, String uEmail) {
        this.uId = uId;
        this.uEmail = uEmail;
    }

    public String getuId() {
        return uId;
    }

    public String getuEmail() {
        return uEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberVO memberVO = (MemberVO) o;
        return uId.equals(memberVO.uId) && uEmail.equals(memberVO.uEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uEmail);
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "uId='" + uId + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
