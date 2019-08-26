<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<meta charset="ISO-8859-1">
	<title>Success</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>Success:</h1>
	Todo Added Successfully. (<a href="/todo/list">Goto List Page</a>)
	<jsp:include page="footer.jsp"/>
</body>
</html>