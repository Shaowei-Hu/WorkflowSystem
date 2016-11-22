<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="wrapper">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" data-role="navigation" style="margin-bottom: 0">
		<jsp:include page="/pages/common/horizontalBar.jsp"></jsp:include>

		<div class="navbar-default sidebar" data-role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<c:forEach items="${menu}" var="item">
						<c:if test="${fn:length(item.children) == 0 }">
							<li><a href="${item.href}"><i class="${item.icon}"></i> ${item.text}</a></li>
						</c:if>
						<c:if test="${fn:length(item.children)  gt 0}">
							<li><a href="${item.href}"><i class="${item.icon}"></i> ${item.text} <span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<c:forEach items="${item.children}" var="child">
										<li><a href="${child.href}"><i class="${child.icon}"></i> ${child.text }</a></li>
									</c:forEach>
								</ul></li>
						</c:if>
					</c:forEach>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
	</nav>
</div>
<jsp:include page="/pages/common/importJavascript.jsp"></jsp:include>
