<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.orlando.model.*, com.orlando.util.*, com.orlando.daoimpl.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header><%@ include file="../template/header.jsp"%></header>
	<script src="../resources/js/home.js"></script>
	<article>
	<div class="container">
		<div class="jumbotron">
			<h1>Home</h1>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Age</th>
						<th scope="col">Address</th>
						<th scope="col">State</th>
						<th scope="col">City</th>
						<th scope="col">...</th>
						<th scope="col">...</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Person person : new Dropdowns().getPersonList()) {
					%>
					<tr>
						<td><%=person.getId()%></td>
						<td><%=person.getName()%></td>
						<td><%=person.getLastName()%></td>
						<td><%=person.getEmail()%></td>
						<td><%=person.getAge()%></td>
						<td><%=person.getAddress()%></td>
						<%
							for(State state : new Dropdowns().getStateDrop()){
								if(state.getId() == Integer.parseInt(person.getState())){
						%>
								<td><%=state.getName()%></td>
						<% 			
									
								}
							}
						%>
						<td><%=person.getCity()%></td>
						<td>
							<button class="btn btn-outline-primary btn-block"
								onclick="updatePerson(<%=person.getId()%>)">Update</button>
						</td>
						<td>
							<button class="btn btn-outline-primary btn-block"
								onclick="deletePerson(<%=person.getId()%>)">delete</button>
						</td>


					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</div>

		<div id="modal-update" title="update-user">
			<form method="POST" action="/WebProject/RegisterServlet">
				<div class="form-group">
					<label for="id-input">Name:</label> <input type="text" name="id"
						class="form-control" id="id-input" disabled>
				</div>
				
				<div class="form-group">
					<label for="name">Name:</label> <input type="text" name="name"
						class="form-control" id="name">
				</div>

				<div class="form-group">
					<label for="lastname">Lastname:</label> <input type="text"
						name="lastname" class="form-control" id="lastname">
				</div>

				<div class="form-group">
					<label for="email">Email:</label> <input type="text" name="email"
						class="form-control" id="email">
				</div>

				<div class="form-group">
					<label for="age">Age:</label> <input type="text" name="age"
						class="form-control" id="age">
				</div>

				<div class="form-group">
					<label for="state">State:</label> <select id="state-select"
						name="state" class="form-control">
						<%
							for (State state : new Dropdowns().getStateDrop()) {
						%>
						<option value="<%=state.getId()%>"><%=state.getName()%></option>
						<%
							}
						%>
					</select>
				</div>

				<div class="form-group">
					<label for="city">city:</label> <select id="city-select"
						name="city" class="form-control">

					</select>
				</div>

				<div class="form-group">
					<label for="address">Address:</label> <input type="text"
						name="address" class="form-control" id="address">
				</div>

				<div class="form-group">
					<label for="name">Password:</label> <input type="password"
						name="password" class="form-control" id="password">
				</div>

				<div class="form-group">
					<label for="confirm-password">Confirm Password:</label> <input
						type="password" name="confirm-password" class="form-control"
						id="confirm-password">
				</div>

				<button type="submit" class="btn btn-lg btn-outline-primary">Register</button>
				<a class="btn btn-lg btn-outline-danger" href="../index.jsp"
					role="button">Cancel</a>
			</form>

		</div>
	</div>
	</article>

	<footer><%@ include file="../template/footer.jsp"%></footer>

</body>
</html>