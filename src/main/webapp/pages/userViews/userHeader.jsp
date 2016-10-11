

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-fixed-top" data-role="navigation" style="margin-bottom: 0">
		<jsp:include page="/pages/common/horizontalBar.jsp"></jsp:include>

		<div class="navbar-default sidebar" data-role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="/Workflow/user/welcome"><i class="fa fa-home fa-fw"></i> Welcome</a></li>
					<li><a href="#"><i class="fa fa-archive fa-fw"></i> Documents<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">

							<li><a href="/Workflow/document/myList"><i class="fa fa-bars fa-fw"></i> List</a></li>

							<li><a href="/Workflow/document/create"><i class="fa fa-plus fa-fw"></i> Create</a></li>

							<li><a href="operate"><i class="fa fa-cog fa-fw"></i> Operate</a></li>

						</ul></li>
					<li><a href="getAllTeachers.action"><i class="fa fa-user fa-fw"></i> Theachers<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="getAllTeachersAdminT.action"><i class="fa fa-table fa-fw"></i> Tables</a></li>
							<li><a href="getAllTeachersAdminG.action"><i class="fa fa-picture-o fa-fw"></i> Graphics</a></li>

						</ul></li>
					<li><a href="getAllUsersdminT.action"><i class="fa fa-group fa-fw"></i> Users</a></li>
					<li><a href="getMyInformation.action"><i class="fa fa-plus fa-fw"></i> Create<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="document"><i class="fa fa-university"></i> Document</a></li>
							<li><a href="openCreationTeacher.action"><i class="fa fa-user"></i> Teacher</a></li>


						</ul></li>

					<li><a href="getMyInformation.action"><i class="fa fa-edit fa-fw"></i> Modify<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#"><i class="fa fa-university"></i> Cours</a></li>
							<li><a href="getAllTeachersAdminOperation.action"><i class="fa fa-user"></i> Teacher</a></li>


						</ul></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
	</div>

<jsp:include page="/pages/common/importJavascript.jsp"></jsp:include>

