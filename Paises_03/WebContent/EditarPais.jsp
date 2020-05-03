<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema de Países</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script src="js/bootstrap.min.js"></script>

	<!-- <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> -->

</head>
<body>
	<header>
		<c:import url="menu.jsp" />
	</header>
	
	<main class="container">
		<div class="jumbotron bg-light border border-primary" >
			<form action="controller.do?command=AlterarPais&id=${pais.id}" method="POST">
				<div class="form-group">
					<label >Nome </label>
					<input type="text" name="nome" class="form-control" value="${pais.nome}">
					<small class="form-text text-muted">Digite o nome do país que você deseja alterar.</small>
				  </div>
				  <div class="form-group">
					<label >População</label>
					<input type="text" name="populacao" class="form-control"  value="${pais.populacao}">
					<small class="form-text text-muted">Digite o número de habitantes desse país.</small>
				  </div>
				  <div class="form-group">
					  <label >Area</label>
					  <input type="text" name="area" class="form-control"  value="${pais.area}">
					  <small class="form-text text-muted">Digite a area desse país.</small>
					</div>
				  <button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>

	</main>
	
	<footer class="bg-light text-center">
		<p class=" text-muted">@Sistema de Paises</p>
	</footer>

</body>
</html>