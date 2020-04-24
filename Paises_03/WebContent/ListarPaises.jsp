<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Paises</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<header>
		<c:import url="menu.jsp" />
	</header>
	<div id="main" class="container-fluid" style="margin-top: 50px">

		<div id="top" class="row">
			<div class="col-sm-3">
				<h2>Itens</h2>
			</div>
			<div class="col-sm-6">

				<div class="input-group h2">
					<input name="data[search]" class="form-control" id="search"
						type="text" placeholder="Pesquisar Itens"> <span
						class="input-group-btn">
						<button class="btn btn-primary" type="submit">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>

			</div>
		</div>
		<!-- /#top -->


		<hr />
		<div id="list" class="row">

			<div class="table-responsive col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>População</th>
							<th>Area</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pais" items="${lista}">
							<tr>
								<td>${pais.id}</td>
								<td>${pais.nome}</td>
								<td>${pais.populacao}</td>
								<td>${pais.area}</td>
								<td class="actions">
								<a class="btn btn-success btn-xs" href="ManterPais.do?acao=Visualizar&id=${pais.id}">Visualizar</a> 
								<a class="btn btn-warning btn-xs" href="/Paises/ManterPais.do?acao=Editar&id=${pais.id}">Editar</a> 
								<a class="btn btn-danger btn-xs" href="/Paises/ManterPais.do?acao=Excluir&id=${pais.id}" data-toggle="modal"
									data-target="#delete-modal">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>