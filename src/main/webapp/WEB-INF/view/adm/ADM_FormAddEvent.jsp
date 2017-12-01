<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-vent</title>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="../Header.jsp" %>
	
	<div id="form-event" class="col-lg-12 space-top">
		<div class="col-md-4"></div>
		<div class="col-md-4 col-lg-4">
			<form action="/adm/addEvent" method="post">
				<div class="form-group">
					<input type="text" name="nome"
						placeholder="Nome" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="text" name="descricao"
						placeholder="Descrição" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="text" name="inicio"
						placeholder="Data de Inicio" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="text" name="fim"
						placeholder="Data do Final" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Cadastrar</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	
	<script type="text/javascript" src="/bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</body>
</html>