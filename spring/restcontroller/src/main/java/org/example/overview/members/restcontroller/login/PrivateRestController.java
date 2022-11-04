package org.example.overview.members.restcontroller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class PrivateRestController { // 개인 설정 페이지 컨트롤러
    private MemberService memberService; // = MemberService.getInstance();

    @Autowired
    public PrivateRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    // TODO: PK를 제외한 모든 개인정보를 수정하는 함수 만들기 (22.11.04)


    /* uPw와 uNewPw가 같으면 패스워드 업데이트 불가능 기능 추가 (22.11.03) */
    @PatchMapping("/private/{uId}")
    public ResponseEntity<MemberVO> updateUserPassword(@PathVariable("uId") String uId,
                                                       @RequestParam String uPw,
                                                       @RequestParam String uNewPw) {
        boolean res = memberService.updateUserPassword(uId, Password.of(uPw), Password.of(uNewPw));
        System.out.println(res);
        return new ResponseEntity<>(memberService.getByUserId(uId).toVO(), HttpStatus.OK);
    }


    @PostMapping(value = "/private/checkPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> checkPassword(@RequestBody Map<String, String> map) {
        if (map.get("uId") == null || map.get("uPw") == null || map.get("uId").equals("") || map.get("uPw").equals("")) {
            return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        }

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setuId(map.get("uId"));
        memberDTO.setuPw(Password.of(map.get("uPw")));

        if (memberDTO == null) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        Status status = memberService.checkPassword(memberDTO.getuId(), memberDTO.getuPw())
                ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/private/checkNewPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> checkNewPassword(@RequestBody Map<String, String> map) { // uId, uNewPw
        if (map.get("uId") == null || map.get("uNewPw") == null || map.get("uId").equals("") || map.get("uNewPw").equals("")) {
            return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        }

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setuId(map.get("uId"));
        memberDTO.setuNewPw(Password.of(map.get("uNewPw")));

        Status status = memberService.checkNewPassword(memberDTO.getuId(), memberDTO.getuNewPw())
                ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @DeleteMapping("/private/{uId}")
    public ResponseEntity<Status> removeByUserId(@PathVariable String uId,
                                 @RequestParam String uPw,
                                 @RequestParam(required = false) String agree) {
        if (agree == null || !agree.equals("yes")) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        Status status = memberService.removeByUserId(uId, Password.of(uPw))
                ? Status.SUCCESS : Status.FAIL;
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
