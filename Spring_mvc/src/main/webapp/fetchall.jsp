<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List"%>
<%@ page import="Spring_mvc.Dto.EmployeeDto"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetching all in table format</title>
</head>
<body>

	<%
	List<EmployeeDto> list = (List<EmployeeDto>) request.getAttribute("objects");
	%>
	<table border="10px">
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>

		<%for (EmployeeDto a :list){%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getName()%></td>

		</tr>
		<%}%>

	</table>
</body>

</body>
</html>