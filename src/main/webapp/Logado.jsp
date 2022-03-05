<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${dados}" var="dado">
			<tr>
				<th>ID:</th>
				<td>${dado.id}</td>
			</tr>
			<tr>
				<th>Nome:</th>
				<td>${dado.nome}</td>
			</tr>
			<tr>
				<th>CPF:</th>
				<td>${dado.cpf}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="AlterarSenha.jsp">Alterar senha</a>
</body>
</html>