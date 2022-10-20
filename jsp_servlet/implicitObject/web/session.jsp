<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

  String uId = null;
  if (request.getParameter("uId") != null) {
    uId = request.getParameter("uId");
  }

  String uPw = null;
  if (request.getParameter("uPw") != null) {
    uPw = request.getParameter("uPw");
  }

  session.setAttribute("uId", uId);
  session.setMaxInactiveInterval(5); // 5분
  // session 객체 연결 시간 지정 (5분, 기본 30분)
  // 5분 경과 후에 연결 종료
%>

<main>
  <h1>SURVEY</h1>
  <div>Hello! "<%=uId%>"</div>
  <div></div>
  <div>Please complete the survey below 👇🏻</div>
  <div>
    <form method="post" action="surveyResult.jsp">
      <fieldset>
        <legend>1. Favorite Season ?</legend>

        <div>
          <input type="radio" name="season" value="spring" checked>
          <label>spring 🍀</label>
        </div>

        <div>
          <input type="radio" name="season" value="summer">
          <label>summer 🌊</label>
        </div>

        <div>
          <input type="radio" name="season" value="autumn">
          <label>autumn 🍂</label>
        </div>

        <div>
          <input type="radio" name="season" value="winter">
          <label>winter ❄️</label>
        </div>
      </fieldset>

      <fieldset>
        <legend>2. Favorite Fruit ?</legend>

        <div>
          <input type="radio" name="fruit" value="watermelon" checked>
          <label>watermelon 🍉</label>
        </div>

        <div>
          <input type="radio" name="fruit" value="melon">
          <label>melon 🍈</label>
        </div>

        <div>
          <input type="radio" name="fruit" value="apple">
          <label>apple 🍎</label>
        </div>

        <div>
          <input type="radio" name="fruit" value="orange">
          <label>orange 🍊</label>
        </div>
      </fieldset>
      <div>
        <input type="submit" value="result">
      </div>
    </form>
  </div>
</main>

<footer class="main__nav__next">
  <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
