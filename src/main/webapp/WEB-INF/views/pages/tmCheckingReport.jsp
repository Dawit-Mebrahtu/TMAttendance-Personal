<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TM Checking Report</title>
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
              <h4 class="mb-0">TM Checking Attendance Report</h4>
            </div>
            <div class="card-body">
            	
                <div class="form-group">
                <label for="total">Total Number of TM Checking Done:</label>
                <label name="total"> ${checkRecord.numberOfChecks} </label>
                </div>
                
               <hr>
             
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