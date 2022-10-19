<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<%
  request.setCharacterEncoding("UTF-8");

  if (request.getParameter("redirect") != null) {
    if (request.getParameter("redirect").equals("yes")) {
      %>
      <script>
        alert("REQUEST IS NOT RESOLVED.");
      </script>
    <%
    }
  }
%>

<main>
  <h1>CUSTOMER REQUEST</h1>
  <div>
    <form method="post" action="receiver1.jsp">
      <div class="form__list">
        <label for="msg">REQUEST MESSAGE: </label>
        <input type="text" id="msg" name="msg" placeholder="message ..." required/>
      </div>

      <div class="form__list">
        <label for="phone">PHONE NUMBER: </label>
        <input type="tel" id="phone" name="phone" placeholder="010-1234-5678" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required/>
      </div>
      <input type="submit" name="submit" value="Submit">
    </form>
  </div>
</main>

<footer class="main__nav__next">
  <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
