package org.example.overview.members.service;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class MemberService implements IMemberService {

    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberDAO memberDAO = MemberDAO.getInstance();
    private static MemberService memberService = null;

    public static MemberService getInstance() {
        if (memberService == null) {
            memberService = new MemberService();
        }
        return memberService;
    }

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
            if (memberService.getByUserId(cookieId) != null) {
                MemberDTO memberDTO = memberService.login(cookieId);
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
    public MemberDTO login(String uId, String uPw) {
        MemberDTO memberDTO = new MemberDTO(uId, uPw, true);
        if (memberDTO == null || memberDTO.getuPwStr() == null) return null;

        Member member = memberDAO.select(memberDTO.getuId());
        if (member == null || member.getuPw() == null) return null;
        if (member.getuPw().equals(memberDTO.getuPwStr())) {
            return memberDTO;
        }
        return null;
    }

    @Override
    public boolean signup(String uId, String uPw, String uEmail) {
        MemberDTO memberDTO = new MemberDTO(uId, uPw, uEmail, true);
        if (memberDTO == null || memberDTO.getuPwStr() == null) return false;

        int res = memberDAO.insert(memberDTO.toEntity());
        return res > 0;
    }

    @Override
    public MemberDTO getByUserId(String uId) {
        if (uId == null) return null;

        Member member = memberDAO.select(uId);
        return member.toDTO();
    }

    @Override
    public List<MemberDTO> getAllUsers() {
        List<Member> memberList = memberDAO.selectAll();
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public boolean updateUserPassword(String uId, Password uPw) {
        if (uId == null || uPw == null) return false;

        int res = memberDAO.update(uId, uPw.getuPw());
        return res > 0;
    }

    @Override
    public boolean removeByUserId(String uId) {
        if (uId == null) return false;

        int res = memberDAO.delete(uId);
        return res > 0;
    }

    @Override
    public boolean removeUsers() {
        int res = memberDAO.deleteAll();
        return res > 0;
    }

}