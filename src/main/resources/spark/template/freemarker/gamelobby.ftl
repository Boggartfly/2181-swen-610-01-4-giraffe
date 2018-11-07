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
        <a href="/signout">Logout [${currentUser}]</a>
    </div>

    <div class="body">
        <div align="center">
            <#if rejectedMessage??>
                <div class="error">${rejectedMessage}</div><br>
            </#if>
            <#if errorMessage ??>
                <div class="error">${errorMessage}</div><br>
            </#if>

            <p>List of online users</p>
            <form id="requstForm" action="/requestMatch" method="POST">


            <#list users as user>
                <#if user != currentUser>
                    <!--#if requestedUser?seq_contains(user)>-->
                        <input type="radio" name="opponent"
                               onclick="document.getElementById('submitRequest').removeAttribute('disabled')"
                               value=${user}> ${user}<br>

                </#if>
                <!--/#if>-->
            </#list>
                <input type="submit" id="submitRequest" value="Send Request" disabled="true">
            </form>


        <#if requests??>
            <#list requests as requested, requestors>
                <#if requested == currentUser>
                    <#list requestors as requestor>
     <br><br><br>Match Requests, play against: <br><br>
                    <p>
                        ${requestor}
                    </p><br>
<form action="/startGame" method="POST">
    <input type="hidden" name="requestor" value=${requestor}>
    <input type="submit" name="handleRequest" value="Accept">
</form>
    <form action="/rejectMatch" method="POST">
        <input type="hidden" name="requestor" value=${requestor}>
        <input type="submit" name="handleRequest" value="Reject"><br>
    </form>


                    </#list>
                </#if>
            </#list>
        </#if>

        </div>
    </div>

</div>
</body>
</html>
