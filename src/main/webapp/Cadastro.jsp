<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Cadastrar" method='Post'>
		Nome: <input type="text" maxlength="45"  name="txtNome"><br>
		cpf: <input type="text" maxlength="11" name="txtCpf"><br>
		senha: <input type="password" maxlength="45" name="txtSenha"><br>
		<input type="submit" value='Cadastrar'>
		<input type='reset' value='Limpar'>
	</form>
</body>
</html>