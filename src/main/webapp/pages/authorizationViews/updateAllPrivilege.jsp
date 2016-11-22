<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<jsp:include page="/pages/common/importCss.jsp"></jsp:include>

</head>
<body>
	<div id="wrapper">

		<jsp:include page="/pages/common/commonHeader.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<br>
					<h1 class="page-header">Tables</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">DataTables Advanced Tables</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover" id="dataTables">


									<thead>
										<tr>
											<th>ID</th>
											<th>Privilege</th>
											<th>Description</th>
											<th>Update</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>	
									</tbody>
								</table>

							</div>


						</div>
						<!-- /.table-responsive -->
						<div class="well">
							<h4>DataTables Usage Information</h4>
							<p>
								DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also
								customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank"
									href="https://datatables.net/">https://datatables.net/</a>.
							</p>
							<a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>

	</div>
	<!-- /#page-wrapper -->


	<!-- /#wrapper -->



	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
    $(document).ready(function() {
/*         $('#dataTables').DataTable({
                responsive: true
        }); */
    });
    
	function init(){

			getAllPrivileges();
		
	};



	function getAllPrivileges(){
        $.ajax({url: '${pageContext.request.contextPath }/authorization/privilege', type: 'GET', success: function(privileges){
        	$("tbody").empty();
			$.each(privileges, function(i, item) {

					$("tbody").append(
							"<tr class='rowClickable'><td class='idCell'>"+ item.id + "</td><td>"
									+ item.privilegeName + "</td><td>"
									+ item.description + "</td><td>"
									+"<a href='${pageContext.request.contextPath }/authorization/updatePrivilegePage/"+item.id+"'><i class='fa fa-wrench fa-fw'></i></a></td>"
									+"<td><a href='javascript:deleteConfirm("+item.id+")'><i class='fa fa-trash fa-fw'></i></a></td>"
									+"</tr>");
			});
			
	        $('#dataTables').DataTable({
                responsive: true
        	});
	        		
        }});
	}
	
	function deleteConfirm(id){
		if(confirm('Are you sure to delete this user?')){
			deletePrivilege(id)
		}
	}

    function deletePrivilege(id){
    	$.ajax({
    	    url: '${pageContext.request.contextPath }/authorization/privilege/'+id,
    	    type: 'DELETE',
    	    success: function(result) {
    	        alert(id + " has been deleted.");
    	        window.location.reload();
    	    }
    	});
    }


	init();
    </script>
</body>
</html>