<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin 2 - Bootstrap Admin Theme</title>

<jsp:include page="/pages/common/importCss.jsp"></jsp:include>

</head>

<body>

	
	<div id="wrapper">
		<jsp:include page="adminHeader.jsp"></jsp:include>
		<!-- Navigation -->


		<div id="page-wrapper">
		<span>&nbsp;</span>
			
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Create New Privilege</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Basic Information</div>
							<div class="panel-body">
								<div class="row">

									<fieldset>
										<div class="col-lg-6">
											<div class="form-group">
												<label>ID</label> <input class="form-control" disabled>
												<p class="help-block">User's identify number will be generated by system automatically.</p>
											</div>
										</div>
										<!-- /.col-lg-6 (nested) -->


										<div class="col-lg-6">
											<div class="form-group">
												<label>Privilege</label>
												<input class="form-control" id="privilegeName"/>
												<p class="help-block">Privilege name</p>
											</div>

										</div>
										
										<div class="col-lg-6">
											<div class="form-group">
												<label>Parent</label>
												<input class="form-control" id="parentPrivilege"/>
												<p class="help-block">Privilege name</p>
											</div>

										</div>
												
										<div class="col-lg-6">
											<div class="form-group">
												<label>Description</label>
												<input class="form-control" id="description"/>
												<p class="help-block">Privilege description</p>
											</div>

										</div>
										<!-- /.col-lg-6 (nested) -->
									</fieldset>

								</div>
								<!-- /.row (nested) -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Another basic Form Elements</div>
							<div>
								<p></p>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12 text-center">

						<button type="button" class="btn btn-primary btn-lg" id="addButton">Submit Button</button>

					</div>
				</div>
				<br>

		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->


	<script>
		$(document).ready(function() {
			function addPrivilege(){
				var privilegeName = $("#privilegeName").val();
				var parent = $("#privilegeParent").val();
				var description = $("#description").val();
				
				var privilege = {"privilegeName" : privilegeName, "privilegeParent": parent, "description" : description };

 				$.ajax({
	 					headers: { 
	 				        'Accept': 'application/json',
	 				        'Content-Type': 'application/json' 
	 				    },
					   url: '${pageContext.request.contextPath }/authorization/privilege',
					   type: 'POST',
					   data: JSON.stringify(privilege),
					   success: function(response) {
					   }
					});
//				$.post('${pageContext.request.contextPath }/authorization/privilege', privilege);
			};
			
			
			function init(){
				$("#addButton").click(function(){
					addPrivilege();
				});
			}
			
			init();
		});
	</script>



</body>

</html>
