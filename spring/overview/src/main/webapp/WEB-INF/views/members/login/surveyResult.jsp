<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>


<main>
    <h1>SURVEY RESULT</h1>
    <div>Hello! ${uId}</div>
    <div>
        <p>Selected Season: ${survey.season}</p>
        <p>Selected Fruit: ${survey.fruit}</p>
    </div>

    <div></div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
