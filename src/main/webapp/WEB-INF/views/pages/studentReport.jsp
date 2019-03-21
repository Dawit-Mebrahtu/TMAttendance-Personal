<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update TM Checking</title>
</head>
<body>

  <div class="row">
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6 mx-auto">

          <!-- form card login -->
          <div class="card rounded-0">
          
          	<div class="card-header">
             		 <h3 class="mb-0">Current Student</h3>
           	 </div>
           	 <div class="form-group">
                <label for="idno">ID No:</label>
                <label name="idno"> ${currentStudent.studentId} </label>
                </div>
                <div class="form-group">
                <label for="studname">Name:</label>
                <label name="studname"> ${currentStudent.firstName} ${currentStudent.lastName} </label>
                </div>
        	<hr>
            <div class="card-header">
              <h4 class="mb-0">Cumulative Attendance Report</h4>
            </div>
            <div class="card-body">
            	
                <div class="form-group">
                <label for="total">Total Sessions Possible:</label>
                <label name="total"> ${totalSessions} </label>
                </div>
                <div class="form-group">
                <label for="attended">Total Sessions Attended:</label>
                <label name="attended"> ${totalSessionsAttended} </label>
                </div>
                <div class="form-group">
                <label for="percentage">Attendance Percentage:</label>
                <label name="percentage"> ${percentage} %</label>
                </div>
               <hr>
               
               <div class="card-header">
             		 <h4 class="mb-0">Block Attendance Report</h4>
           	   </div>
              <form class="form" action="/student/attendance" method="post">
                <%-- <div class="form-group">
                  <span class="error">${error}</span>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg rounded-0" name="studId" placeholder="Student Id">
                </div> --%>
       
                <div class="form-group">
                <label for="blocks">Block</label>
			    <select name= "blocks">	
				  	<c:forEach var="block" items = "${blocks}">
					    <option value="${block.id}" > ${block.description}</option>   
			 	 	</c:forEach>
			    </select>
			     </div>
                <button type="submit" class="btn btn-info btn-lg float-left" id="btnSearch">Search</button>
              </form>
               <hr>
              	<div class="form-group">
                <label for="total">Sessions in Block:</label>
                <label name="total"> ${studentReports.sessions} </label>
                </div>
                <div class="form-group">
                <label for="attended">Days Attended:</label>
                <label name="attended"> ${studentReports.attended} </label>
                </div>
                <div class="form-group">
                <label for="percentage">Percentage Attended:</label>
                <label name="percentage"> ${studentReports.percentage} %</label>
                </div>
                <div class="form-group">
                <label for="percentage">Extra Credit Points:</label>
                <label name="percentage"> ${studentReports.creditScore}</label>
                </div>
            </div>
            <!--/card-block-->
          </div>
          <!-- /form card login -->

        </div>
      </div>
      <!--/row-->

    </div>
    <!--/col-->
  </div>
  <!--/row-->

</body>
</html>