<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- SQL 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>

<sql:setDataSource
        url="jdbc:h2:~/sqlTag"
        driver="org.h2.Driver"
        user="sa"
        password=""
        var="db"
        scope="application"
/>
<%--  연결할 DB 서버의 url, driver, user, password 정보를 application 저장소에 db 변수명으로 저장 --%>

<%--  연결 정보는 application 저장소에 db 변수명으로 저장
가장 범위가 큰 application (웹 어플리케이션이 실행되는 동안 유지)에 저장했기 때문에
다른 jsp 파일에서는 db 연결 설정 없어도 사용 가능 --%>

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
    <!-- 태그 안에 있는 쿼리문 실행하고 결과 lists 변수에 저장 -->
    <sql:query var="lists" dataSource="${db}">
        select * from member
    </sql:query>

    <!-- lists 행 개수만큼 반복하면서 레코드 정보 출력 -->
    <div>
        <c:forEach var="member" items="${lists.rows}">
            <p>${member}</p>
        </c:forEach>
    </div>

    <ul class="main__nav__next">
        <li>👉🏻<a href="sqlTagsUpdate.jsp"><b>SqlTagsUpdate.jsp 예제로 이동</b></a></li>
    </ul>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
