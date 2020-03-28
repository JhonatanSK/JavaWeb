<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.Pais" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Paises</title>
</head>
<body>
	<div>
		<h3>Olá, segue abaixo as informações do país cadastrado</h3>
		<%Pais pais = (Pais)request.getAttribute("pais"); %>
		<p>Id: <%= pais.getId() %> </p>
		<p>Nome: <%= pais.getNome() %></p>
		<p>Área: <%= pais.getArea() %></p>
		<p>População: <%= pais.getPopulacao() %></p>
	</div>

</body>
</html>