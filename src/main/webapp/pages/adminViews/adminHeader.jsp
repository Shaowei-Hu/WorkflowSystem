
<div id="wrapper">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" data-role="navigation" style="margin-bottom: 0">
		<jsp:include page="/pages/common/horizontalBar.jsp"></jsp:include>

		<div class="navbar-default sidebar" data-role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="${pageContext.request.contextPath }/admin/welcome"><i class="fa fa-home fa-fw"></i> Welcome</a></li>
					
					<li><a href="#"><i class="fa fa-group fa-fw"></i> Users<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath }/admin/create"><i class="fa fa-plus fa-fw"></i> Create</a></li>
							<li><a href="${pageContext.request.contextPath }/admin/list"><i class="fa fa-bars fa-fw"></i> List</a></li>
							<li><a href="${pageContext.request.contextPath }/admin/operate"><i class="fa fa-cog fa-fw"></i> Operate</a></li>
						</ul>
					</li>
					
					<li><a href="getAllTeachers.action"><i class="glyphicon glyphicon-road"></i> Workflow<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath }/workflow/getWorkflowTable"><i class="glyphicon glyphicon-random"></i> Workflow</a></li>
							<li><a href="${pageContext.request.contextPath }/workflow/updateWorkflow"><i class="glyphicon glyphicon-list-alt"></i> Steps</a></li>
							<li><a href="${pageContext.request.contextPath }/workflow/createWorkflowPage"><i class="fa fa-plus"></i> Create Workflow</a></li>
						</ul>
					</li>


					<li><a href="getMyInformation.action"><i class="fa fa-edit fa-fw"></i> Authorization<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath }/authorization/allPrivilegePage"><i class="fa fa-university"></i> Privileges</a></li>
							<li><a href="${pageContext.request.contextPath }/authorization/addPrivilegePage"><i class="fa fa-user"></i> AddPrivilege</a></li>
							<li><a href="${pageContext.request.contextPath }/authorization/updateAllPrivilegePage"><i class="fa fa-user"></i> UpdatePrivilege</a></li>							
							<li><a href="${pageContext.request.contextPath }/authorization/getAllRolePage"><i class="fa fa-user"></i> Roles</a></li>
							<li><a href="${pageContext.request.contextPath }/authorization/addRolePage"><i class="fa fa-plus"></i> CreateRole</a></li>
							<li><a href="${pageContext.request.contextPath }/authorization/updateAllRolePage"><i class="fa fa-user"></i> UpdateRole</a></li>
						</ul>
					</li>
					
					<li><a href="${pageContext.request.contextPath }/admin/technologies"><i class="glyphicon glyphicon-paperclip"></i> Technologies</a></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
	</nav>
</div>

<jsp:include page="/pages/common/importJavascript.jsp"></jsp:include>

