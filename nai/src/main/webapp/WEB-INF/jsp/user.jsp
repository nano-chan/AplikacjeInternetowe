<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>MyApp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

	<form action="/logout" method="post">
		<input type="submit" value="Sign Out" />
	</form>

	<p>Create new user:
	<form action="/user" object="${newUser}" method="post">
		<div>
			<label> Name: <input type="text" name="name" /></label>
		</div>
		<div>
			<label> Surname: <input type="text" name="surname" /></label>
		</div>
		<div>
			<label> Age: <input type="number" name="age" min="7" /></label>
		</div>
		<div>
			<input type="submit" value="Add" />
		</div>
	</form>
	</p>

	<p>
	<table>
		Users:
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Surname</td>
			<td>Age</td>
			<td>Rented books</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.surname}</td>
				<td>${user.age}</td>

				<td>
					<table>
						<c:forEach items="${user.rentedBooks}" var="rentedBook">
							<tr>
								<td>${rentedBook.title}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<form action="/user/ + ${user.id}" method="get" object="${user}">
						<button name="edit">Edit</button>
					</form>
				</td>
				<td>
					<form action="/user/delete?id= + ${user.id}" method="post"
						object="${user}">
						<button name="delete">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
	</p>



</body>
</html>