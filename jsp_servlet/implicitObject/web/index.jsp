<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page session="true"%>
<%-- 지시자 (jsp 페이지가 실행될 떄 필요한 정보를 jsp 컨테이너 (catalina)에게 알리는 역할) --%>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    Date sessionCreationTime = new Date();
    Date lastAccessedTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div>세션 ID: <%=session.getId()%></div>
    <%
        sessionCreationTime.setTime(session.getCreationTime());
    %>
    <div>세션 생성시간: <%=formatter.format(sessionCreationTime)%></div>
    <%
        lastAccessedTime.setTime(session.getLastAccessedTime());
    %>
    <div>최근 접속시간: <%=formatter.format(lastAccessedTime)%></div>

    <%-- JSP 주석 --%>
    <!-- html 주석 -->
    <div>
        <%
            String pageINFO = this.getServletInfo();
            String serverINFO = application.getServerInfo();
            String mimeTypeHTML = application.getMimeType("html.html");
            String mimeTypeTEXT = application.getMimeType("text.text");
            String realPath = application.getRealPath("/");

            out.println("pageINFO => " + pageINFO + "<br/>");
            out.println("serverINFO => " + serverINFO + "<br/>");
            out.println("mimeTypeHTML => " + mimeTypeHTML + "<br/>");
            out.println("mimeTypeTEXT => " + mimeTypeTEXT + "<br/>");
            out.println("realPath => " + realPath + "<br/>");

            application.log("this is log! 😡");
            // 서버 로그 파일에 내용을 기록
            // CATALINA_BASE/logs/localhost.2022-...log
        %>

    </div>


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

        <h1>Current FIle: <%=CURRENT_FILE%>
        </h1>
    </div>

    <ul class="main__nav__next">
        <li>👉🏻<a href="login.jsp"><b> Implicit Object 예제로 이동</b></a></li>
    </ul>

</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>