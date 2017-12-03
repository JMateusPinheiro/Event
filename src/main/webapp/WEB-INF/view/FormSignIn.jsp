<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-vent</title>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="form-login" class="form-login col-lg-12 space-top">
		<div class="col-md-4"></div>
		<div class="col-md-4 col-lg-4">
			<c:if test="${not empty msg && ver == 'Failed'}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>${msg}</p>
				</div>
			</c:if>
			<form method="post" action="/login">
				<img alt="Logo E-vent" src="../../img/logo/E-vent.png"
					class="img-responsive center-block" /><br />
				<div class="form-group">
					<input type="email" name="email" placeholder="Email"
						class="form-control" required />
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="password" required />
				</div>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
				<br />
				<p>
					Não possui cadastro? Clique <a href="/SignUp">aqui</a>
				</p>
			</form>
		</div>

		<div class="col-md-4"></div>
	</div>
	<script type="text/javascript" src="/bootstrap/js/jquery.js">
		
	</script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.js">
		
	</script>
</body>
</html>