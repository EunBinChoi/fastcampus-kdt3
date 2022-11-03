package org.example.overview.members.restcontroller.login;

import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.service.SurveyService;
import org.example.overview.members.vo.SurveyVO;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

@RestController
@RequestMapping("/members")
public class SurveyController { // 개인 설정 페이지 컨트롤러

    private SurveyService surveyService; // = SurveyService.getInstance();

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @PostMapping("/survey/res/{uId}")
    public ResponseEntity doSurvey(@PathVariable String uId, @RequestParam String season, @RequestParam String fruit,
                           Model model, HttpSession session) {
        SurveyDTO surveyDTO = surveyService.getByUserId(uId);

        if (surveyDTO == null) {
            surveyService.save(uId, season, fruit);
        } else {
            surveyService.updateSeason(uId, season);
            surveyService.updateFruit(uId, fruit);
        }
        return new ResponseEntity(surveyDTO, HttpStatus.OK);
    }

    @GetMapping("/survey/res/{uId}")
    public ResponseEntity getSurveyResultByUserId(@PathVariable String uId, Model model, HttpSession session) {
        SurveyDTO surveyDTO = surveyService.getByUserId(uId);
        return new ResponseEntity(surveyDTO, HttpStatus.OK);
    }

}
