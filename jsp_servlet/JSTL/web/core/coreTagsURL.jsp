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

    <div class>
        <c:url var="google" value="https://www.google.co.kr/">
            <c:param name="q" value="JSP"/>
        </c:url>
        <a href="${google}">구글에서 JSP 검색</a>
    </div>

    <ul class="main__nav__next">
        <li>👉🏻<a href="coreTagsImport.jsp"><b>Import 예제로 이동</b></a></li>
    </ul>

</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
