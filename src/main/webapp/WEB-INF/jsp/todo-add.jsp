<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<meta charset="ISO-8859-1">
	<title>Add Todo</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>Add Todo:</h1>
	<form:form action="/todoAdd" method="post" modelAttribute="todo">
		Description: <form:input path="description" />
		<input type="submit" value="Submit" />
	</form:form>
	<jsp:include page="footer.jsp"/>
</body>
</html>