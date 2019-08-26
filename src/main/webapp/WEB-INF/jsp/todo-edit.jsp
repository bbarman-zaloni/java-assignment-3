<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<meta charset="ISO-8859-1">
	<title>Edit Todo</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>Edit Todo:</h1>
	<form:form action="/todoEdit" method="post" modelAttribute="todo">
		<form:input path="id" value="${todo.id}" type="hidden" />
		Description: <form:input path="description" value="${todo.description}" />
		<input type="submit" value="Submit" />
	</form:form>

	<a href="/todo/list">Back</a>
	<jsp:include page="footer.jsp"/>
</body>
</html>