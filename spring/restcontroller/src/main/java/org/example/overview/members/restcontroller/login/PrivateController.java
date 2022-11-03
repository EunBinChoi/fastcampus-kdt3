package org.example.overview.members.restcontroller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/members")
public class PrivateController { // 개인 설정 페이지 컨트롤러
    private MemberService memberService; // = MemberService.getInstance();

    private CookieMgr cookieMgr; // = CookieMgr.getInstance();
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();

    @Autowired
    public PrivateController(MemberService memberService, CookieMgr cookieMgr, SessionMgr sessionMgr) {
        this.memberService = memberService;
        this.cookieMgr = cookieMgr;
        this.sessionMgr = sessionMgr;
    }


    /* uPw와 uNewPw가 같으면 패스워드 업데이트 불가능 기능 추가 (22.11.03) */
    @PostMapping({"/private/rev", "/private/rev/{uId}"})
    public String updateUserPassword(@PathVariable(required = false) String uId,
                                     @RequestParam(required = false) String uPw,
                                     @RequestParam(required = false) String uNewPw,
                                     Model model, HttpSession session) {
        String view = updatePage(model, session);
        Status respStatus = Status.FAIL;


        if (!session.getAttribute("SESSION_ID").equals(uId)) {
            session.setAttribute("update", respStatus);
            return view;
        }

        if (memberService.updateUserPassword(uId, Password.of(uPw), Password.of(uNewPw))) {
            view = "redirect:/members/private";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("update", respStatus);
        return view;
    }


    @PostMapping(value = "/private/checkPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Status checkPassword(@RequestBody MemberDTO memberDTO) { // uId, uPw
        System.out.println("memberDTO = " + memberDTO);
        if (memberDTO == null) return Status.NULL;


        boolean res = memberService.checkPassword(memberDTO.getuId(), Password.of(memberDTO.getuPwStr()));
        Status status = Status.FAIL;

        if (res) {
            status = Status.SUCCESS;
        }

        System.out.println("res = " + res);
        return status;
    }

    @PostMapping(value = "/private/checkNewPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE, // "{"uId": "", "uNewPw": ""}"
            produces = MediaType.APPLICATION_JSON_VALUE) // "SUCCESS", "FAIL"
    @ResponseBody
    public Status checkNewPassword(@RequestBody MemberDTO memberDTO) { // uId, uNewPw
        System.out.println("memberDTO = " + memberDTO);
        if (memberDTO == null) return Status.NULL;


        boolean res = memberService.checkNewPassword(memberDTO.getuId(), Password.of(memberDTO.getuNewPwStr()));
        Status status = Status.FAIL;

        if (res) {
            status = Status.SUCCESS;
        }

        System.out.println("res = " + res);
        return status;
    }


    @PostMapping("/private/rm/{uId}")
    public String removeByUserId(@PathVariable String uId,
                                 @RequestParam String uPw,
                                 @RequestParam(required = false) String agree,
                                 Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        String view = withdrawPage(model, session);
        Status respStatus = Status.FAIL;

        if (!session.getAttribute("SESSION_ID").equals(uId)) {
            session.setAttribute("withdraw", respStatus);
            return view;
        }
        if (agree == null || !agree.equals("yes")) {
            session.setAttribute("withdraw", respStatus);
            return view;
        }

        if (memberService.removeByUserId(uId, Password.of(uPw))) {

            cookieMgr.delete(request, response);
            sessionMgr.delete(session);

            session = request.getSession(); // 새로운 세션 생성 (새로운 세션 만들어 redirect 하기 위함)

            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("withdraw", respStatus);
        return view;

    }
}
