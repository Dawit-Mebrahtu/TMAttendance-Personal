<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Retreat</title>
</head>
<body>
	
		<div class="card-header">
           <h3 class="mb-0">Add Retreat Attendance</h3>
        </div>
            
		<form action="/admin/retreat"  method="post">
		
			<!-- Add hidden form field to handle update -->
			<!-- <input type="hidden" th:field="*{id}" /> -->
			<p>
			<input type="text" name="studentid"
					class="form-control mb-4 col-4" placeholder="Student Id" />
			</p>
			
			<p>
			<input type="text" name="numberOfRetreats"
					class="form-control mb-4 col-4" placeholder="Number of retreats" />
			</p>
			
			<button type="submit" class="btn btn-info col-2">Save</button>
						
		</form>


</body>
</html>