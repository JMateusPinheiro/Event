<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-vent</title>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id="form-cadastro" class="form-cadastro col-lg-12 space-top">
		<div class="col-md-4"></div>
		<div class="col-md-4 col-lg-4">
			<form action="/RequestSignUp" method="post">
			<img alt="Logo E-vent"
				src="../../img/logo/E-vent.png" class="img-responsive center-block"/><br />
				<div class="form-group">
					<input type="text" name="nome"
						placeholder="Nome" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="text" name="email"
						placeholder="Email" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="text" name="address"
						placeholder="Endereço" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="text" name="phone"
						placeholder="Telefone" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="password" name="password"
						placeholder="****" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="password" name="re-senha" placeholder="****" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Cadastrar</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>