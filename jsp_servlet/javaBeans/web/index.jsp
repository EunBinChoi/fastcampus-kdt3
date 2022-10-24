<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, simple.SimpleBeans"%>

<%-- 자바 빈즈 객체 생성 --%>
<jsp:useBean id="simple" class="simple.SimpleBeans" type="simple.SimpleBeans" scope="page"/>

<jsp:setProperty name="simple" property="name" value="a"/>
<jsp:setProperty name="simple" property="value" value="a123!"/>

<%
//    SimpleBeans simple = new SimpleBeans(); // 이렇게 쓰는 것과 동일 (해당 페이지 공간안에 객체 변수 이름 중복 조심)

%>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header><jsp:include page="header.jsp"/></header>
<main>
   <div>
        <h1>JSP JavaBeans 객체 출력</h1>
       <jsp:getProperty name="simple" property="name"/>
       <jsp:getProperty name="simple" property="value"/>
   </div>

    <nav class="main__nav__next">
        👉🏻<a href="request.jsp"><b> 다음 예제로 이동</b></a>
    </nav>

</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>