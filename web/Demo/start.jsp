<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/24
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html>
<head>
    <title>start</title>
</head>
<body>
<h1>请求发起的页面</h1>
<!-- 发起一个请求 访问Struts2框架 -->
<!-- Struts2请求 默认是以.action结尾 -->
<a href="${pageContext.request.contextPath }/hello.action" rel="external nofollow">访问Struts2入门程序</a>
</body>
</html>
