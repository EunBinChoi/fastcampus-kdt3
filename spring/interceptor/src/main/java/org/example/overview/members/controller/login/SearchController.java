package org.example.overview.members.controller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/members")
public class SearchController { // 유저 검색 페이지 컨트롤러
    private MemberService memberService;

    @Autowired
    public SearchController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/search")
    public ModelAndView searchPage() {
        String view = "members/login/search";
        ModelAndView modelAndView = new ModelAndView(view);

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/login";
//        }

//        if (session.getAttribute("SESSION_ID") != null) {
//            model.addAttribute("uId", sessionMgr.get(session));
//        }

        return modelAndView;
    }



    // 한명씩 조회하는 함수 만들기 (22.11.04)
    @GetMapping(value = "/{uId}")
    @ResponseBody
    public ResponseEntity<MemberVO> findByUserId(@PathVariable String uId) {
        return new ResponseEntity<>(memberService.getByUserId(uId).toVO(), HttpStatus.OK);
    }

    @GetMapping(value = "")
    @ResponseBody
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
