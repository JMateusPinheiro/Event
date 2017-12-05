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
</head>
<body>
	<%@ include file="../Header.jsp"%>

	<div>
		<h1>${event.nome}</h1>
		<br />
		<h4>Descrição</h4>
		<br />
		<p>${event.descricao}</p>
		<br />
		<p>Data de Inicio do Evento: ${event.inicio} || Data de Termino do
			Evento: ${event.fim}</p>
	</div>
	<div>
		<form action="/user/Commentar/${event.id}" method="post">
			<div class="form-group">
				<input name="comment" placeholder="Digite aqui seu comentario" />
			</div>
			<button type="submit" class="btn bg-primary">Comentar</button>
		</form>
		<div>
			<c:forEach var="comment" items="${comments}">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;${comment.owner} : ${comment.comment}</p>
				<c:forEach var="answer" items="${comment.answer.owner} :${comment.answer.comment}">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${answer}</p>
				</c:forEach>
				<form action="/user/Responder/${event.id}/${comment.id}" method="post">
					<div class="form-group">
						<input name="answer" placeholder="Digite aqui sua reposta" />
					</div>
					<button type="submit" class="btn bg-primary">Responder</button>
				</form>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript" src="/bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</body>
</html>