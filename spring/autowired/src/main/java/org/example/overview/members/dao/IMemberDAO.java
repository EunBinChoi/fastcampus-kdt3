package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;

import java.util.List;

public interface IMemberDAO {

    List<Member> search(String q);
    Member select(String uId);
    List<Member> selectAll();
    int insert(Member member);
    int insertAll(List<Member> members);
    int update(String uId, String uPw);
    int delete(String uId);
    int deleteAll();
}
