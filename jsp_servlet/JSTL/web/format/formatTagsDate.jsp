<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- Formatting 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>

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
    <h1>FORMAT TAGS</h1>

    <%-- ko 국가코드, kr 언어코드 (국제 표준화 기구 (iso에서 정함)) --%>
<%--    <fmt:setLocale value="ko_kr"/>--%>
    <fmt:setLocale value="en_us"/>
    <fmt:requestEncoding value="UTF-8"/>

    <%-- 시간 및 날짜 정보를 가지고 있는 Date 객체 선언 --%>
    <c:set var="dayTime" value="<%=new Date()%>"/>
    <div><c:out value="${dayTime}"></c:out></div>

    <%-- 날짜 정보를 full 스타일로 출력 --%>
    <div><fmt:formatDate value="${dayTime}" type="date" dateStyle="full"/></div>

    <%-- 시간 정보를 기본 스타일로 출력 --%>
    <div><fmt:formatDate value="${dayTime}" type="time"/></div>

    <%-- 타임존 설정 --%>
    <div>
        <fmt:timeZone value="Europe/London">
            <%-- 지정된 타임존의 지역 현재 시간 날짜 출력 --%>
            Europe/London : <fmt:formatDate value="${dayTime}" type="both" dateStyle="full" timeStyle="full"/>
        </fmt:timeZone>
    </div>


    <fmt:setTimeZone value="America/New_York"/>
    <div>America/New_York : <fmt:formatDate value="${dayTime}" type="both" dateStyle="full" timeStyle="full"/></div>


    <ul class="main__nav__next">
        <li>👉🏻<a href="formatTagsNumber.jsp"><b>FormatTagsNumber.jsp 예제로 이동</b></a></li>
    </ul>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
