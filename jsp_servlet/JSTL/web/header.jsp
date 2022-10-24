<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/header.css">

    <!-- font awesome apis (icon) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

    <!-- google font apis (font) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@600&display=swap" rel="stylesheet">
    <title>Responsive Header</title>

    <!-- favicon (브라우저 이름 옆에 아이콘)
        https://www.flaticon.com/kr/
        https://www.favicon-generator.org/
    -->
    <link rel="shortcut icon" href="../icon/favicon.ico" type="image/x-icon">
    <link rel="icon" href="../icon/favicon-16x16.png" sizes="16x16">
    <link rel="icon" href="../icon/favicon-32x32.png" sizes="32x32">
    <link rel="icon" href="../icon/favicon-96x96.png" sizes="96x96">


</head>
<body>
<header class="header">
    <div class="header__logo">
        <!-- inline 구조여서 수직적 중앙이 맞지 않음 -->
        <a href="/index.jsp"><i class="fas fa-camera"></i></a>
        <a href="/index.jsp">Sallys</a>
    </div>


    <ul class="header__nav">
        <!-- block 구조여서 수직적 중앙이 맞음 -->
        <li><a href="#">Home</a></li>
        <li><a href="#">Board</a></li>
        <li><a href="#">Survey</a></li>
    </ul>

    <ul class="header__icons">
        <li><i class="fab fa-twitter"></i></li>
        <li><i class="fab fa-facebook"></i></li>
    </ul>


</header>
</body>
</html>