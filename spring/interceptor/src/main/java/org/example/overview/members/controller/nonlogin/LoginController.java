package org.example.overview.members.controller.nonlogin;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;


@Controller
@RequestMapping("")
public class LoginController {

    private MemberService memberService ;


    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request, HttpSession session) {
        String view = "members/nonlogin/login";

//        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
//            return "redirect:/";
//        }
//
//        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");
//        String cookieId = cookieMgr.get(request, "COOKIE_ID");
//
//
//        if (autoLogin != null && cookieId != null) {
//            if (memberService.autoLogin(autoLogin, cookieId)) {
//                sessionMgr.create(session, cookieId);
//                view = "redirect:/";
//            }
//        }

        return new ModelAndView(view);
    }


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<MemberVO> doLogin(@RequestParam String uId,
                                            @RequestParam String uPw,
                                            @RequestParam(required = false) String save) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO memberDTO = memberService.login(uId, Password.of(uPw));
        if (memberDTO == null) return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);

       // if (save == null || !save.equals("on")) return new ResponseEntity<>(null, headers, HttpStatus.OK);

        System.out.println(memberDTO);

        return new ResponseEntity<>(memberDTO.toVO(), headers, HttpStatus.OK);
    }

}


