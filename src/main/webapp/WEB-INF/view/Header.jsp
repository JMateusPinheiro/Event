<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div>
		<header>
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="/"><img alt="Logo E-vent"
							src="../../img/logo/E-vent.png" /></a>
						<div class="pull-right">
							<ul class="nav navbar-nav navbar-right">
								<c:choose>
									<c:when test="${user != null}">
										<li class="dropdown"><a id="btn-perfil"
											class="dropdown-toggle" data-toggle="dropdown" href="#">${user.nome}
												<span class="caret"></span>
										</a>
											<ul class="dropdown-menu">
												<li><a href="/usuario"><span
														class="glyphicon glyphicon-user"></span> Perfil</a></li>
												<c:if test="${user.id == 1}">
													<li><a href="/AdmEvent"><span
															class="glyphicon glyphicon-cog"></span> Gerenciar Eventos</a></li>
												</c:if>
												<c:if test="${user.id != 1}">
													<li><a href="/user/MyEvents"><span
															class="glyphicon glyphicon-cog"></span> Meus Eventos</a></li>
												</c:if>
												<li role="separator" class="divider"></li>
												<li><a href="/logout"><span
														class="glyphicon glyphicon-log-out"></span> Sair</a></li>
											</ul></li>
									</c:when>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</nav>
		</header>
	</div>
</body>
</html>