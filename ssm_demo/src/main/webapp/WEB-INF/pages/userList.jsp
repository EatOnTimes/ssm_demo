<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>展示用户数据列表</h1>
    <table border="1">
        <tr>
            <th>用户id</th>
            <th>用户名称</th>
            <th>用户密码</th>
            <th>用户生日</th>
        </tr>

        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:forEach>
    </table>
    当前页：${pageInfo.pageNum}
    每页显示条数：${pageInfo.pageSize}
    总条数：${pageInfo.total}
    总页数：${pageInfo.pages}
    上一页：${pageInfo.prePage}
    下一页：${pageInfo.nextPage}
    是否是第一页：${pageInfo.isFirstPage}
    是否是最后一页：${pageInfo.isLastPage}

    <table border="1">
    <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>用户密码</th>
        <th>用户生日</th>
    </tr>
    <tr>
        <td>${userBy.id}</td>
        <td>${userBy.username}</td>
        <td>${userBy.password}</td>
        <td>${userBy.birthday}</td>
    </tr>
    </table>
</body>
</html>
