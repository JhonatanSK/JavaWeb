<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.Pais" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema de Paises</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
		<header>
			<nav class="navbar navbar-dark bg-primary">
				<a class="navbar-brand" href="#">Sistema de Paises</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
				  <span class="navbar-toggler-icon"></span>
				</button>
			  
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				  <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active">
					  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
					  <a class="nav-link" href="#">Link</a>
					</li>
					<li class="nav-item">
					  <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
					</li>
				  </ul>
				 </div>
			</nav>
		</header>
		<main class="container">
			<div>
				<h4 class="font-weight-normal" id="info">País cadastrado com sucesso! </h4>
				<p class="font-weight-normal" id="info">segue abaixo as informações do país cadastrado</p>
			</div>
	
			<div class="jumbotron bg-light border border-primary">          
				<%Pais pais = (Pais)request.getAttribute("pais"); %>
				<p id="attr-p">Id: <%= pais.getId() %></p>
				<p id="attr-p">Nome: <%= pais.getNome() %></p>
				<p id="attr-p">Área: <%= pais.getArea() %></p>
				<p id="attr-p">População: <%= pais.getPopulacao() %></p>
			</div>
			<div id="btn-voltar">
				<button type="button" class="btn btn-primary btn-lg">Voltar</button>
			</div>
		</main>
	
		<footer class="bg-light text-center">
			<p class=" text-muted">@Sistema de Paises</p>
		</footer>
	
	</body>
</html>