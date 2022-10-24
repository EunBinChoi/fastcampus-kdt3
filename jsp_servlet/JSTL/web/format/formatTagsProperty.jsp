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

    <%-- 파일명.properties 이런 형식으로 프로퍼티 파일을 키=값 형태로 출력
    {0}와 같이 동적인 값이 필요할 때 0번째 위치 변수 선언하는 방식 --%>

    <%-- 프로퍼티 파일 지정 --%>
    <fmt:setBundle var="msg" basename="properties.msg"/>
    <fmt:message bundle="${msg}" key="uId"/>&nbsp;
    <fmt:message bundle="${msg}" key="uPw"/>&nbsp;
    <fmt:message bundle="${msg}" key="intro"/>&nbsp;

    <p>${uId}</p>
    <p>${uPw}</p>


    <%-- 지정된 프로퍼티 파일의 msg 값에 요청받은 값을 {0} 위치에 채움 --%>
    <fmt:message bundle="${msg}" key="msg">
        <fmt:param value="${param.msg}"/>
    </fmt:message>
    <br/><br/>
    <a href="./formatTagsProperty.jsp">param 없는 요청</a><br/>
    <a href="./formatTagsProperty.jsp?msg=param">param 있는 요청</a><br/>

</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
