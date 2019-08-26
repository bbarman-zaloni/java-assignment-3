<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<meta charset="ISO-8859-1">
	<title>Todo List</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>

	<h1>Todo List:</h1>
		<table class="zdp-data-grid">
		<thead>
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty todoList}">
	            <tr><td>No todo available!</td></tr>
		    </c:if>
			<c:if test="${not empty todoList}">
	        <c:forEach var="todo" items="${todoList}">
	            <tr>
	            	<td>${todo.id}</td>
	            	<td><a href="/todo/view/${todo.id}">${todo.description}</a></td>
	            	<td><a href="/todo/edit/${todo.id}">Edit</a> | <a href="/todo/delete/${todo.id}">Delete</a></td>
	            </tr>
	        </c:forEach>
		    </c:if>
		</tbody>
		</table>
		<a href="/todo/add">ADD</a>

	<jsp:include page="footer.jsp"/>
</body>
</html>