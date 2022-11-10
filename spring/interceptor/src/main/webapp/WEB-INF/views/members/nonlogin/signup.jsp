<%@ page import="org.example.overview.utils.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SPRING</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" onload="this.media='all'">
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>

<%@include file="../../messages/showMessage.jsp" %>
<%
    showMessage(request, response, "signup", Status.FAIL);
%>

<script>


    function duplicateId() {
        $.ajax({
            type: "post",
            url: "/signup/checkId?uId=" + $("#uId").val(),
            contentType: "application/x-www-form-urlencoded; charset=utf8",
            dataType: "json",

            beforeSend: () => {
                $("#res").css("font-size", "10px");
                $("#res").css("font-weight", "bold");
            },
            success: (data, statusText, jqXHR) => {
                $("#res").css("display", "block");
                $("#res").css("color", "black");
                $("#res").text("you can use.");
            },
            error: (jqXHR, textStatus, errorThrown) => {
                $("#res").css("display", "block");
                $("#res").css("color", "red");
                $("#res").text("you can't use.");
            }
        });
    }

</script>

<main>
    <h1>SIGN UP</h1>
    <div>
        <form method="post" action="/signup">

            <div class="form__list">
                <label for="uEmail">EMAIL: </label>
                <input type="email" id="uEmail" name="uEmail" placeholder="INPUT YOUR EMAIL"
                       pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required/>
            </div>


            <div class="form__list">
                <label for="uId">ID: </label>
                <input type="text" id="uId" name="uId" onkeyup="duplicateId()" placeholder="INPUT YOUR ID"
                       pattern="^[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}$" required/>
                <p id="res"></p>
            </div>


            <div class="form__list">
                <label for="uPw">PASSWORD: </label>
                <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD"
                       pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" required/>
            </div>

            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
