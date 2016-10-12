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
			<st:form method="post" modelAttribute="user" action="create">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Create New User</h1>
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
												<label>User Name</label>
												<st:input class="form-control" path="userName" />
												<p class="help-block">User's name .</p>
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
							<div class="panel-heading">Post information</div>
							<div>
								<div class="panel-body">
									<div class="row">
										<fieldset id="info2modify">
											<div class="col-lg-6">



												<div class="form-group">
													<label for="Select">Site</label>
													<st:select id="disabledSelect" class="form-control" path="site">
														<option>Site1</option>
														<option>Site2</option>
														<option>Site3</option>
													</st:select>
												</div>

												<div class="form-group">
													<label for="select">agency</label>
													<st:select id="disabledSelect" class="form-control" path="agency">
														<option>Agency1</option>
														<option>Agency2</option>
														<option>Agency3</option>
													</st:select>
												</div>

												<div id="managerDiv" class="form-group">
													<label>Manager</label>
													<st:input class="form-control" id="managerInput" type="text" path="managerId" />
													<div id="suggestions-container-manager"></div>
													<p class="help-block">You can either tape manager's Id or name, and then choose the manager existing in system.</p>
													<button type="button" id="modifyManager" class="btn btn-primary btn-sm pull-right">Clean</button>
												</div>


											</div>
											<!-- /.col-lg-6 (nested) -->
											<div class="col-lg-6">


												<div class="form-group">
													<label for="select">Region</label>
													<st:select id="disabledSelect" class="form-control" path="region">
														<option>Region1</option>
														<option>Region2</option>
														<option>Region3</option>
													</st:select>
												</div>

												<div class="form-group">
													<label for="select">Job</label>
													<st:select id="disabledSelect" class="form-control" path="job">
														<option>Trader</option>
														<option>Responsible</option>
														<option>Risk control officer</option>
														<option>Back office</option>
													</st:select>
												</div>

												<div id="partnerDiv" class="form-group">
													<label>Partner</label>
													<st:input class="form-control" id="partnerInput" type="text" path="partnerId" />
													<div id="suggestions-container-partner"></div>
													<p class="help-block">You can either tape partner's Id or name, and then choose the partner existing in system.</p>
													<button type="button" id="modifyPartner" class="btn btn-primary btn-sm pull-right">Clean</button>
												</div>

											</div>
											<!-- /.col-lg-6 (nested) -->
										</fieldset>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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

						<button type="submit" class="btn btn-primary btn-lg">Submit Button</button>

					</div>
				</div>
				<br>
			</st:form>

		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->



	<script src="${pageContext.request.contextPath }/scriptLibrary/autocomplete/jquery.autocomplete.js"></script>
	<script src="${pageContext.request.contextPath }/scriptLibrary/autocomplete/countries.js"></script>
	



	<script>
		$(document).ready(function() {
			
			var users = null;
	        $.ajax({url: "${pageContext.request.contextPath }/user/getUsersKeyValue", async: false, success: function(result){
				users = result;
				
	        }});
	        
			var usersArray = new Array();
        	$.each(users, function( index, value ){
        		usersArray.push({data: index, value: value.keyy+" -- "+value.value});
        	});
			
			// Initialize autocomplete with custom appendTo:
			$('#managerInput').autocomplete({
				lookup : usersArray,
				appendTo : '#suggestions-container-manager',
				showNoSuggestionNotice : true,
				onSelect : function(suggestion) {
					$('#managerDiv').removeClass();
					$('#managerDiv').addClass('form-group has-success has-feedback');
					$('<span id="manager-glyphicon-ok" class="glyphicon glyphicon-ok form-control-feedback"></span>').insertAfter('#managerInput');
//					$('#managerInput').prop("disabled", true);
				}
			});

			$('#partnerInput').autocomplete({
				lookup : usersArray,
				appendTo : '#suggestions-container-partner',
				showNoSuggestionNotice : true,
				onSelect : function(suggestion) {
					$('#partnerDiv').removeClass();
					$('#partnerDiv').addClass('form-group has-success has-feedback');
					$('<span id="partner-glyphicon-ok" class="glyphicon glyphicon-ok form-control-feedback"></span>').insertAfter('#partnerInput');
//					$('#partnerInput').prop("disabled", true);
				}
			});

			$('#modifyManager').click(function() {
				$('#managerInput').prop("disabled", false);
				$('#managerInput').val('');
				$('#managerDiv').removeClass();
				$('#managerDiv').addClass('form-group');
				$('#manager-glyphicon-ok').remove();
			});

			$('#modifyPartner').click(function() {
				$('#partnerInput').prop("disabled", false);
				$('#partnerInput').val('');
				$('#partnerDiv').removeClass();
				$('#partnerDiv').addClass('form-group');
				$('#partner-glyphicon-ok').remove();
			});

		});
	</script>



</body>

</html>
