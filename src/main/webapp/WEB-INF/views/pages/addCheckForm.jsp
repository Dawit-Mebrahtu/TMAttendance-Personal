<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TM Checking</title>
</head>
<body>
	
		<div class="card-header">
           <h3 class="mb-0">Add TM Checking Attendance</h3>
        </div>
        
		<form:form modelAttribute="check"  method="post">
		
			<p>
			<form:input type="text" path="studentId.studentId"
					class="form-control mb-4 col-4" placeholder="Student Id" />
			</p>
			
			<p>
			<form:input type="text" path="numberOfChecks"
					class="form-control mb-4 col-4" placeholder="Number of Checks" />
			</p>
			
			<button type="submit" class="btn btn-info col-2">Save</button>
						
		</form:form>


</body>
</html>