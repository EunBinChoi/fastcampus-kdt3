<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*, member.Member"%>
<html>
<head>
  <title>JSP Title</title>
</head>
<body>
<%-- JSP 주석 --%>
<!-- html 주석 -->
<h2>Static Part</h2>


<%-- 선언문 (전역변수, 함수 정의) --%>
<%!
  static final String CURRENT_FILE = "index.jsp";
%>


<%-- 스크립트릿 (지역변수 정의, _jspService() 함수 내에 정의) (자바 코드 해석해야하는 부분, 브라우저에 출력되지 않음) --%>
<%
  LocalDateTime now = LocalDateTime.now();
  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  String formatDateTime = now.format(format);
%>

<%-- 표현식 (자바 코드 해설 결과 브라우저에 출력되는 부분)  --%>
<h2>Dynamic Part: <%=formatDateTime%></h2>

<%-- <%=var%> --%> <%-- 오류 발생 X --%>
<%--<!-- <%=var%> -->--%> <%-- 오류 발생 O (동적인 요소를 해석할 수 없음 (변수 존재하지 않음) --%>

<h2>Current FIle: <%=CURRENT_FILE%></h2>


<%-- 객체 가지고 오기 --%>
<%
  final int MEMBER_NUM = 3;
  List<Member> memberList = new ArrayList<>();

  for (int i = 0; i < MEMBER_NUM; i++) {
    memberList.add(new Member(Character.toString('a' + i), (int)(Math.random() * 100) + 1));
  }

  out.println("[ Member List ]");
  out.println("</br>");
  for (Member member: memberList) {
    out.println(member);
    out.println("</br>");
  }

  // 나이를 구하는 average 함수를 정의해보시오.
  // out.println("➡️ 나이 평균 : " + average(memberList));
%>


</body>
</html>