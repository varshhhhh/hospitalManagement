<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DTO.staff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<staff>list=(List<staff>)request.getAttribute("list"); %>
<table  border="5px" bordercolor="red">

			<tr>
				<th>id</th>
				<th>name</th>
				<th>mobile</th>
				<th>age</th>
				<th>status</th>
				<th>change status</th>
			</tr>
			
			
			
			<%for(staff staff:list){ %>
			<tr>
			<th><%= staff.getId() %></th>
			<th><%= staff.getName() %></th>
			<th><%= staff.getMobile() %></th>
			<th><%= staff.getAge() %></th>
			<th><%= staff.isStatus() %></th>
			<th><a href="changeStaffStatuss?id=<%=staff.getId() %>"> <button>change</button></a></th>
			</tr>
			<%} %>
			
			
	</table>


</body>
</html>