package org.example.overview.members.restcontroller.nonlogin;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.utils.Status;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@RequestMapping("")
public class SignupRestController {
    private MemberService memberService; // = MemberService.getInstance();


    @Autowired
    public SignupRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/signup")
    public ResponseEntity<Status> doSignup(@ModelAttribute MemberDTO memberDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
            return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        }

        if (UtilsMethod.isNullOrEmpty(memberDTO.getuId())) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(memberDTO.getuPwStr())) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(memberDTO.getuEmail())) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        if (memberService.signup(memberDTO.getuId(), Password.of(memberDTO.getuPwStr()), memberDTO.getuEmail())) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }

        return new ResponseEntity<>(Status.FAIL, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "/signup/checkId")
            //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            //produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> duplicateId(@RequestParam(required = false) String uId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));


        if (UtilsMethod.isNullOrEmpty(uId)) return new ResponseEntity<>(Status.NULL, headers, HttpStatus.BAD_REQUEST);

        MemberDTO memberDTO = memberService.getByUserId(uId);
        if (memberDTO == null)  return new ResponseEntity<>(Status.SUCCESS, headers, HttpStatus.OK);

        return new ResponseEntity<>(Status.FAIL, headers, HttpStatus.CONFLICT);
    }

}
