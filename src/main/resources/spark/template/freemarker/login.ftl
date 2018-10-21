<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <!--<meta http-equiv="refresh" content="10">-->
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">

    <h1>Web Checkers</h1>

    <div class="navigation">
        <a href="/">my home</a>
    </div>

    <div class="body">
        <div align="center">
            <p>Enter your User Name below!</p>
        <#if message??>
            <div class="error">${message}</div><br>
        </#if>
            <form action="/login" method="POST">
                <input type="text" name="username"><br><br>
                <input type="submit" value="Login">
            </form>
        </div>
    </div>

</div>
</body>
</html>
