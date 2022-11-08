package org.example.overview.members.restcontroller.login;

import org.example.overview.exception.InputEmptyException;
import org.example.overview.exception.InputInvalidException;
import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.service.SurveyService;
import org.example.overview.members.vo.SurveyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class SurveyRestController { // 개인 설정 페이지 컨트롤러

    private SurveyService surveyService; // = SurveyService.getInstance();

    @Autowired
    public SurveyRestController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/survey/{uId}")
    public ResponseEntity<SurveyVO> doSurvey(@PathVariable String uId,
                                             @ModelAttribute SurveyDTO surveyDTO) throws InputInvalidException {
        SurveyDTO surveyServiceByUserId = surveyService.getByUserId(uId);

        if (surveyServiceByUserId == null) {
            surveyService.save(uId, surveyDTO.getSeason(), surveyDTO.getFruit());
            return new ResponseEntity(surveyService.getByUserId(uId).toVO(), HttpStatus.OK);
        }

        throw new InputInvalidException();
    }


    // 서베이 결과를 수정하는 함수 작성 (22.11.04)
    @PutMapping("/survey/{uId}")
    public ResponseEntity<SurveyVO> updateSurveyResult(@PathVariable String uId,
                                                       @ModelAttribute SurveyDTO surveyDTO) throws InputInvalidException {
        SurveyDTO surveyServiceByUserId = surveyService.getByUserId(uId);

        if (surveyServiceByUserId != null) {
            surveyService.updateSeason(uId, surveyDTO.getSeason());
            surveyService.updateFruit(uId, surveyDTO.getFruit());
            return new ResponseEntity(surveyService.getByUserId(uId).toVO(), HttpStatus.OK);
        }
        throw new InputInvalidException();
    }


    @GetMapping("/survey/{uId}")
    public ResponseEntity<SurveyVO> getSurveyResultByUserId(@PathVariable String uId) throws InputEmptyException {
        SurveyDTO surveyDTO = surveyService.getByUserId(uId);

        if (surveyDTO == null) throw new InputEmptyException();
        return new ResponseEntity(surveyDTO.toVO(), HttpStatus.OK);
    }

}
