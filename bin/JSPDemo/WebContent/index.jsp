<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Demo</title>
</head>
<body>

	<h1>Hello World!</h1>
	
	<%!
		String getString(){
		return "abcd";
	}
	%>
	
	<% System.out.println("Hello World!"); 
		String str = "String variable";%>
	<% for(int i = 1; i <= 10; i++){ %>
		<li><%= i%> </li>
	<%} %>
	
	<%= str %>
	
	<p>Getting string from declaration tag: <%=getString() %></p>
	

</body>
</html>