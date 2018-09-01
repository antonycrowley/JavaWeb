<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header><%@ include file="template/header.jsp"%></header>
	
	<article>
		<div class="container">
			<div class="jumbotron">
				
				<div class="form-group">
					<label for="usr">Username:</label>
					<input type="text" name="email" class="form-control" id="usr">
				</div>
				
				<div class="form-group">
					<label for="pwd">Password:</label>
					<input type="password" name="password" class="form-control" id="pwd">
				</div>
				
				<button class="btn btn-lg btn-outline-primary btn-block">Sign in</button>
				<a class="btn btn-lg btn-outline-danger btn-block" href="pages/register.jsp">Register</a>
				
			</div>
		</div>
	</article>
	
	<footer><%@ include file="template/footer.jsp" %></footer>
	


</body>
</html>