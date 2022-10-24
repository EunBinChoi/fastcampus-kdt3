<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Core 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>

<main>
    <%
        String[] str1 = {"sally", "philip", "tina", "paul"};
        String str2 = "JAVA, JSP; Spring, Python";
    %>
    <h1>CORE TAGS</h1>
    <div>
        <c:set var="arr" value="<%=str1%>"/>
        <c:forEach var="element" items="${arr}" begin="0" step="1" end="<%=str1.length%>">
            <p>${element}</p>
        </c:forEach>
    </div>

    <div>
        <c:set var="s" value="<%=str2%>"/>
        <c:forTokens var="st" items="${s}" delims=", ;">
            <p>${st}</p>
        </c:forTokens>
    </div>

    <ul class="main__nav__next">
        <li>👉🏻<a href="coreTagsURL.jsp"><b>URL 예제로 이동</b></a></li>
    </ul>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
