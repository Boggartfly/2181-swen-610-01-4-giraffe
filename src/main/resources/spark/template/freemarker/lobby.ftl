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
        <a href="/signout">Logout [${userName}]</a>
    </div>

    <div class="body">
        <div align="center">

            <#if rejectedMessage??>
            <div class="error">${rejectedMessage}</div><br>
            </#if>

            <p>List of online users</p>


            <form action="/lobby" method="POST">

            <#list users as user>
                <#if user != userName>
                    <<!--#if requestedUser?seq_contains(user)>-->
                        <input type="radio" name="username"
                               onclick="document.getElementById('submitRequest').removeAttribute('disabled')"
                               value=${user}>${user}><br>
                </#if>
                <!--/#if>-->
            </#list>
                <input type="submit" id="submitRequest" value="Send Request" disabled="true">
            </form>

<#if requests??>
        <br><br><br>Match Requests, play against: <br><br>
    <#list requests as request>
    <form action="/request" method="POST">
        ${request}<br>
        <input type="hidden" name="requestor" value=${request} />
        <input type="submit" name="handleRequest" value="Accept">
        <input type="submit" name="handleRequest" value="Reject"><br>
    </form>

    </#list>
</#if>
        </div>
    </div>

</div>
</body>
</html>
