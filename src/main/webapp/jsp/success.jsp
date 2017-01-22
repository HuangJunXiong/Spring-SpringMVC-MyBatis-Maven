<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
${successMsg } Welcome!  <shiro:principal/>
	<br><br>
	
	<shiro:hasAnyRoles name="user">
		<a href="/jsp/user.jsp">User Page</a>
	</shiro:hasAnyRoles>
	
	<br><br>
	
	<shiro:hasAnyRoles name="admin">
		<a href="/jsp/admin.jsp">Admin Page</a>
	</shiro:hasAnyRoles>
	
	<br><br>
	<a href="../test/logout.do">Logout</a>
</body>
</html>