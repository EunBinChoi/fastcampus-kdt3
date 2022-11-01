package org.example.overview.members.service;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMemberService {

    List<MemberDTO> findByUserIdOrEmail(String q);
    
    boolean autoLogin(String autoLogin, String cookieId);

    MemberDTO login(String uId);
    MemberDTO login(String uId, String uPw);

    boolean signup(String uId, String uPw, String uEmail);

    MemberDTO getByUserId(String uId);

    List<MemberDTO> getAllUsers();

    boolean updateUserPassword(String uId, Password uPw, Password uNewPw);

    boolean removeByUserId(String uId, Password uPw);

    boolean removeUsers();

}
