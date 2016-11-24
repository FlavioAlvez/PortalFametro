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

<title>Portal Fametro | Imprimir</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- jquery -->
<script src="js/jquery.min.js"></script>

<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="css/custom.min.css" rel="stylesheet">

<!-- Switchery -->
<link href="css/switchery/switchery.min.css" rel="stylesheet">

<!-- Select -->
<link href="css/select/bootstrap-select.css" rel="stylesheet">

<!-- Select2 -->
<link href="css/select2/select2.min.css" rel="stylesheet">

<!-- Mascara -->
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="jquery/jquery.maskedinput.js"></script>
<script type="text/javascript" src="js/mascara/mascara.js"></script>

<script type="text/javascript" src="js/imprimir/imprimir.js"></script>

<style>
@media print {
	* {
		background: transparent !important;
		color: #000 !important;
		text-shadow: none !important;
		filter: none !important;
		-ms-filter: none !important;
	}
	body {
		margin: 0;
		padding: 0;
	}
	#noprint {
		display: none !important;
	}
	.right_col {
		margin: 0;
		overflow: visible;
		display: block;
		width: 100%;
		float: none !important;
	}
	footer {
		position: fixed;
		bottom: 0;
		padding-bottom: 0.5cm;
		position: fixed;
	}
	@page {
		margin: 1cm;
		widows: 5;
		orphans: 5;
	}
	.form-control {
		/* 		border: 0; */
		/* 		padding: 0; */
		/* 		overflow: visible; */
		widows: 5;
		orphans: 5;
		min-height: 100%;
		display: block;
	}
}
</style>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div id="noprint">
				<%@ include file="menu-de-navegacao.jsp"%>
				<%@ include file="navegacao-de-topo.jsp"%>
			</div>
			<!-- page content -->
			<section class="right_col" role="main">
				<div class="">
					<!-- panel -->
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<!-- panel header -->
								<div class="x_title">
									<div class="col-md-3 col-sm-3 col-xs-3"
										style="text-align: center;">
										<img alt="" src="img/logo-dashboard.png"
											style="width: 100%; height: auto;">
									</div>
									<div class="col-md-7 col-sm-7 col-xs-7"
										style="text-align: center;">
										<br /><br />
										<p id="title_print col-md-12 col-sm-12 col-xs-12"
											style="font-weight: 600; font-size: 120%;">FACULDADE
											METROPOLITANA DA GRANDE FORTALEZA
										<p>
										<p id="title_print col-md-12 col-sm-12 col-xs-12"
											style="font-weight: 800;  font-size: 140%">${titulo }
										<p>
									</div>
									<div class="col-md-2 col-sm-2 col-xs-2"
										style="text-align: center;">
										<br />
										${DateUtility.getDataHoraCompleta(DateUtility.getDataAtualDate()) }
									</div>
									<div class="clearfix"></div>
								</div>
								<!-- /panel header -->
								<!-- panel content -->
								<div class="x_content">
									<c:choose>
										<c:when
											test="${param.acao.equalsIgnoreCase('CadastroDeUsuario') }">
											<c:choose>
												<c:when test="${param.tipo.equalsIgnoreCase('Secretario') }">
													<%@ include
														file="includes/cadastro-usuario/imprimir/secretario.jsp"%>
												</c:when>
												<c:when test="${param.tipo.equalsIgnoreCase('Professor') }">
													<%@ include
														file="includes/cadastro-usuario/imprimir/professor.jsp"%>
												</c:when>
												<c:when test="${param.tipo.equalsIgnoreCase('Aluno') }">
													<%@ include
														file="includes/cadastro-usuario/imprimir/aluno.jsp"%>
												</c:when>
											</c:choose>
										</c:when>
									</c:choose>
								</div>
								<!-- /panel content -->
							</div>
						</div>
					</div>
					<!-- /panel -->
				</div>
			</section>
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

	<script type="text/javascript">
		imprimir();
	</script>
</body>
</html>