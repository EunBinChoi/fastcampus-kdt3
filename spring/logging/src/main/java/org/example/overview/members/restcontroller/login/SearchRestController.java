package org.example.overview.members.restcontroller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class SearchRestController { // 유저 검색 페이지 컨트롤러
    private MemberService memberService;

    // 한명씩 조회하는 함수 만듦 (22.11.04)
    @GetMapping(value = "/{uId}")
    public ResponseEntity<MemberVO> findByUserId(@PathVariable String uId) {
        return new ResponseEntity<>(memberService.getByUserId(uId).toVO(), HttpStatus.OK);
    }

    @GetMapping(value = "",
            //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberVO>> findByUserIdOrEmail(@RequestParam(required = false) String q) {
        if (UtilsMethod.isNullOrEmpty(q)) {
            List<MemberDTO> memberDTOList = memberService.getAllUsers();
            List<MemberVO> memberVOList = memberDTOList.stream().map(m -> m.toVO()).collect(Collectors.toList());
            return new ResponseEntity<>(memberVOList, HttpStatus.OK);
        }

        List<MemberDTO> memberDTOList = memberService.findByUserIdOrEmail(q);
        List<MemberVO> memberVOList = memberDTOList.stream().map(m -> m.toVO()).collect(Collectors.toList());
        return new ResponseEntity<>(memberVOList, HttpStatus.OK);
    }
}
