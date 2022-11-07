package org.example.overview.members.controller.login;

import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.service.SurveyService;
import org.example.overview.members.vo.SurveyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class SurveyController { // 개인 설정 페이지 컨트롤러

    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/survey")
    public ModelAndView surveyPage(Model model, HttpSession session) {
        String view = "members/login/survey";
        ModelAndView modelAndView = new ModelAndView(view);

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }

//        model.addAttribute("uId", sessionMgr.get(session));
        return modelAndView;
    }

    @GetMapping("/survey/res")
    public ModelAndView surveyResPage(Model model, HttpSession session) {
        String view = "members/login/surveyResult";
        ModelAndView modelAndView = new ModelAndView(view);

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("uId", sessionMgr.get(session));
        return modelAndView;
    }




    // 서베이 결과를 수정하는 함수 작성 (22.11.04)
    @PutMapping("/survey/{uId}")
    @ResponseBody
    public ResponseEntity<SurveyVO> updateSurveyResult(@PathVariable String uId,
                                                       @ModelAttribute SurveyDTO surveyDTO) {
//        if (surveyDTO == null) new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        SurveyDTO surveyServiceByUserId = surveyService.getByUserId(uId);

        if (surveyServiceByUserId != null) {
            surveyService.updateSeason(uId, surveyDTO.getSeason());
            surveyService.updateFruit(uId, surveyDTO.getFruit());
        }
        return new ResponseEntity(surveyService.getByUserId(uId).toVO(), HttpStatus.OK);
    }


    @PostMapping("/survey/{uId}")
    @ResponseBody
    public ResponseEntity<SurveyVO> doSurvey(@PathVariable String uId,
                                             @ModelAttribute SurveyDTO surveyDTO) {
//        if (surveyDTO == null) return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        SurveyDTO surveyServiceByUserId = surveyService.getByUserId(uId);

        if (surveyServiceByUserId == null) {
            surveyService.save(uId, surveyDTO.getSeason(), surveyDTO.getFruit());
        }

//        else {
//            surveyService.updateSeason(uId, surveyDTO.getSeason());
//            surveyService.updateFruit(uId, surveyDTO.getFruit());
//        }
        return new ResponseEntity(surveyService.getByUserId(uId).toVO(), HttpStatus.OK);
    }

    @GetMapping("/survey/{uId}")
    @ResponseBody
    public ResponseEntity<SurveyVO> getSurveyResultByUserId(@PathVariable String uId) {
        SurveyDTO surveyDTO = surveyService.getByUserId(uId);

        if (surveyDTO == null) return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity(surveyDTO.toVO(), HttpStatus.OK);
    }

}
