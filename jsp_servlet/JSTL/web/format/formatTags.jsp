<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <fmt:setLocale value="ko_kr"/>
    <fmt:requestEncoding value="UTF-8"/>

    <fieldset class="format__fieldset">
        <legend>NAME</legend>
        <div><%=request.getParameter("name")%></div>
    </fieldset>

    <fieldset class="format__fieldset">
        <legend>INPUT NAME</legend>
        <form method="post">
            <label for="name"></label>
            <input id="name" name="name">
            <input type="submit">
        </form>
    </fieldset>

    <ul class="main__nav__next">
        <li>👉🏻<a href="formatTagsNumber.jsp"><b>FormatTagsNumber.jsp 예제로 이동</b></a></li>
    </ul>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
