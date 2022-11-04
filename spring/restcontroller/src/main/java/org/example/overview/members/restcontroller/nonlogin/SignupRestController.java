package org.example.overview.members.restcontroller.nonlogin;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class SignupRestController {
    private MemberService memberService; // = MemberService.getInstance();


    @Autowired
    public SignupRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/signup")
    public ResponseEntity<MemberVO> doSignup(@ModelAttribute MemberDTO memberDTO,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        boolean res = memberService.signup(memberDTO.getuId(), memberDTO.getuPwStr(), memberDTO.getuEmail());
        System.out.println(res);
        return new ResponseEntity<>(memberService.getByUserId(memberDTO.getuId()).toVO(), HttpStatus.OK);
    }

    @PostMapping(value = "/signup/checkId",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> checkDuplicateId(@RequestParam String uId) {
        if (uId == null || uId.equals("")) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        MemberDTO memberDTO = memberService.getByUserId(uId);
        if (memberDTO == null)  return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);

        return new ResponseEntity<>(Status.FAIL, HttpStatus.CONFLICT);
    }

}
