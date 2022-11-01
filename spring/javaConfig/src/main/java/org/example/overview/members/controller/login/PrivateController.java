package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class PrivateController { // 개인 설정 페이지 컨트롤러
    private MemberService memberService = MemberService.getInstance();

    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private SessionMgr sessionMgr = SessionMgr.getInstance();

    @GetMapping("/private")
    public String privatePage(Model model, HttpSession session) {
        String view = "members/login/private";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }

    @GetMapping("/private/rev")
    public String updatePage(Model model, HttpSession session) {
        String view = "members/login/update";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }


    @PostMapping("/private/rev/{uId}")
    public String updateUserPassword(@PathVariable String uId, @RequestParam String uPw, @RequestParam String uNewPw,
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

    @GetMapping("/private/rm")
    public String withdrawPage(Model model, HttpSession session) {
        String view = "members/login/withdraw";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }


    @PostMapping("/private/rm/{uId}")
    public String removeByUserId(@PathVariable String uId, @RequestParam String uPw, @RequestParam(required = false) String agree,
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
