package org.example.overview.members.controller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.sessions.SessionMgr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/members")
public class SearchController { // 유저 검색 페이지 컨트롤러
    private MemberService memberService; // = MemberService.getInstance();

    private SessionMgr sessionMgr; // = SessionMgr.getInstance();


    @Autowired
    public SearchController(MemberService memberService, SessionMgr sessionMgr) {
        this.memberService = memberService;
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/search")
    public String searchPage(Model model, HttpSession session) {

        String view = "members/login/search";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        }

        return view;
    }


    @PostMapping(value = "/search",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MemberVO> findByUserIdOrEmail(@RequestParam(required = false) String q) {
        if (q == null || q.equals("")) {
            List<MemberDTO> memberDTOList = memberService.getAllUsers();
            List<MemberVO> memberVOList = memberDTOList.stream().map(m -> m.toVO()).collect(Collectors.toList());
            return memberVOList;
        }

        List<MemberDTO> memberDTOList = memberService.findByUserIdOrEmail(q);
        List<MemberVO> memberVOList = memberDTOList.stream().map(m -> m.toVO()).collect(Collectors.toList());
        return memberVOList;
    }

}
