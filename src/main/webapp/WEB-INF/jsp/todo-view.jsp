<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<meta charset="ISO-8859-1">
	<title>View Todo</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>View Todo:</h1>
	<div>
		<div><strong>ID:</strong> ${todo.id}</div>
	</div>
	<div>
		<div><strong>Description:</strong> ${todo.description}</div>
	</div>

	<a href="/todo/list">Back</a>
	<jsp:include page="footer.jsp"/>
</body>
</html>