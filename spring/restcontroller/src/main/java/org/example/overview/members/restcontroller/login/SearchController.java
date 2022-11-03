package org.example.overview.members.restcontroller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class SearchController { // 유저 검색 페이지 컨트롤러
    private MemberService memberService; // = MemberService.getInstance();

    private SessionMgr sessionMgr; // = SessionMgr.getInstance();


    @Autowired
    public SearchController(MemberService memberService, SessionMgr sessionMgr) {
        this.memberService = memberService;
        this.sessionMgr = sessionMgr;
    }


    @PostMapping(value = "/search",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MemberDTO> findByUserIdOrEmail(@RequestParam String q, HttpSession session) {
        if (q == null || q.equals("")) {
            return memberService.getAllUsers();
        }

        List<MemberDTO> memberDTOList = memberService.findByUserIdOrEmail(q);
        return memberDTOList;
    }



    public String getAllUsers(HttpSession session) {

        List<MemberDTO> memberDTOList = memberService.getAllUsers();
        if (memberDTOList != null) {
            return parseListToJSONArrayString(memberDTOList);
        }

        return "";
    }

    public String parseListToJSONArrayString(List<MemberDTO> memberDTOList) {
        JSONArray jsonArray = new JSONArray(); // List<Map<>>
        for (int i = 0; i < memberDTOList.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("uId", memberDTOList.get(i).getuId());
            map.put("uEmail", memberDTOList.get(i).getuEmail());

            JSONObject jsonObject = new JSONObject(map);
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }

    public String parseObjectToJSONObjectString(MemberDTO memberDTO) {
        Map<String, String> map = new HashMap<>();
        map.put("uId", memberDTO.getuId());
        map.put("uEmail", memberDTO.getuEmail());

        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }
}
