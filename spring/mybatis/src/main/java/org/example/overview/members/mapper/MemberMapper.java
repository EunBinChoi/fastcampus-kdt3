package org.example.overview.members.mapper;

import org.apache.ibatis.annotations.*;
import org.example.overview.members.entity.Member;

import java.util.List;


@Mapper
public interface MemberMapper {

    @ResultType(List.class)
    @Select("select * from member where uId like concat('%', #{q}, '%') or uEmail like concat('%', #{q}, '%')")
    List<Member> search(@Param("q") String q);

    @ResultType(Member.class)
    @Select("select * from member where uId = #{uId}")
    Member select(@Param("uId") String uId);

    @ResultType(List.class)
    @Select("select * from member")
    List<Member> selectAll();

    @ResultType(Integer.class)
    @Insert("insert into member values(#{member.uId}, #{member.uPw}, #{member.uEmail})")
    int insert(@Param("member") Member member);

    @ResultType(Integer.class)
    @Update("update member set uPw = #{uPw} where uId = #{uId}")
    int updatePassword(@Param("uId") String uId, @Param("uPw") String uPw);

    @ResultType(Integer.class)
    @Update("update member set uEmail = #{uEmail} where uId = #{uId}")
    int updateEmail(@Param("uId") String uId, @Param("uEmail") String uEmail);

    @ResultType(Integer.class)
    @Delete("delete member where uId = #{uId}")
    int delete(@Param("uId") String uId);

    @ResultType(Integer.class)
    @Delete("delete member")
    int deleteAll();
}
