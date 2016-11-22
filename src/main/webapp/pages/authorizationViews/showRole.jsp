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
		<jsp:include page="/pages/common/commonHeader.jsp"></jsp:include>
		<!-- Navigation -->


		<div id="page-wrapper">
		<span>&nbsp;</span>
			
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Create New Role</h1>
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
												<label>ID</label> <input id="roleId" class="form-control" disabled>
												<p class="help-block">Role's identify number will be generated by system automatically.</p>
											</div>
										</div>
										<!-- /.col-lg-6 (nested) -->


										<div class="col-lg-6">
											<div class="form-group">
												<label>Role</label>
												<input class="form-control" id="roleName"/>
												<p class="help-block">Role name</p>
											</div>

										</div>
										
										<div class="col-lg-6">
											<div class="form-group">
												<label>Description</label>
												<input class="form-control" id="description"/>
												<p class="help-block">Role description</p>
											</div>

										</div>
												
										<div class="col-lg-6">
											<div class="form-group">
												<label>Empty</label>
												<input class="form-control" id=""/>
												<p class="help-block">Privilege description</p>
											</div>

										</div>
										<!-- /.col-lg-6 (nested) -->
										
										
										
										<div class="col-lg-5">
											<div class="form-group">
												<label>All privileges can be selected</label>
												<select id="allPrivileges" multiple="multiple" class="form-control" size="8">
											    </select>
												<p class="help-block">Privilege description</p>
											</div>
										</div>
										
										
										<div class="col-lg-2">
										<div class="col-lg-offset-5">
										</div>
										</div>
										
										<div class="col-lg-5">
											<div class="form-group">
												<label>Privileges in current role</label>
												<select id="currentPrivileges" multiple="multiple" class="form-control" size="8">

											    </select>
												<p class="help-block">Privilege description</p>
											</div>
										</div>
										
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

					</div>
				</div>
				<br>

		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->


	<script>
		$(document).ready(function() {
			
			
			function initPrivileges(){
				 $.ajax({url: "${pageContext.request.contextPath }/authorization/privilege", success: function(privileges){
						$.each(privileges, function(i, item) {
							$("#allPrivileges").append("<option value='" + item.id + "'>" + item.privilegeName + "</option>");
							
						});
						getRole("${roleId}");
				    }});
			}
			
			function getRole(id){
				 $.ajax({url: "${pageContext.request.contextPath }/authorization/role/"+id, success: function(role){
					 	var roleId = $("#roleId").val(role.id);	
					 	var roleName = $("#roleName").val(role.roleName);						
						var description = $("#description").val(role.description);
						$.each(role.privileges, function(i, item) {
					        $("#allPrivileges > option").each(function(){
					        	if($(this).val()==item.id)
					            $(this).remove().appendTo("#currentPrivileges");
					        });
							
						});
				    }});
			}
			
			
			function init(){
				initPrivileges();
			}
			
			init();
		});
	</script>



</body>

</html>
