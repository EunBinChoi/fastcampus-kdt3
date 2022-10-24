<%@ page info="Directive Tag Description Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*, member.Member" %>
<%@ page session="true" %>
<%-- 지시자 (jsp 페이지가 실행될 떄 필요한 정보를 jsp 컨테이너 (catalina)에게 알리는 역할) --%>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header><jsp:include page="header.jsp"/></header>
<main>
    <%-- JSP 주석 --%>
    <!-- html 주석 -->
    <div>
        <h1>Static Part 🗿</h1>


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
        <h1>Dynamic Part: <%=formatDateTime%> 🚗</h1>

        <%-- <%=var%> --%> <%-- 오류 발생 X --%>
        <%--<!-- <%=var%> -->--%> <%-- 오류 발생 O (동적인 요소를 해석할 수 없음 (변수 존재하지 않음) --%>

        <h1>Current FIle: <%=CURRENT_FILE%></h1>
    </div>

    <div class="main__memberList">
        <%-- 객체 가지고 오기 --%>
        <%
            final int MEMBER_NUM = 3;
            List<Member> memberList = new ArrayList<>();

            for (int i = 0; i < MEMBER_NUM; i++) {
                memberList.add(new Member(Character.toString('a' + i), (int) (Math.random() * 100) + 1));
            }

            out.println("<ul>📌 Member List</ul>");
            for (Member member : memberList) {
                out.print("<li>");
                out.print(member);
                out.print("</li>");
            }

            // 나이 평균을 구하는 average 함수를 정의해보시오.
            out.println("➡️ 나이 평균 : " + average(memberList));
        %>
        <p>코드의 수정</p>
        <%!
            public double average(List<Member> memberList) {
                double avg = 0.0;
                for (Member member : memberList) {
                    avg += member.getAge();
                }
                return avg / memberList.size();
            }
        %>
    </div>

        <ul class="main__nav__next">
            <li>👉🏻<a href="request.jsp"><b> ErrorPage 예제로 이동</b></a></li>
            <li>👉🏻<a href="includeDirective.jsp"><b> include 지시자 예제로 이동</b></a></li>
            <li>👉🏻<a href="includeActionTag.jsp"><b> include 액션태그 예제로 이동</b></a></li>
        </ul>

</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>