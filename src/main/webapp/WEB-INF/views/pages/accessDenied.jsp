<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied</title>
</head>
<body>

<h3>${msg}</h3>
<img src="<c:url value="images/accessdenied.png" />" alt="Access Denied Image"  />

<%-- <img src="<spring:url value="images/accessdenied.png"  htmlEscape="true" />" alt="Access Denied Image"  />
 --%>
 
<p><button type=button onclick=window.location.href="<spring:url value='/home' />">Home</button></p>

</body>
</html>