<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%> --%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="FlavioAlves">
<link rel="shortcut icon" href="img/favicon.ico">

<title>Portal Fametro | Solicitação</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="css/custom.min.css" rel="stylesheet">

<link href="css/cursor/cursor-handle.css" rel="stylesheet">

<style type="text/css">
.transparente {
	opacity: 0;
}
</style>

<script src="js/solicitacoes.js"></script>
</head>

<!-- Switchery -->
<link href="css/switchery/switchery.min.css" rel="stylesheet">
<!-- Select2 -->
<link href="css/select2/select2.min.css" rel="stylesheet">

<!-- Esconde elementos na pagina -->
<style>
.escondido {
	display: none;
}
</style>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<jsp:useBean id="now" class="br.edu.fametro.portal.model.DateUtility" />
			<c:import url="menu-de-navegacao.jsp" />

			<c:import url="navegacao-de-topo.jsp" />

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<!-- page title -->
					<div class="page-title">
						<!-- page title left -->
						<div class="title_left">
							<h3>Solicitação</h3>
						</div>

						<!-- /page title left -->
						<!-- page title right-->
						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
						<!-- /page title right -->
					</div>
					<!-- /page title -->

					<div class="clearfix"></div>

					<!-- panel -->
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<!-- panel header -->
								<div class="x_title">
									<!-- panel header title -->
									<h2>Registro da Solicitação</h2>
									<!-- /panel header title -->
									<!-- panel header toolox -->
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i></a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Settings 1</a></li>
												<li><a href="#">Settings 2</a></li>
											</ul></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<!-- /panel header toolox -->
									<div class="clearfix"></div>
								</div>
								<!-- /panel header -->
								<!-- panel content -->
								<div class="x_content">
									<br />

									<c:choose>
										<c:when test="${param.grupo eq 1 }">
											<c:choose>
												<c:when test="${param.tipo eq 1 }">
													<%@ include
														file="includes/solicitacao/cadastro/secretaria/quebra-de-pre-requisito.jsp"%>
												</c:when>
												<c:when test="${param.tipo eq 2 }">
													<%@ include
														file="includes/solicitacao/cadastro/secretaria/revisao-de-nota.jsp"%>
												</c:when>
												<c:when test="${param.tipo eq 3 }">
													<%@ include
														file="includes/solicitacao/cadastro/secretaria/abono-de-falta.jsp"%>
												</c:when>
												<c:when test="${param.tipo eq 4 }">
													<%@ include
														file="includes/solicitacao/cadastro/secretaria/ouvidoria.jsp"%>
												</c:when>
												<c:otherwise>
													<%@ include
														file="includes/solicitacao/cadastro/grupo-atendimento/secretaria.jsp"%>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<%@ include
												file="includes/solicitacao/cadastro/grupo-atendimento/grupos.jsp"%>
										</c:otherwise>
									</c:choose>
								</div>
								<!-- /panel content -->
							</div>
						</div>
					</div>
					<!-- /panel -->
				</div>
			</div>
			<!-- /page content -->

			<c:import url="conteudo-do-rodape.jsp" />
		</div>
	</div>

	<!-- jQuery -->
	<script src="jquery/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="js/custom.min.js"></script>

	<!-- Switchery -->
	<script src="js/switchery/switchery.min.js"></script>
	<!-- Select2 -->
	<script src="js/select2/select2.full.min.js"></script>
	<!-- Select2 -->
	<script>
		$(document).ready(function() {
			$(".select2_single").select2({});
			$(".select2_group").select2({});
			$(".select2_multiple").select2({});
		});
	</script>
	<!-- /Select2 -->
</body>
</html>