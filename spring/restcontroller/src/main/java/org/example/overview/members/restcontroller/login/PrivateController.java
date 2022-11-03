package org.example.overview.members.restcontroller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    public PrivateController(MemberService memberService) {
        this.memberService = memberService;
    }


    /* uPw와 uNewPw가 같으면 패스워드 업데이트 불가능 기능 추가 (22.11.03) */
    @PatchMapping({"/private", "/private/{uId}"})
    public ResponseEntity updateUserPassword(@PathVariable(required = false) String uId,
                                     @RequestParam(required = false) String uPw,
                                     @RequestParam(required = false) String uNewPw) {


        String res = String.valueOf(memberService.updateUserPassword(uId, Password.of(uPw), Password.of(uNewPw)));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping(value = "/private/checkPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity checkPassword(@RequestBody MemberDTO memberDTO) { // uId, uPw
        Status status = Status.FAIL;
        if (memberDTO == null) return new ResponseEntity<>(status, HttpStatus.OK);

        if (memberService.checkPassword(memberDTO.getuId(), Password.of(memberDTO.getuPwStr()))) {
            status = Status.SUCCESS;
        }

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/private/checkNewPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE, // "{"uId": "", "uNewPw": ""}"
            produces = MediaType.APPLICATION_JSON_VALUE) // "SUCCESS", "FAIL"
    public ResponseEntity checkNewPassword(@RequestBody MemberDTO memberDTO) { // uId, uNewPw
        //System.out.println("memberDTO = " + memberDTO);
        if (memberDTO == null) return Status.NULL;


        boolean res = memberService.checkNewPassword(memberDTO.getuId(), Password.of(memberDTO.getuNewPwStr()));
        Status status = Status.FAIL;

        if (res) {
            status = Status.SUCCESS;
        }

        System.out.println("res = " + res);
        return status;
    }


    @DeleteMapping("/private/{uId}")
    public ResponseEntity removeByUserId(@PathVariable String uId,
                                 @RequestParam String uPw,
                                 @RequestParam(required = false) String agree) {


        String res = String.valueOf(memberService.removeByUserId(uId, Password.of(uPw)));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
