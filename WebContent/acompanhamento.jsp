<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Portal Fametro | Acompanhamento</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="css/custom.min.css" rel="stylesheet">

<!-- Select -->
<link href="css/select/bootstrap-select.css" rel="stylesheet">

<!-- Select2 -->
<link href="css/select2/select2.min.css" rel="stylesheet">

<script type="text/javascript">
	function swap(obj) {
		var search = document.getElementById("parametro");
		switch (obj.value) {
		case "codigo":
			search.setAttribute("type", "search");
			search.setAttribute("placeholder",
					"Informe o código...");
		case "grupo-atendimento":
			search.setAttribute("type", "search");
			search.setAttribute("placeholder",
					"Informe o grupo de atendimento...");
			break;
		case "tipo-atendimento":
			search.setAttribute("type", "search");
			search.setAttribute("placeholder",
					"Informe o tipo de atendimento...");
			break;
		case "cliente":
			search.setAttribute("type", "search");
			search.setAttribute("placeholder",
					"Informe o número de matrícula do cliente...");
			break;
		case "tipo-cliente":
			search.setAttribute("type", "search");
			search.setAttribute("placeholder", "Informe o tipo de cliente...");
			break;
		case "abertura":
			search.setAttribute("type", "date");
			search.setAttribute("placeholder", "Informe a data de abertura...");
			break;
		case "fechamento":
			search.setAttribute("type", "date");
			search.setAttribute("placeholder",
					"Informe a data de fechamento...");
			break;
		case "assunto":
			search.setAttribute("type", "search");
			search.setAttribute("placeholder",
					"Informe o assunto...");
			break;
		default:
			search.setAttribute("type", "search");
			search.setAttribute("placeholder", "Pesquisar por...");
			break;
		}
	}
</script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@ include file="menu-de-navegacao.jsp"%>

			<%@ include file="navegacao-de-topo.jsp"%>

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<!-- page title -->
					<div class="page-title">
						<!-- page title left -->
						<div class="title_left">
							<h3>Acompanhamento</h3>
						</div>

						<!-- /page title left -->
						<!-- page title right-->
						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" name="search" id="search"
										class="form-control" placeholder="Search for..."> <span
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
									<h2>Solicitações</h2>
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
									<form data-parsley-validate
										class="form-horizontal form-label-left" method="post"
										action="SolicitacaoController.do">
										<div class="form-group">
											<div class="col-xs-0 col-sm-0 col-md-1 col-lg-1"></div>
											<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
												<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
													<select class="form-control select2_single" id="tipo"
														name="tipo" onchange="swap(this)" required="required">
														<option value="" selected>Selecione...</option>
														<option value="codigo">Código</option>
														<option value="grupo-atendimento">Grupo de
															Atendimento</option>
														<option value="tipo-atendimento">Tipo de
															Atendimento</option>
														<option value="cliente">Cliente</option>
														<option value="tipo-cliente">Tipo de Cliente</option>
														<option value="abertura">Data de Abertura</option>
														<option value="fechamento">Data de Fechamento</option>
														<option value="assunto">Assunto</option>
													</select>
												</div>
												<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
													<input type="search" name="parametro" id="parametro"
														class="form-control" placeholder="Pesquisar por..." required="required">
												</div>
												<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
													<button type="submit" class="btn btn-primary" name="action"
														value="Pesquisar">
														<i class="fa fa-search"></i> &nbsp;Pesquisar
													</button>
												</div>
											</div>
											<div class="col-xs-0 col-sm-0 col-md-1 col-lg-1"></div>
										</div>
									</form>
									<div class="ln_solid"></div>
									<form action=""></form>
								</div>
								<!-- /panel content -->
							</div>
						</div>
					</div>
					<!-- /panel -->
				</div>
			</div>
			<!-- /page content -->

			<%@ include file="conteudo-do-rodape.jsp"%>
		</div>
	</div>

	<!-- jQuery -->
	<script src="jquery/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="js/custom.min.js"></script>

	<!-- Select -->
	<script src="js/select/bootstrap-select.js"></script>
	<!-- Select2 -->
	<script src="js/select2/select2.full.min.js"></script>

	<script>
		$(document).ready(function() {
			$(".select2_single").select2({});
			$(".select2_group").select2({});
			$(".select2_multiple").select2({});
		});
	</script>
	<!--  /Select /Select2 -->
</body>
</html>