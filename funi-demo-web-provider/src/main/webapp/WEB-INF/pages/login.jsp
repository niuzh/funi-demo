<%--
作为登录页面和登录失败响应页面
@author zhihuan.niu
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>demo</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/> </font>
</c:if>
  <form action="<c:url value="/loginCheck"/>" method="post">
      用户名：
      <input type="text" name="userName" value="admin">
      <br>
      密 码：
      <input type="password" name="password" value="123456">
      <br>
      <input type="submit" value="登录"/>
      <input type="reset" value="重置"/>
  </form>
</body>
</html>
