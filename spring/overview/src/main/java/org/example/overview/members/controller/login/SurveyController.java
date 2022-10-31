package org.example.overview.members.controller.login;

import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.service.SurveyService;
import org.example.overview.members.vo.SurveyVO;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/members")
public class SurveyController { // 개인 설정 페이지 컨트롤러

    private SurveyService surveyService = SurveyService.getInstance();

    private SessionMgr sessionMgr = SessionMgr.getInstance();

    @GetMapping("/survey")
    public String surveyPage(Model model, HttpSession session) {
        String view = "members/login/survey";

        String uId = "";
        if (session.getAttribute("SESSION_ID") != null) {
            uId = sessionMgr.get(session);
            model.addAttribute("uId", uId);
        }

        return view;
    }

    @GetMapping("/survey/res")
    public String surveyResPage(Model model, HttpSession session) {
        String view = "members/login/surveyResult";

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        } else {
            view = "redirect:/";
        }

        return view;
    }


    @PostMapping("/survey/res")
    public String doSurvey(@RequestParam String season, @RequestParam String fruit,
                           Model model, HttpSession session) {
        String view = surveyResPage(model, session);

        String uId = "";
        if (session.getAttribute("SESSION_ID") != null) {
            uId = sessionMgr.get(session);
            SurveyDTO surveyDTO = surveyService.getByUserId(uId);

            if (surveyDTO == null) {
                surveyService.save(uId, season, fruit);
            } else {
                surveyService.updateSeason(uId, season);
                surveyService.updateFruit(uId, fruit);
            }

            model.addAttribute("survey", new SurveyVO(season, fruit));
        } else {
            view = "redirect:/";
        }

        return view;
    }

    @GetMapping("/survey/res/{uId}")
    public String getSurveyResultByUserId(@PathVariable String uId, Model model, HttpSession session) {
        String view = surveyPage(model, session);
        Status respStatus = Status.FAIL;

        SurveyDTO surveyDTO = surveyService.getByUserId(uId);
        if (surveyDTO != null) {
            model.addAttribute("survey", surveyDTO.toVO());
            respStatus = Status.SUCCESS;
        }

        return view;
    }

}
