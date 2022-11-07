package org.example.overview.members.controller.nonlogin;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class SignupController {
    private MemberService memberService;


    @Autowired
    public SignupController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signupPage(HttpSession session) {
        String view = "members/nonlogin/signup";

        if (session.getAttribute("SESSION_ID") != null) {
            view = "redirect:/";
        }

        return view;
    }


    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<Status> doSignup(@ModelAttribute MemberDTO memberDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
            return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        }

        if (memberService.signup(memberDTO.getuId(), Password.of(memberDTO.getuPwStr()), memberDTO.getuEmail())) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }

        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/signup/checkId")
    @ResponseBody
    public ResponseEntity<Status> checkDuplicateId(@RequestParam String uId) {
//        if (uId == null || uId.equals("")) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        MemberDTO memberDTO = memberService.getByUserId(uId);
        if (memberDTO == null)  return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);

        return new ResponseEntity<>(Status.FAIL, HttpStatus.CONFLICT);
    }

}
