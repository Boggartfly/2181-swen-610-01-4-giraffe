<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<div class="page">

    <h1>Web Checkers Login Page</h1>

    <div class="body">
        <div align="center">
            <p>Enter your User Name below!</p>
            <#if message??>
            <div class="error">${message}</div><br>
            <script data-main="js/game/index" src="js/require.js"></script>
            </#if>
            <form action="/login" method="POST">
                <input type="text" name="userName" pattern="[a-zA-Z0-9-]+"
                       title="Username can only contain letters and numbers" required><br><br>
                <input type="submit" value="login">
            </form>
        </div>
    </div>

</div>
</body>
</html>
