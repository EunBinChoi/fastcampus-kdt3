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
    <h1>CORE TAGS</h1>
    <!-- if문 태그를 이용해서 요청된 uName 값이 null인치 체크 -->

    <!-- request.getParameter("uName") -->
    <c:if test="${!empty param[\"uName\"] and param[\"uName\"] != ''}">
        <div>${param.uName}</div>
    </c:if>
    <c:if test="${param.uName == ''}">
        <div>Guest</div>
    </c:if>

    <!-- request.getAttribute("uName") -->
    <c:if test="${!empty requestScope.uName and requestScope.uName != ''}">
        <div>${requestScope.uName}</div>
    </c:if>
    <c:if test="${requestScope.uName == ''}">
        <div>Guest</div>
    </c:if>

    <%
        // jsp
        if(request.getParameter("uName") != null && !(request.getParameter("uName").equals(""))) {
            out.println("<div>" + request.getParameter("uName") + "</div>");
        }
        else {
            out.println("<div>Guest</div>");
        }
    %>
    <!-- 다중선택을 체크하기 위한 choose 태그 -->
    <c:choose>
        <c:when test="${param.color=='red'}">
            <c:set var="c" value="red"/>
        </c:when>
        <c:when test="${param.color=='orange'}">
            <c:set var="c" value="orange"/>
        </c:when>
        <c:when test="${param.color=='yellow'}">
            <c:set var="c" value="yellow"/>
        </c:when>
        <c:when test="${param.color=='green'}">
            <c:set var="c" value="green"/>
        </c:when>
        <c:when test="${param.color=='blue'}">
            <c:set var="c" value="blue"/>
        </c:when>
        <c:when test="${param.color=='purple'}">
            <c:set var="c" value="purple"/>
        </c:when>
        <c:otherwise>
            <c:set var="c" value="black"/>
        </c:otherwise>
    </c:choose>

    <fieldset class="color__fieldset" style="background-color: ${param.color}">
        <legend style="background-color: lightgrey">favorite color</legend>
        <div>${c}</div>
    </fieldset>

    <ul class="main__nav__next">
        <li>👉🏻<a href="coreTagsFor.jsp"><b>For 예제로 이동</b></a></li>
    </ul>

</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
