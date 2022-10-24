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
    <!-- include 액션태그와 같이 결과 포함 -->
    <div>
        <c:import url="coreTagsIfOnlyMain.jsp">
            <c:param name="uName" value="admin"/>
            <c:param name="color" value="black"/>
        </c:import>
    </div>

    <script>
        const answer = confirm("Do you want to move to \"Redirect Example\" ?");
        if (answer) {
            location.href = "coreTagsRedirect.jsp";
        }
    </script>

</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
