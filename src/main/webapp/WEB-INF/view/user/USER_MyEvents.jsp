<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-vent</title>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>
</head>
<body>
	<%@ include file="../Header.jsp"%>

	<h1>Meus Eventos</h1>
	<div>
		<table class="table table-hover text-center">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Data de inicio</th>
					<th>Data do Fim</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="event" items="${myevents}">
					<tr>
						<td>${event.nome}</td>
						<td>${event.descricao}</td>
						<td>${event.inicio}</td>
						<td>${event.fim}</td>
						<td><a href="/user/EventDetail/${event.id}"
							class="btn btn-success">Ver Evento</a></td>
						<td><a href="user/leaveEvent/${event.id}"
							class="btn btn-danger">Sair do Evento</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript" src="/bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</body>
</html>