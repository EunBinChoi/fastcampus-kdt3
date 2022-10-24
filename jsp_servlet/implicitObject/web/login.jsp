<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSP</title>
  <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
  <jsp:include page="header.jsp"/>
</header>

<main>
  <h1>LOGIN</h1>
  <div>
    <form method="post" action="session.jsp">
      <div class="form__list">
        <label for="uId">ID: </label>
        <%-- key-value (name-value)   --%>
        <input type="text" id="uId" name="uId" placeholder="INPUT YOUR ID" pattern="[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}" required/>
      </div>

      <div class="form__list">
        <label for="uPw">PASSWORD: </label>
        <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD"
               pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}" required/>
<%--        At least one upper case English letter, (?=.*?[A-Z])--%>
<%--        At least one lower case English letter, (?=.*?[a-z])--%>
<%--        At least one digit, (?=.*?[0-9])--%>
<%--        At least one special character, (?=.*?[#?!@$%^&*-])--%>
<%--        Minimum eight in length .{8,} (with the anchors)--%>
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
