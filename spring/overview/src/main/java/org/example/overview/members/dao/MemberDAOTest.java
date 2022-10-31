package org.example.overview.members.dao;

import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;

public class MemberDAOTest {
    private MemberDAO memberDAO = MemberDAO.getInstance();

    public void addMembers() {
        int res = memberDAO.deleteAll();
        if (res == 0) return;

        for (int i = 'a'; i <= 'z'; i++) {
            memberDAO.insert(new Member(Character.toString(i), Password.of(Character.toString(i) + "1234", true).getuPw(), Character.toString(i) + "@gmail.com"));
        }

        memberDAO.selectAll().stream().forEach(m -> System.out.println(m));
    }

    public static void main(String[] args) {
        new MemberDAOTest().addMembers();
    }
}
