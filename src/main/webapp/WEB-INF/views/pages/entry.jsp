<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container">
		<h2>TM Attendance Report per Entry</h2>
		<h3>Entry: <c:out value="${description}" /></h3>
		

		<a href="/faculty/entry"><input type="button"
			value="return to previous" /></a>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>					
					<th>PossibleSession</th>
					<th>Total Session Attended</th>
					<th>Percentage</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studententrylist}" var="studentEntry">
					<tr class="active">
						<td><c:out value="${studentEntry.id}" /></td>
						<td><c:out value="${studentEntry.firstname}" /></td>
						<td><c:out value="${studentEntry.lastname}" /></td>
						<td><c:out value="${studentEntry.possibleSession}" /></td>
						<td><c:out value="${studentEntry.totalSessionAttended}" /></td>
						<td><c:out value="${studentEntry.percentage}" />%</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>