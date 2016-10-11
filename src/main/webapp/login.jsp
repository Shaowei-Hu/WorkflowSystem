<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Bootstrap Login Form</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="<c:url value="/scriptLibrary/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
		<!-- <link href="styleSheet/styles.css" rel="stylesheet"> -->
		
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
	</head>
	<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" data-role="dialog" data-aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" data-aria-hidden="true">×</button>
          <h1 class="text-center">Login</h1>
      </div>
      
      
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="admin/login" method="post">
            <div class="form-group">
              <input type="text" class="form-control input-lg" placeholder="Username" name="username">
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" placeholder="Password" name="password">
            </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block">Sign In</button>
              <h4><span class="pull-right"><a href="#">Register</a></span><span><a href="#">Need help?</a></span></h4>
            </div>
          </form>
      </div>
      
      
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" data-aria-hidden="true">Cancel</button>
		  </div>	
      </div>
  </div>
  </div>
</div>
	<!-- script references -->
<!-- 		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="/js/bootstrap.min.js"></script> -->
			<!-- jQuery -->
 	<script src="/Workflow/scriptLibrary/jquery/jquery-1.11.1.js"></script>
 
	<!-- Bootstrap Core JavaScript -->
	<script src="/Workflow/scriptLibrary/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>