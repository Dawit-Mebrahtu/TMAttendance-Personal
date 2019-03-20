<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="../../js/ajax.js"></script>
</head>
<body>


	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Percentage</th>
					<th>Credit score</th>
					<th><input type="button"
						onclick="window.location.href = 'http://localhost:8080/Report/Block';"
						value="return to previous" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Default</td>
					<td>Defaultson</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					
				</tr>
				<tr class="success">
					<td>Success</td>
					<td>Doe</td>
					<td>john@example.com</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					
				</tr>
				<tr class="danger">
					<td>Danger</td>
					<td>Moe</td>
					<td>mary@example.com</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					
				</tr>
				<tr class="info">
					<td>Info</td>
					<td>Dooley</td>
					<td>july@example.com</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					
				</tr>
				<tr class="warning">
					<td>Warning</td>
					<td>Refs</td>
					<td>bo@example.com</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					
				</tr>
				<tr class="active">
					<td>Active</td>
					<td>Activeson</td>
					<td>act@example.com</td>
					<td>def@somemail.com</td>
					<td>def@somemail.com</td>
					
				</tr>
			</tbody>
		</table>
	</div>

	
</body>
</html>