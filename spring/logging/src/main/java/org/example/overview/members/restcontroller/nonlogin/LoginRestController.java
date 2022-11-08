package org.example.overview.members.restcontroller.nonlogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.exception.DatabaseDuplicateException;
import org.example.overview.exception.InputInvalidException;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;


@RestController
@RequestMapping("")
public class LoginRestController {
    private MemberService memberService ; //= MemberService.getInstance();


    @Autowired
    public LoginRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/login")
    public ResponseEntity<MemberVO> doLogin(@RequestParam String uId,
                                            @RequestParam String uPw,
                                            @RequestParam(required = false) String save) throws InputInvalidException {

        MemberDTO memberDTO = memberService.login(uId, Password.of(uPw));
        if (memberDTO == null) {
            throw new InputInvalidException("user information is invalid.");
        }


       // if (save == null || !save.equals("on")) return new ResponseEntity<>(null, headers, HttpStatus.OK);

        return new ResponseEntity<>(memberDTO.toVO(), HttpStatus.OK);
    }

}


