<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<style type="text/css">

#decisionHidden {
	display: none;
}
</style>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin 2 - Bootstrap Admin Theme</title>

<jsp:include page="/pages/common/importCss.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="../adminViews/adminHeader.jsp"></jsp:include>
	<div id="wrapper">

		<!-- Navigation -->


		<div id="page-wrapper">
			<form role="form" action="/Workflow/workflow/updateWorkflow" method="post">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Workflow Step</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Step Information</div>
							<div class="panel-body">
								<div class="row">

									<fieldset>
										<div class="col-lg-6">
											<div class="form-group">
												<label>Step Id</label> <input class="form-control" name="step_id">
												<p class="help-block">User's name .</p>
											</div>

											<div class="form-group">
												<label>Phase</label> <input class="form-control" name="phase">
												<p class="help-block">User's name .</p>
											</div>
										</div>
										<!-- /.col-lg-6 (nested) -->


										<div class="col-lg-6">
											<div class="form-group">
												<label>Step Name</label> <input class="form-control" name="step_name">
												<p class="help-block">User's name .</p>
											</div>
											<div class="form-group">
												<label>Service</label> <input class="form-control" name="service">
												<p class="help-block">Intervoner service .</p>
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

				
								
				
					<div class="row" id="decision0">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<span>Decision</span><a href="javascript:deleteDecision(0)"><span class="glyphicon glyphicon-trash pull-right"></span></a>
								</div>
								<div>
									<div class="panel-body">
										<div class="row">
											<fieldset id="info2modify">
												<div class="col-lg-6">

													<div class="form-group">
														<label>Decision</label> <input class="form-control" name="decision" ">
														<p class="help-block">Decision</p>
													</div>

													<div class="form-group">
														<label>Condition</label> <input class="form-control" name="condition">
														<p class="help-block">User's name .</p>
													</div>




												</div>
												<!-- /.col-lg-6 (nested) -->
												<div class="col-lg-6">


													<div class="form-group">
														<label for="select">Next Step Id</label>
														<select id="" class="form-control mySelect" name="nextStep">
															<option value="--">--</option>
														</select>
														<p class="help-block">The next step which the decision will point to</p>
													</div>
													 
													<div class="form-group">
														<input type="hidden" class="form-control" name="system">		
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
				
				
				
				
				
				<div id="decisions">
					<div class="row" id="decisionHidden">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<span>Decision</span> <a href="#"><span id="deleteHidden" class="glyphicon glyphicon-trash pull-right"></span></a>
								</div>
								<div>
									<div class="panel-body">
										<div class="row">
											<fieldset id="info2modify">
												<div class="col-lg-6">

													<div class="form-group">
														<label>Decision</label> <input class="form-control" name="decision">
														<p class="help-block">Decision</p>
													</div>

													<div class="form-group">
														<label>Condition</label> <input class="form-control" name="condition">
														<p class="help-block">User's name .</p>
													</div>




												</div>
												<!-- /.col-lg-6 (nested) -->
												<div class="col-lg-6">


													<div class="form-group">
														<label for="select">Next Step</label>
														<select id="" class="form-control mySelect" name="nextStep">
															<option>--Choose next step--</option>
														</select>
														<p class="help-block">The next step which the decision will point to</p>
													</div>
													
													<div class="form-group">
														<input type="hidden" class="form-control" name="system">
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
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span>Add a decision </span><a href="#"><span id="addDecision" class="glyphicon glyphicon-plus pull-right"></span></a>
							</div>
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
			</form>
		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->

	<script src="/Workflow/scriptLibrary/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<script>
	var ajaxFlag = true;
	$(document).ready(
			function() {
				
				function initSelect(){
					$(".mySelect").click(function(event){
//						var flag = confirm("Do you really want to change the next step of this decision?");
					
							if(ajaxFlag){
								
						        $.ajax({url: "/Workflow/workflow/getWorkflow", success: function(steps){
						        	ajaxFlag = false;
									$.each(steps, function(i, items) {

										$(".mySelect").append("<option value='" + steps[i].step_id + "'>" + steps[i].step_id +" - "+ steps[i].step_name + "</option>");
									
									});
									
						        }});
							}

					});
					
					$(".mySelect").change(function(){
						alert("Next step has been changed!");
					});
				}
				
				initSelect();
				

				var decisionNum = 0;
				$("#addDecision").click(
						function() {
							var newDecision = $("#decisionHidden").clone().attr("id", "decision-" + decisionNum);
							newDecision.appendTo("#decisions");

							var newDelete = $("#decision-"+decisionNum+" .glyphicon").attr("id", "delete-" + decisionNum );

							newDelete.click(
									function() {

										var flag = confirm("Do you want to delete this decision?");
										if (flag)
											$(this).parent().parent()
													.parent().parent()
													.parent().remove();

									});
							decisionNum++;
						});

			}
	);
	
	function deleteDecision(id){
		var flag = confirm("Do you want to delete this decision?");
		if(flag) $("#decision" + id).remove();
	}
	</script>

</body>

</html>
