<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
</head>
<body>
<h2>Hello World!</h2>
<%--<a href="${pageContext.request.contextPath}/product/findAll.do">查询产品信息</a>--%>
<jsp:forward page="/pages/main.jsp"></jsp:forward>
</body>
</html>
