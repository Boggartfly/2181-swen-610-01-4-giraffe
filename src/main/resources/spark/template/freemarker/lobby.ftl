<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">

    <h1>Web Checkers</h1>

    <div class="navigation">
        <a href="/">my home</a>
        <a href="/signout">Logout [${userName}]</a>
    </div>

    <div class="body">
        <div align="center">
            <p>List of online users</p>


        <form action="/lobby" method="POST">

            <#list users as user>
            <#if user != userName>
                    <input type="radio" name="username" value=${user}>${user}<br>
            </#if>
            </#list>
            <input type="submit" value="Send Request">
        </form>

        </div>
    </div>

</div>
</body>
</html>
