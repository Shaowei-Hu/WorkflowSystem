<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>Workflow</title>
<jsp:include page="/pages/common/importCss.jsp"></jsp:include>
</head>
<body>
<div id="wrapper">
<jsp:include page="/pages/adminViews/adminHeader.jsp"></jsp:include>

<div id="page-wrapper">
	<div class="container">
	
	<br> <br>
	
					<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Workflow</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
		<button id="plus" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-plus"></span>
		</button>

		<button id="minus" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-minus"></span>
		</button>

		<br> <br>
		<table class="table table-hover" id="dataTables-example">
			<thead>
				<tr>
					<th></th>
					<th>Step Id</th>
					<th>Step Name</th>
					<th>Service</th>
					<th>Phase</th>
					<th>Decision</th>
					<th>Next Step Id</th>
					<th>Condition</th>
					
					<th>Authority</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
			<tfoot>
				<tr>
					<th></th>
					<th>Step Id</th>
					<th>Step Name</th>
					<th>Service</th>
					<th>Phase</th>
					<th>Decision</th>
					<th>Next Step Id</th>
					<th>Condition</th>
					
					<th>Authority</th>
				</tr>
			</tfoot>
		</table>

	</div>
</div>
</div>

</body>

	<script src="/Workflow/scriptLibrary/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<script>
		

		var stepIdFlag = "";
		
        $.ajax({url: "/Workflow/workflow/getWorkflow", success: function(steps){
			$.each(steps, function(i, items) {
				//		alert(steps[i].stepId);
				if (stepIdFlag != steps[i].step_id) {
					$("tbody").append(
							"<tr class='step" + steps[i].step_id
									+ " rowClickable' onclick='myToggle(" + steps[i].step_id
									+ ")'><td><span class='caret'></span></td><td>"
									+ steps[i].step_id + "</td><td>"
									+ steps[i].step_name + "</td><td>"
									+ steps[i].service
									+ "</td><td>"+steps[i].phase+"</td><td></td><td></td><td></td><td></td></tr>");
					$("tbody").append(
							"<tr class='decision" + parseInt(steps[i].step_id)
									+ "'><td></td><td></td><td></td><td></td><td></td><td>"
									+ steps[i].decision + "</td><td>"
									+ steps[i].next_step_id + "</td><td>"
									+ steps[i].condition + "</td><td>"
									+ steps[i].autority + "</td></tr>");
				} else {
					$("tbody").append(
							"<tr class='decision" + parseInt(steps[i].step_id)
							+ "'><td></td><td></td><td></td><td></td><td></td><td>"
							+ steps[i].decision + "</td><td>"
							+ steps[i].next_step_id + "</td><td>"
							+ steps[i].condition + "</td><td>"
							+ steps[i].autority + "</td></tr>");
				}
				stepIdFlag = steps[i].step_id;
				//		$("tbody").append("<tr><td>"+steps[i].stepId+"</td><td>"+steps[i].stepName+"</td><td>"+steps[i].phase+"</td><td>"+steps[i].decision+"</td><td>"+steps[i].condition+"</td><td>"+steps[i].intervenor+"</td></tr>");
			});
		
        }});

		$("tr[class*=step]").css("background-color", "rgb(116, 116, 116)");
		
		$("#plus").click(function(){
			$("tr[class*=decision]").show();
		});
		
		$("#minus").click(function(){
			$("tr[class*=decision]").hide();
		});

		function myToggle(step_id) {
			$(".decision" + step_id).toggle();

		}
	</script>
</html>