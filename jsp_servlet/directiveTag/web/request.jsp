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

<main>
  <h1>JSP</h1>
  <div>
    <form method="post" action="response.jsp">
      <div class="form__list">
        <label for="name">input your name:</label>
        <input type="text" id="name" name="name">
      </div>

      <div class="form__list">
        <label for="age">input your age: </label>
        <input type="text" id="age" name="age">
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
