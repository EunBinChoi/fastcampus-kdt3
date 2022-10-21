<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%-- exception 객체가 살고 있음 --%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Request</title>
  <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header><jsp:include page="header.jsp"/></header>

<main>
  <h1>ERROR PAGE</h1>
  <div><%=exception.getMessage()%></div> <%-- 이런 부분은 보통 javascript로 입력 포맷이나 범위를 잡아줌 --%>
</main>

<footer class="main__nav__next"><jsp:include page="footer.jsp"/></footer>
</body>
</html>
