package org.example.overview.members.dao;


import org.example.overview.members.entity.Member;
import org.example.overview.members.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAO implements IMemberDAO {
    private MemberMapper memberMapper;

    @Autowired
    public MemberDAO(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<Member> search(String q) {
        return memberMapper.search(q);
    }

    @Override
    public Member select(String uId) {
        return memberMapper.select(uId);
    }

    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }


    @Override
    public int updatePassword(String uId, String uPw) {
        return memberMapper.updatePassword(uId, uPw);
    }

    @Override
    public int updateEmail(String uId, String uEmail) {
        return memberMapper.updateEmail(uId, uEmail);
    }

    @Override
    public int delete(String uId) {
        return memberMapper.delete(uId);
    }

    @Override
    public int deleteAll() {
        return memberMapper.deleteAll();
    }
}

