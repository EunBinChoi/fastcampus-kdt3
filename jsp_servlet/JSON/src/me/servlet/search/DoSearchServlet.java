package me.servlet.search;

import me.java.member.Member;
import me.java.member.MemberDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DoSearchServlet", value = "/DoSearchServlet")
public class DoSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("q");
        System.out.println("keyword = " + keyword);
        response.getWriter().write(getJSON(keyword));
    }

    public String getJSON(String keyword) {
        if (keyword == null) keyword = "";

        MemberDAO memberDAO = MemberDAO.getInstance();
        List<Member> list = memberDAO.search(keyword);

        JSONArray jsonArray = new JSONArray(); // List<Map<>>
        for(int i = 0; i < list.size(); i ++) {
            Map<String, String> map = new HashMap<>();
            map.put("uId",   list.get(i).getuId());
            map.put("uEmail", list.get(i).getuEmail());

            JSONObject jsonObject = new JSONObject(map);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }
}
