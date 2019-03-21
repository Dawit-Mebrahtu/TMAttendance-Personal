<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TM Attendance</title>
</head>
<body>

  <div class="row">
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6 mx-auto">

          <!-- form card login -->
          <div class="card rounded-0">
            <div class="card-header">
              <h3 class="mb-0">Update TM Checking Attendance</h3>
            </div>
            <div class="card-body">
              <form class="form" action="/admin/check/search" method="post">
                <div class="form-group">
                  <span class="error">${error}</span>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg rounded-0" name="studId" placeholder="Student Id">
                </div>
                <button type="submit" class="btn btn-info btn-lg float-left" id="btnSearch">Search</button>
              </form>
            </div>
            <p>
         <c:if test = "${found}">
            <div class="card-body">
              <form:form class="form" modelAttribute="updateCheck" method="post" action="/admin/check/update">
              	<!-- Add hidden form field to handle update -->
              	<form:input type="hidden" path="id" />
                <div class="form-group">
                  <form:input type="text" class="form-control form-control-lg rounded-0" path="studentId.studentId" placeholder="Student Id" readonly="true" />
                </div>
                <div class="form-group">
                  <form:input type="text" class="form-control form-control-lg rounded-0" path="numberOfChecks" placeholder="Number of Checks" />
                </div>
                <button type="submit" class="btn btn-info btn-lg float-left" id="btnUpdate">Update</button>
              </form:form>
            </div>
            </p>
       </c:if>
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