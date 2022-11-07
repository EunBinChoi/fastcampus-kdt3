package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/members")
public class PrivateController { // 개인 설정 페이지 컨트롤러
    private MemberService memberService;
    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;

    @Autowired
    public PrivateController(MemberService memberService, SessionMgr sessionMgr, CookieMgr cookieMgr) {
        this.memberService = memberService;
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
    }

    @GetMapping("/private")
    public ModelAndView privatePage() {
        String view = "members/login/private";
        ModelAndView modelAndView = new ModelAndView(view);
        return modelAndView;
    }

    @GetMapping("/private/update")
    public ModelAndView updatePage() {
        String view = "members/login/update";
        ModelAndView modelAndView = new ModelAndView(view);
        return modelAndView;
    }

    @GetMapping("/private/withdraw")
    public ModelAndView withdrawPage() {
        String view = "members/login/withdraw";
        ModelAndView modelAndView = new ModelAndView(view);
        return modelAndView;
    }



    /* PK를 제외한 모든 개인정보를 수정하는 함수 추가 (22.11.04) */
    @PostMapping("/private/updateEmail/{uId}")
    public ResponseEntity<Status> updateUserEmail(@PathVariable(value = "uId") String uId,
                                                  @RequestParam String uEmail) { // uEmail 말고 더 많은 사용자 정보 수정이 있을 수 있음

        if (memberService.updateUserEmail(uId, uEmail)) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }


    /* uPw와 uNewPw가 같으면 패스워드 업데이트 불가능 기능 추가 (22.11.03) */
    @PostMapping("/private/updatePwd/{uId}")
    public ResponseEntity<Status> updateUserPassword(@PathVariable("uId") String uId,
                                                       @RequestParam String uPw, // required
                                                       @RequestParam String uNewPw) { // required

        if (memberService.updateUserPassword(uId, Password.of(uPw), Password.of(uNewPw))) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/private/checkPwd")
    @ResponseBody
    public ResponseEntity<Status> checkPassword(@RequestBody Map<String, String> map) {
        if (UtilsMethod.isNullOrEmpty(map.get("uId"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(map.get("uPw"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        Status status = memberService.checkPassword(map.get("uId"), Password.of(map.get("uPw")))
                ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/private/checkNewPwd")
    @ResponseBody
    public ResponseEntity<Status> checkNewPassword(@RequestBody Map<String, String> map) { // uId, uNewPw
        if (UtilsMethod.isNullOrEmpty(map.get("uId"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(map.get("uNewPw"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);


        Status status = memberService.checkNewPassword(map.get("uId"), Password.of(map.get("uNewPw")))
                ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @PostMapping("/private/{uId}")
    public ResponseEntity<Status> removeByUserId(@PathVariable String uId,
                                 @RequestParam String uPw,
                                 @RequestParam(required = false) String agree) {
        if (agree == null || !agree.equals("yes")) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);


        Status status = memberService.removeByUserId(uId, Password.of(uPw))
                ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
