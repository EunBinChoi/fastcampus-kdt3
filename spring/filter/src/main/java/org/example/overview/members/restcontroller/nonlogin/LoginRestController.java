package org.example.overview.members.restcontroller.nonlogin;

import exception.InputInvalidException;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("")
public class LoginRestController {

    private MemberService memberService ;

    @Autowired
    public LoginRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/login")
    public ResponseEntity<MemberVO> doLogin(@RequestParam(required = false) String uId,
                                            @RequestParam(required = false) String uPw,
                                            @RequestParam(required = false) String save) throws InputInvalidException {

        MemberDTO memberDTO = memberService.login(uId, Password.of(uPw));
        System.out.println("memberDTO = " + memberDTO);
        if (memberDTO == null) throw new InputInvalidException();


       // if (save == null || !save.equals("on")) return new ResponseEntity<>(null, headers, HttpStatus.OK);


        return new ResponseEntity<>(memberDTO.toVO(), HttpStatus.OK);
    }

}


