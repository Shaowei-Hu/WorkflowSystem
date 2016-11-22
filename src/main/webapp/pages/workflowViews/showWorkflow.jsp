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
<jsp:include page="/pages/common/commonHeader.jsp"></jsp:include>

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
						<div class="form-group">
									<label for="select">Workflow Version:</label>
									<select id="versionSelect" class="form-control mySelect" name="nextStep">
												<option value="--">--</option>
									</select>
						</div>
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
					<th>Authority</th>
					<th>Decision</th>
					<th>Next Step Id</th>
					<th>Condition</th>
					
					
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
					<th>Authority</th>
					<th>Decision</th>
					<th>Next Step Id</th>
					<th>Condition</th>
					
					
				</tr>
			</tfoot>
		</table>

	</div>
</div>
</div>

</body>


<script>
		
    $.ajax({url: "${pageContext.request.contextPath }/workflow/workflowVersion", success: function(versions){
		$.each(versions, function(i, items) {
			//		alert(steps[i].stepId);
			$("#versionSelect").append("<option value='" + versions[i] + "'>" + versions[i] + "</option>");
			
		});
	
    }});
    
    $("#versionSelect").change(selectChange);

		var stepIdFlag = "";
		
		function selectChange(){
			$("tbody").empty();
			var version = $('#versionSelect').find(":selected").text();
			if("--"!=version)
				getWorkflowByVersion(version);
		}
		
		function getWorkflowByVersion(version){
	        $.ajax({url: "${pageContext.request.contextPath }/workflow/workflow/"+version, success: function(stepAdvanceds){
				$.each(stepAdvanceds, function(i, items) {
					//		alert(steps[i].stepId);
					
						$("tbody").append(
								"<tr class='step" + stepAdvanceds[i].stepId
										+ " rowClickable' onclick='myToggle(" + stepAdvanceds[i].stepId
										+ ")'><td><span class='caret'></span></td><td>"
										+ stepAdvanceds[i].stepId + "</td><td>"
										+ stepAdvanceds[i].stepName + "</td><td>"
										+ stepAdvanceds[i].service+ "</td><td>"
										+ stepAdvanceds[i].phase + "</td></td>"
										+ stepAdvanceds[i].autority + "</td><td></td><td></td><td></td><td></td></tr>");
						var decisionsList = stepAdvanceds[i].decisions;
						$.each(decisionsList, function(j, items){
							$("tbody").append(
									"<tr class='decision" + parseInt(stepAdvanceds[i].stepId)
											+ "'><td></td><td></td><td></td><td></td><td></td><td></td><td>"
											+ decisionsList[j].decision + "</td><td>"
											+ decisionsList[j].nextStepNameId + "</td><td>"
											+ decisionsList[j].condition + "</td><tr>");
						});
						
					


//					stepIdFlag = steps[i].step_id;
					//		$("tbody").append("<tr><td>"+steps[i].stepId+"</td><td>"+steps[i].stepName+"</td><td>"+steps[i].phase+"</td><td>"+steps[i].decision+"</td><td>"+steps[i].condition+"</td><td>"+steps[i].intervenor+"</td></tr>");
				});
			
	        }});
		}
		


		$("tr[class*=decision]").css("background-color", "rgb(116, 116, 16)");
		
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