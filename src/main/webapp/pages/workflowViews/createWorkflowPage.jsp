<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html SYSTEM "about:legacy-compat">

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

	<jsp:include page="/pages/common/commonHeader.jsp"></jsp:include>
	<div id="wrapper">

		<!-- Navigation -->


		<div id="page-wrapper">
			<form action="${pageContext.request.contextPath }/workflow/newWorkflow" method="post">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Create New Work flow</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Work flow Version</div>
							<div class="panel-body">
								<div class="row">

									<fieldset>
										<div class="col-lg-12">
											<div class="form-group">
												<label>Version</label> <input class="form-control" name="workflowVersion">
												<p class="help-block">Work flow version or name</p>
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



	<script>
		$(document).ready(
						function() {


						});
	</script>

</body>

</html>
