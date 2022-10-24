<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div>
        <h1>JSTL</h1>
    </div>
    <ul class="main__nav__next">
        <li>👉🏻<a href="core/coreTags.jsp"><b> Core Tags 예제로 이동</b></a></li>
        <li>👉🏻<a href="format/formatTags.jsp"><b> Format Tags 예제로 이동</b></a></li>
        <li>👉🏻<a href="functions/functionsTags.jsp"><b> Function Tags 예제로 이동</b></a></li>
        <li>👉🏻<a href="sql/sqlTags.jsp"><b> SQL Tags 예제로 이동</b></a></li>
    </ul>
</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>