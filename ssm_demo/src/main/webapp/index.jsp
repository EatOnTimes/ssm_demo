<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
</body>
<form action="${pageContext.request.contextPath}/user/save" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="date" name="birthday"><br>
    <input type="submit" value="注册">
</form>
</html>
