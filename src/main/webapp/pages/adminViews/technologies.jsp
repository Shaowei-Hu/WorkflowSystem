<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.InetAddress" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome Admin</title>

<jsp:include page="/pages/common/importCss.jsp"></jsp:include>


</head>

<body>

<jsp:useBean id="properties" class="com.shaowei.workflow.util.MavenProperties" scope="application" />

	<div id="wrapper">

		<jsp:include page="adminHeader.jsp"></jsp:include>

		<div id="page-wrapper">

			<br> <br> <br> <br>
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="Java" src="${pageContext.request.contextPath }/images/java.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">Java <c:out value="${properties.javaVersion}"/></div>
			</div>
			
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="Spring" src="${pageContext.request.contextPath }/images/spring.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">Spring <c:out value="${properties.springVersion}"/></div>
			</div>
			
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="Hibernate" src="${pageContext.request.contextPath }/images/hibernate.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">Hibernate <c:out value="${properties.hibernateVersion}"/></div>
			</div>
			
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="Mysql" src="${pageContext.request.contextPath }/images/mysql.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">Mysql</div>
			</div>
			
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="Maven" src="${pageContext.request.contextPath }/images/maven.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">Maven</div>
			</div>
			
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="jQuery" src="${pageContext.request.contextPath }/images/jquery.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">jQuery</div>
			</div>
			
			<div class="panel panel-default col-lg-3">
				<div class="panel-body">
					<img alt="bootstrap" src="${pageContext.request.contextPath }/images/bootstrap.PNG" height="88" height="120">
				</div>
				<div class="panel-footer">Bootstrap</div>
			</div>

			<table class="table table-striped">
				<tr><th align="center" colspan=2>Environnement Technique</th></tr>
				<%
			    InetAddress ip;
		        String hostname;
		        ip = InetAddress.getLocalHost();
	            hostname = ip.getHostName();
				String number = "";
				if (null != System.getProperty("weblogic.Name")) {
					number = System.getProperty("weblogic.Name").substring(13,System.getProperty("weblogic.Name").length());
				} else {
					number = hostname;
				}
				%>
				<tr><td>host.Name</td><td><%=number%></td></tr>
				<tr><td>host.Ip</td><td><%=ip%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.version</td><td><%=System.getProperty("java.version")%></td></tr>
				<tr><td>java.vendor</td><td><%=System.getProperty("java.vendor")%></td></tr>
				<tr><td>java.vendor.url</td><td><%=System.getProperty("java.vendor.url")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.home</td><td><%=System.getProperty("java.home")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.vm.specification.version</td><td><%=System.getProperty("java.vm.specification.version")%></td></tr>
				<tr><td>java.vm.specification.vendor</td><td><%=System.getProperty("java.vm.specification.vendor")%></td></tr>
				<tr><td>java.vm.specification.name</td><td><%=System.getProperty("java.vm.specification.name")%></td></tr>
				<tr><td>java.vm.version</td><td><%=System.getProperty("java.vm.version")%></td></tr>
				<tr><td>java.vm.vendor</td><td><%=System.getProperty("java.vm.vendor")%></td></tr>
				<tr><td>java.vm.name</td><td><%=System.getProperty("java.vm.name")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.specification.version</td><td><%=System.getProperty("java.specification.version")%></td></tr>
				<tr><td>java.specification.vendor</td><td><%=System.getProperty("java.specification.vendor")%></td></tr>
				<tr><td>java.specification.name</td><td><%=System.getProperty("java.specification.name")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.class.version</td><td><%=System.getProperty("java.class.version")%></td></tr>
				<tr><td>java.class.path</td><td><%=System.getProperty("java.class.path").replaceAll("[;]",";<br>")%></td></tr>
				<tr><td>java.library.path</td><td><%=System.getProperty("java.library.path").replaceAll("[;]",";<br>")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.io.tmpdir</td><td><%=System.getProperty("java.io.tmpdir")%></td></tr>
				<tr><td>java.compiler</td><td><%=System.getProperty("java.compiler")%></td></tr>
				<tr><td>java.ext.dir</td><td><%=System.getProperty("java.ext.dir")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.os.name</td><td><%=System.getProperty("java.os.name")%></td></tr>
				<tr><td>java.os.arch</td><td><%=System.getProperty("java.os.arch")%></td></tr>
				<tr><td>java.os.version</td><td><%=System.getProperty("java.os.version")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.file.separator</td><td><%=System.getProperty("java.file.separator")%></td></tr>
				<tr><td>java.path.separator</td><td><%=System.getProperty("java.path.separator")%></td></tr>
				<tr><td>java.line.separator</td><td><%=System.getProperty("java.line.separator")%></td></tr>
				<tr><th colspan=2></th></tr>
				<tr><td>java.user.name</td><td><%=System.getProperty("java.user.name")%></td></tr>
				<tr><td>java.user.home</td><td><%=System.getProperty("java.user.home")%></td></tr>
				<tr><td>java.user.dir</td><td><%=System.getProperty("java.user.dir")%></td></tr>
			</table>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>
</html>
