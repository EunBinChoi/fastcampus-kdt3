<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*" %>
<%-- 지시자 (jsp 페이지가 실행될 떄 필요한 정보를 jsp 컨테이너 (catalina)에게 알리는 역할) --%>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header><jsp:include page="../layout/header.jsp"/></header>

<%@ include file="../login/loginFilter.jsp"%>
<main>
    <h1>File</h1>

    <ul class="main__nav__next">
        <li>👉🏻<a href="fileSelect.jsp"><b> File Upload 예제로 이동</b></a></li>
        <li>👉🏻<a href="multiFileSelect.jsp"><b> Multiple File Upload 예제로 이동</b></a></li>
    </ul>


</main>

<footer>
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>