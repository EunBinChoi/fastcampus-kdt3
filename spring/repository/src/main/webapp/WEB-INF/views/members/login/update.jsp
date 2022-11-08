<%@ page import="org.example.overview.utils.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SPRING</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>


<%@include file="../../messages/showMessage.jsp"%>
<%
    showMessage(request, response, "update", Status.FAIL);
%>

<script>
    function checkPassword() {
        $.ajax({
            type: "post",
            url: "/members/private/checkPwd",
            data: {"uId": $("#uId"), "uPw": $("#uPw")},
            contentType: "application/json; charset=utf8",
            dataType: "json",
            success: (data) => {
                console.log(data);
                const result = $("#uPwRes");

                result.css("font-size", "10px");
                result.css("font-weight", "bold");

                if (data == "SUCCESS") {
                    result.css("display", "block");
                    result.css("color", "black");
                    result.text("same password");
                } else if (data == "FAIL") {
                    result.css("display", "block");
                    result.css("color", "red");
                    result.text("not same password");
                } else {
                    result.css("display");
                }
            },
            error: (data) => {
                console.log("errpr", data);
            }

        });
    }

    function checkNewPassword() {
        $.ajax({
            type: "post",
            url: "/members/private/checkNewPwd",
            data: {"uId": $("#uId"), "uNewPw": $("#uNewPw")},
            contentType: "application/json; charset=utf8",
            dataType: "json",
            success: (data) => {
                console.log(data);
                const result = $("#uNewPwRes");

                result.css("font-size", "10px");
                result.css("font-weight", "bold");

                if (data == "SUCCESS") {
                    result.css("display", "block");
                    result.css("color", "black");
                    result.text("you can use.");
                } else if (data == "FAIL") {
                    result.css("display", "block");
                    result.css("color", "red");
                    result.text("you can't use.");
                } else {
                    result.css("display");
                }
            },
            error: (data) => {
                console.log("errpr", data);
            }

        });
    }
</script>

<main>
    <h1>UPDATE</h1>
    <div>Hello! ${uId}</div>


    <div>
        <form method="post" action="/members/private/rev/${uId}">

            <div class="form__list">
                <label for="uPw">CURRENT PASSWORD: </label>
                <input type="password" id="uPw" name="uPw"
                       onkeyup="checkPassword()"
                       placeholder="INPUT YOUR PASSWORD" required/>
                <p id="uPwRes"></p>
            </div>


            <div class="form__list">
                <label for="uNewPw">NEW PASSWORD: </label>
                <input type="password" id="uNewPw" name="uNewPw"
                       onkeyup="checkNewPassword()"
                       placeholder="INPUT NEW PASSWORD" required/>
<%--                       pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}" required/>--%>
                <p id="uNewPwRes"></p>
            </div>

            <input type="hidden" id="uId" name="uId" value="${uId}"/>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
