package org.example.overview.members.service;

import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMemberService {

    private MemberDAO memberDAO; // = MemberDAO.getInstance(); // 객체 생성
//    private static MemberService memberService = null;


//    public MemberService() {
//        System.out.println("MemberService()");
//    }

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }


    //    public static MemberService getInstance() {
//        if (memberService == null) {
//            memberService = new MemberService();
//        }
//        return memberService;
//    }

    @Override
    public List<MemberDTO> findByUserIdOrEmail(String q) {
        if (q == null) return null;

        List<Member> memberList = memberDAO.search(q);
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public boolean autoLogin(String autoLogin, String cookieId) {
        if (autoLogin == null || cookieId == null) return false;

        if (autoLogin.equals("true")) {
            if (getByUserId(cookieId) != null) {
                MemberDTO memberDTO = login(cookieId);
                return memberDTO != null;
            }
        }
        return false;
    }

    @Override
    public MemberDTO login(String uId) {
        MemberDTO memberDTO = new MemberDTO(uId);
        if (memberDTO == null) return null;

        Member member = memberDAO.select(memberDTO.getuId());
        return member.toDTO();
    }

    @Override
    public MemberDTO login(String uId, Password uPw) {
        MemberDTO memberDTO = new MemberDTO(uId, uPw);
        if (memberDTO == null || memberDTO.getuPwStr() == null) return null;

        Member member = memberDAO.select(memberDTO.getuId());
        if (member == null || member.getuPw() == null) return null;
        if (member.getuPw().equals(memberDTO.getuPwStr())) {
            return member.toDTO();
        }
        return null;
    }

    @Override
    public boolean signup(String uId, Password uPw, String uEmail) {
        MemberDTO memberDTO = new MemberDTO(uId, uPw, uEmail);
        if (memberDTO == null || memberDTO.getuPwStr() == null) return false;

        int res = memberDAO.insert(memberDTO.toEntity(false));
        return res > 0;
    }

    @Override
    public MemberDTO getByUserId(String uId) {
        if (uId == null) return null;

        Member member = memberDAO.select(uId);
        if (member == null) return null;

        return member.toDTO();
    }

    @Override
    public List<MemberDTO> getAllUsers() {
        List<Member> memberList = memberDAO.selectAll();
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public boolean updateUserPassword(String uId, Password uPw, Password uNewPw) {
        if (uId == null || uPw == null || uNewPw == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null || member.getuPw() == null) return false;
        if (!member.getuPw().equals(uPw.getuPw())) return false;
        if (member.getuPw().equals(uNewPw.getuPw())) return false; // DB PWD == New PWD

        int res = memberDAO.updatePassword(uId, uNewPw.getuPw());
        return res > 0;
    }

    @Override
    public boolean updateUserEmail(String uId, String uEmail) {
        if (uId == null || uEmail == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null) return false;

        int res = memberDAO.updateEmail(uId, uEmail);
        return res > 0;
    }

    @Override
    public boolean checkPassword(String uId, Password uPw) {
        if (uId == null || uPw == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null) return false;
        if (!member.getuPw().equals(uPw.getuPw())) return false;

        return true;
    }

    @Override
    public boolean checkNewPassword(String uId, Password uNewPw) {
        if (uId == null || uNewPw == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null) return false;
        if (member.getuPw().equals(uNewPw.getuPw())) return false;


        return true;
    }



    @Override
    public boolean removeByUserId(String uId, Password uPw) {
        if (uId == null || uPw == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null || member.getuPw() == null) return false;
        if (!member.getuPw().equals(uPw.getuPw())) return false;

        int res = memberDAO.delete(uId);
        return res > 0;
    }

    @Override
    public boolean removeUsers() {
        int res = memberDAO.deleteAll();
        return res > 0;
    }

}