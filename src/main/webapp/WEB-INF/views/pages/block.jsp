<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="../../js/ajax.js"></script>
</head>
<body>



	<div class="container">
		<h2>TM Attendance per Block Report</h2>
		<h3>Course: <c:out value="${courseName}" /></h3>
		<h3>Block: <c:out value="${blockDescription}" /></h3>

		<a href="/faculty/report/block"><input type="button"
			value="return to previous" /></a>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Percentage</th>
					<th>Credit Score</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentReports}" var="studentReport">
					<tr class="active">
						<td><c:out value="${studentReport.id}" /></td>
						<td><c:out value="${studentReport.firstName}" /></td>
						<td><c:out value="${studentReport.lastName}" /></td>
						<td><c:out value="${studentReport.percentage}" /></td>
						<td><c:out value="${studentReport.creditScore}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>