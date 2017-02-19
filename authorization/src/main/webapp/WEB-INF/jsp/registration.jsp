
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
</head>
<body>
${requestScope.error}

<form action="./registration_handler" method="post">
    name<input type="text" name="name"/>
    <br/>
    login<input type="text" name="login"/>
    <br/>
    password<input type="password" name="password"/>
    <br/>
    <input type="submit" name="ok" value="send"/>
</form>
</body>
</html>
