<%--
  Created by IntelliJ IDEA.
  User: gennect_3
  Date: 10/19/22
  Time: 7:24 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <h1>REQUEST</h1>
    <div>
        <form method="post" action="response.jsp">
            <div class="form__list">
                <label for="uId">INPUT YOUR ID:</label>
                <input type="text" id="uId" name="uId">
            </div>

            <div class="form__list">
                <label for="uPw">INPUT YOUR PASSWORD: </label>
                <input type="text" id="uPw" name="uPw">
            </div>

            <fieldset class="form__list">
                <legend>CHECK YOUR HOBBY</legend>
                <div>
                    <input type="checkbox" id="book" name="hobby" value="book">
                    <label for="book">reading a book 📖</label>
                </div>
                <div>
                    <input type="checkbox" id="trip" name="hobby" value="trip">
                    <label for="trip">going on a trip 🧳</label>
                </div>
                <div>
                    <input type="checkbox" id="game" name="hobby" value="game">
                    <label for="game">playing a game 🎮</label>
                </div>
                <div>
                    <input type="checkbox" id="movie" name="hobby" value="movie">
                    <label for="movie">watching a movie 🎥</label>
                </div>
                <div>
                    <input type="checkbox" id="exercise" name="hobby" value="exercise">
                    <label for="exercise">exercise 🏃</label>
                </div>
                <input type="hidden" name="hidden" value="hidden">
            </fieldset>

            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
