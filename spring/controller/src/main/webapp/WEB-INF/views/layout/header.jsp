<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/header.css">

    <!-- font awesome apis (icon) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

    <!-- google font apis (font) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@600&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Responsive Header</title>
</head>
<body>

<script>
    function random_bg_color() {
        const x = Math.floor(Math.random() * 256);
        const y = Math.floor(Math.random() * 256);
        const z = Math.floor(Math.random() * 256);
        const a = Math.random();
        const bgColor = "rgba(" + x + "," + y + "," + z + "," + a + ")";
        console.log(bgColor);

        $('.header').css("background-color", bgColor);
    }

    $(() => {
        random_bg_color();
    });

</script>

<header class="header">
    <div class="header__logo">
        <!-- inline 구조여서 수직적 중앙이 맞지 않음 -->
        <a href="/"><i class="fas fa-camera"></i></a>
        <a href="/">Sallys</a>
    </div>


    <ul class="header__nav">
        <!-- block 구조여서 수직적 중앙이 맞음 -->
        <li><a href="/">Home</a></li>
        <li><a href="/members/search">Search</a></li>
        <li><a href="/members/survey">Survey</a></li>
    </ul>

    <ul class="header__icons">

        <%
            if (session.getAttribute("SESSION_ID") != null) { %>
        <li><a href="/members/private"><i class="fas fa-user"></i></a></li>
        <li><a href="/members/logout"><i class="fas fa-toggle-on"></i></a></li>

        <%
        } else { %>
        <li><a href="/members/signup"><i class="fas fa-user-plus"></i></a></li>
        <li><a href="/members/login"><i class="fas fa-toggle-off"></i></a></li>
        <%
            }
        %>


    </ul>


</header>
</body>
</html>