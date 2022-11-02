<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>

<script>
    function search() {
        const searchRequest = new XMLHttpRequest();
        searchRequest.open("post", "/members/search?q=" + $("#q").val(), true);
        searchRequest.onreadystatechange = () => {
            if(searchRequest.readyState == 4 && searchRequest.status == 200) {

                // 검색된 결과를 table 출력 (ajaxTable)
                const table = $("#ajaxTable")[0]; // dom 반환
                table.innerHTML = "";

                const object = JSON.parse(searchRequest.responseText);
                for(let i = 0; i < object.length; i++) {
                    const user = [object[i].uId, object[i].uEmail];
                    const row = table.insertRow(0); // 0번째 행에 추가 (tr)
                    row.style.width = "250px";

                    for(let j = 0; j < user.length; j++) {
                        const cell = row.insertCell(j); // j번째 열 추가 (td)
                        cell.innerHTML = user[j];
                        cell.style.width = "250px";

                    }
                }
            }
        };
        searchRequest.send();
    }
</script>


<main>
    <h1>SEARCH</h1>
    <div>Hello! ${uId}</div>
    <div class="container" style="margin:20px;">
        <div class="" style="margin:20px; text-align: right;">
            <input class="" id="q" onkeyup="search();" type="text" size="20">
            <button class="" onclick="search();" type="button">Search</button>
        </div>
        <table class="table" style="width: 500px; text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th style="width: 250px; padding:5px; background-color: #fafafa; text-align: center;">UID</th>
                <th style="width: 250px; padding:5px; background-color: #fafafa; text-align: center;">EMAIL</th>
            </tr>
            </thead>
            <tbody id="ajaxTable">
            </tbody>
        </table>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
