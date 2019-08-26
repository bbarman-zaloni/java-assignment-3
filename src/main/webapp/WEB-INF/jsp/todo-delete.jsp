<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<meta charset="ISO-8859-1">
	<title>Delete Todo</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>Delete Todo:</h1>
	<form:form action="/todoDelete" method="post" modelAttribute="todo">
		<form:input path="id" value="${todo.id}" type="hidden" />
		<h3>Are you sure you want to delete the todo item?</h3>
		<div>"${todo.description}"</div>
		<input type="submit" value="Delete" />
	</form:form>
	<a href="/todo/list">Back</a>
	<jsp:include page="footer.jsp"/>
</body>
</html>