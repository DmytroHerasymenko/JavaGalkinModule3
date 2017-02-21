
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
${requestScope.error}
<form action="./login_handler" method="post">
    login<input type="text" name="login"/>
    <br/>
    password<input type="password" name="password"/>
    <br/>
    <input type="submit" name="ok" value="send"/>
</form>

</body>
</html>
