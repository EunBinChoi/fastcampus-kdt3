package org.example.overview.members.restcontroller.nonlogin;

import org.example.overview.members.dto.MemberDTO;
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
@RequestMapping("/members")
public class LoginRestController {

    private MemberService memberService ; //= MemberService.getInstance();


    @Autowired
    public LoginRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/login")
    public ResponseEntity<MemberVO> doLogin(@RequestParam String uId,
                                            @RequestParam String uPw,
                                            @RequestParam(required = false) String save) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO memberDTO = memberService.login(uId, uPw);
        if (memberDTO == null) return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);

        if (save == null || !save.equals("on")) return new ResponseEntity<>(null, headers, HttpStatus.OK);

        return new ResponseEntity<>(memberDTO.toVO(), headers, HttpStatus.OK);
    }

}


