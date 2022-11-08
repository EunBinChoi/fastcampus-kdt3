package org.example.overview.members.restcontroller.nonlogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.exception.DatabaseDuplicateException;
import org.example.overview.exception.InputEmptyException;
import org.example.overview.exception.InputInvalidException;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
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
    public ResponseEntity<Status> doSignup(@ModelAttribute MemberDTO memberDTO, BindingResult bindingResult) throws InputEmptyException, DatabaseDuplicateException, InputInvalidException {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
            throw new InputInvalidException();
        }

        if (UtilsMethod.isNullOrEmpty(memberDTO.getuId())) throw new InputEmptyException();
        if (UtilsMethod.isNullOrEmpty(memberDTO.getuPwStr())) throw new InputEmptyException();
        if (UtilsMethod.isNullOrEmpty(memberDTO.getuEmail())) throw new InputEmptyException();

        if (memberService.signup(memberDTO.getuId(), Password.of(memberDTO.getuPwStr()), memberDTO.getuEmail())) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }


        throw new DatabaseDuplicateException("user information is duplicated.");
    }

    @PostMapping(value = "/signup/checkId")
            //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            //produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> duplicateId(@RequestParam(required = false) String uId) throws DatabaseDuplicateException, InputEmptyException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));


        if (UtilsMethod.isNullOrEmpty(uId)) throw new InputEmptyException("User ID is invalid.");

        MemberDTO memberDTO = memberService.getByUserId(uId);
        if (memberDTO == null)  return new ResponseEntity<>(Status.SUCCESS, headers, HttpStatus.OK);

        throw new DatabaseDuplicateException("user information is duplicated.");
    }

}
