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

	<p>
	<form action="/user" method="get">
		<button name="back">Back</button>
	</form>
	</p>

	Add rented book:
	<p>
	<div>
		<form action="/rentedBook/+${user.id}" object="${rentedBook}"
			method="post">
			<div>
				<label> Title: <input type="text" name="title" /></label>
			</div>
			<div>
				<input type="submit" value="Add book" />
			</div>

		</form>
	</div>
	</p>

	Edit user:
	<div>
		<form action="/user/update/ + ${user.id}" object="${user}" method="post">
			<div>
				<label> Name: <input type="text" name="name"
					value="${user.name}" /></label>
			</div>
			<div>
				<label> Surname: <input type="text" name="surname"
					value="${user.surname}" /></label>
			</div>
			<div>
				<label> Age: <input type="number" name="age" 
					value="${user.age}" /></label>
			</div>
			<div>
				<input type="submit" value="Save" />
			</div>
		</form>
		<p>
		<table>
			Rented books:
			<c:forEach items="${user.rentedBooks}" var="rentedBook">
				<tr>
					<td>${rentedBook.title}</td>
					<td>
						<form
							action="/rentedBook/delete?rentedBookId= + ${rentedBook.id} + &userId= + ${user.id}"
							method="post" object="${rentedBook}">
							<button name="remove">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		</p>
	</div>

</body>
</html>