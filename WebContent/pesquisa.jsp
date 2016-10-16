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
<meta name="author" content="EduardoRoseo">
<link rel="shortcut icon" href="img/favicon.ico">

<title>Portal Fametro | Pesquisa</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="css/custom.min.css" rel="stylesheet">
</head>

<!-- Switchery -->
<link href="css/switchery/switchery.min.css" rel="stylesheet">
<!-- Select2 -->
<link href="css/select2/select2.min.css" rel="stylesheet">

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
		
			<c:import url="menu-de-navegacao.jsp"/>

			<c:import url="navegacao-de-topo.jsp"/>

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<!-- page title -->
					<div class="page-title">
						<!-- page title left -->
						<div class="title_left">
							<h3>Pesquisa de Solicitações</h3>
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
									<h2>Pesquisa</h2>
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
									<form id="form_pesquisa" data-parsley-validate
										class="form-horizontal form-label-left"
										action="SolicitacaoController.do">

										<div class="form-group">
											<label class="col-md-12 col-sm-12 col-xs-12"
												for="first-name">Tipo da Solicitação
											</label>

											<div class="col-md-9 col-sm-12 col-xs-12">
												<select id="tipo-atendimento-pesquisa" name="tipo-atendimento-pesquisa" 
													class="select2_single form-control" form="form_pesquisa">
													<option>ANÁLISE DE EXCESSO DE CARGA HORÁRIA</option>
													<option>DESCONTO DE ALUNOS TRANSF. OU GRAD. DE OUTRA IES</option>
													<option>DESCONTO DE DEPENDENTE/FUNCIONARIO FAMETRO</option>
													<option>DESCONTO DE EX-ALUNO</option>
													<option>DESCONTO DE MONITORIA OU INICIAÇÃO CIENTÍFICA</option>
													<option>DESCONTO DE PARENTESCO</option>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-3 col-sm-4 col-xs-8" for="first-name">
												Data de Abertura
											</label> <label class="col-md-3 col-sm-4 col-xs-8"
												for="first-name">Data de Fechamento
											</label> <label class="col-md-4 col-sm-4 col-xs-8"
												for="first-name">Status
											</label>

											<div class="col-md-3 col-sm-4 col-xs-8">
												<input type="text" name="data-abertura"
													id="data-abertura"
													class="form-control col-md-7 col-xs-12">
											</div>
											<div class="col-md-3 col-sm-4 col-xs-8">
												<input type="text" name="data-fechamento" id="data-fechamento"
													class="form-control col-md-7 col-xs-12">
											</div>
											<div class="col-md-3 col-sm-4 col-xs-8">
												<select id="tipo-atendimento-descricao" name="tipo-atendimento-descricao" 
													class="select2_single form-control" form="form_pesquisa">
													<option>CONCLUÍDO</option>
													<option>EM ANÁLISE</option>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-8 col-sm-3 col-xs-6" for="first-name">
												Assunto
											</label>
											<div class="col-md-9 col-sm-12 col-xs-12">
												<input type="text" name="assunto" id="assunto"
													class="form-control col-md-7 col-xs-12">
											</div>
										</div>
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<button type="submit" class="btn btn-cancel">Cancelar</button>
												<button type="submit" class="btn btn-success">Enviar</button>
											</div>
										</div>
									</form>
								</div>
								<!-- /panel content -->
							</div>
						</div>
					</div>
					<!-- /panel -->
				</div>
			</div>
			<!-- /page content -->

			<c:import url="conteudo-do-rodape.jsp"/>
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