<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- SQL 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>


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
    <h1>SQL TAG</h1>
    <div>
        <h3>UPDATE</h3>
        <!-- sqlTag.jsp에서 연결한 db 정보 재활용 (application 저장소) -->
        <sql:update dataSource="${db}">
            update member set name=? where id=?
            <sql:param value="${'admin'}"/>
            <sql:param value="${1}"/>
        </sql:update>
        <p>Update Success!</p>
    </div>

    <div>
        <h3>INSERT</h3>
        <!-- sqlTag.jsp에서 연결한 db 정보 재활용 (application 저장소) -->
        <sql:update dataSource="${db}">
            insert into member(name, age) values('new', 50);
        </sql:update>
        <p>Insert Success!</p>
    </div>


    <ul class="main__nav__next">
        <li>👉🏻<a href="sqlTags.jsp"><b>SqlTags.jsp 예제로 이동</b></a></li>
    </ul>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
