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

<%@include file="../../messages/showMessage.jsp" %>
<%
    showMessage(request, response, "signup", Status.FAIL);
%>

<script>

    function duplicateId() {
        const checkIdRequest = new XMLHttpRequest();
        const url = "/members/signup/checkId?uId=" + $("#uId").val();
        const method = "post";

        checkIdRequest.open(method, url, true);
        checkIdRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf8");
        checkIdRequest.onreadystatechange = () => {
            if (checkIdRequest.readyState == 4 && checkIdRequest.status == 200) {
                console.log(checkIdRequest.responseText);
                const result = $("#res");
                const responseText = JSON.parse(checkIdRequest.responseText);

                result.css("font-size", "10px");
                result.css("font-weight", "bold");

                if (responseText == "SUCCESS") {
                    result.css("display", "block");
                    result.css("color", "black");
                    result.text("you can use.");
                } else if (responseText == "FAIL") {
                    result.css("display", "block");
                    result.css("color", "red");
                    result.text("you can't use.");
                } else {
                    result.css("display", "none");
                }
            }
        }
        checkIdRequest.send();
    }

    function duplicateIdWithJQuery() {
        $.ajax({
            type: "post",
            url: "/members/signup/duplicate?uId=" + $("#uId").val(),
            contentType: "application/x-www-form-urlencoded; charset=utf8",
            dataType: "json",
            success: (data) => {
                console.log(data);
                const result = $("#res");

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
    <h1>SIGN UP</h1>
    <div>
        <form method="post" action="/members/signup">

            <div class="form__list">
                <label for="uEmail">EMAIL: </label>
                <input type="email" id="uEmail" name="uEmail" placeholder="INPUT YOUR EMAIL"
                       pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required/>
            </div>


            <div class="form__list">
                <label for="uId">ID: </label>
                <input type="text" id="uId" name="uId" onkeyup="duplicateIdWithJQuery()" placeholder="INPUT YOUR ID"
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
