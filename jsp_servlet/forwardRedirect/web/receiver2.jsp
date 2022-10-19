<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, phone.Phone" %>
<%
  request.setCharacterEncoding("UTF-8");

  String msg = "";
  if (request.getParameter("msg") != null) {
    msg = request.getParameter("msg");
  }

  String phoneStr = "";
  Phone phone = null;
  if (request.getParameter("phoneStr") != null) {
    phoneStr = request.getParameter("phoneStr");

    String[] strings = phoneStr.split("-");
    phone = new Phone(strings[0], strings[0], strings[0]);
  }

  String isForward = "";
  if (request.getParameter("isForward") != null) {
    isForward = request.getParameter("isForward");
  }
%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Request</title>
  <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
  <jsp:include page="header.jsp"/>
</header>

<main>
  <h1>RECEIVER 2</h1>
  <div>
    <p>REQUEST MESSAGE: <%=msg%></p>
    <p>RECEIVER PHONE NUMBER: <%=phoneStr%></p>
    <p>RECEIVER PHONE NUMBER: <%=phone%></p>
    <p>FORWARD ? <%=isForward%></p>
  </div>

  <div></div>
  <div>REQUEST IS SUCCESSFULLY RESOLVED.</div>

</main>

<footer class="main__nav__next">
  <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
