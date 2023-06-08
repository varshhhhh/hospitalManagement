<%@page import="java.util.List"%>
<%@page import="DTO.doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<doctor>list=(List<doctor>)request.getAttribute("list"); %>
<table  border="5px" bordercolor="red">

			<tr>
				<th>id</th>
				<th>name</th>
				<th>mobile</th>
				<th>age</th>
				<th>status</th>
				<th>change status</th>
			</tr>
			
			
			
			<%for(doctor doctor:list){ %>
			<tr>
			<th><%= doctor.getId() %></th>
			<th><%= doctor.getName() %></th>
			<th><%= doctor.getMobile() %></th>
			<th><%= doctor.getAge() %></th>
			<th><%= doctor.isStatus() %></th>
			<th><a href="changedoctorStatuss?id=<%=doctor.getId() %>"> <button>change</button></a></th>
			</tr>
			<%} %>
			
</body>
</html>