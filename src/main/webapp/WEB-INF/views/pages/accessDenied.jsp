<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied</title>
</head>
<body>

<h3>${msg}</h3>
<!-- <img src="../../../images/accessdenied.png" > -->
<img src="<c:url value="/WEB-INF/images/accessdenied.png" />" alt="Access Denied Image"  />

</body>
</html>