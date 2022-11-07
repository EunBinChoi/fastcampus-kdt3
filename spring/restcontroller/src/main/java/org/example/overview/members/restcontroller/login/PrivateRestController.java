package org.example.overview.members.restcontroller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.utils.Status;
import org.example.overview.utils.UtilsMethod;
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

    /* PK를 제외한 모든 개인정보를 수정하는 함수 추가 (22.11.04) */
    @PutMapping("/private/{uId}")
    public ResponseEntity<Status> updateUserEmail(@PathVariable(value = "uId") String uId,
                                                        @RequestBody Map<String, String> map) { // uEmail 말고 더 많은 사용자 정보 수정이 있을 수 있음
//        if (UtilsMethod.isNullOrEmpty(map.get("uPw"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
//        if (UtilsMethod.isNullOrEmpty(map.get("uNewPw"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(map.get("uNewEmail"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

//        MemberDTO memberDTO = new MemberDTO(uId, Password.of(map.get("uPw")), Password.of(map.get("uNewPw")), );
//        System.out.println(memberDTO);

        if (memberService.updateUserEmail(uId, map.get("uNewEmail"))) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }


    /* uPw와 uNewPw가 같으면 패스워드 업데이트 불가능 기능 추가 (22.11.03) */
    @PatchMapping("/private/{uId}")
    public ResponseEntity<Status> updateUserPassword(@PathVariable("uId") String uId,
                                                       @RequestParam String uPw, // required
                                                       @RequestParam String uNewPw) { // required
        if (memberService.updateUserPassword(uId, Password.of(uPw), Password.of(uNewPw))) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/private/checkPwd")
            //consumes = MediaType.APPLICATION_JSON_VALUE,
            //produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> checkPassword(@RequestBody Map<String, String> map) {
        if (UtilsMethod.isNullOrEmpty(map.get("uId"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(map.get("uPw"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

//        if (map.get("uId") == null || map.get("uPw") == null || map.get("uId").equals("") || map.get("uPw").equals("")) {
//            return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
//        }

        if (memberService.checkPassword(map.get("uId"), Password.of(map.get("uPw")))) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/private/checkNewPwd",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> checkNewPassword(@RequestBody Map<String, String> map) { // uId, uNewPw
        if (UtilsMethod.isNullOrEmpty(map.get("uId"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
        if (UtilsMethod.isNullOrEmpty(map.get("uNewPw"))) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
//        if (map.get("uId") == null || map.get("uNewPw") == null || map.get("uId").equals("") || map.get("uNewPw").equals("")) {
//            return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
//        }


        if (memberService.checkNewPassword(map.get("uId"), Password.of(map.get("uNewPw")))) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/private/{uId}")
    public ResponseEntity<Status> removeByUserId(@PathVariable String uId,
                                 @RequestParam String uPw,
                                 @RequestParam(required = false) String agree) {
        if (agree == null || !agree.equals("yes")) return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        if (memberService.removeByUserId(uId, Password.of(uPw))) {
            return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(Status.FAIL, HttpStatus.BAD_REQUEST);
    }
}
