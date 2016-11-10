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
</head>

<!-- Switchery -->
<link href="css/switchery/switchery.min.css" rel="stylesheet">
<!-- Select2 -->
<link href="css/select2/select2.min.css" rel="stylesheet">

<!-- Esconde elementos na pagina -->
<style>
	.escondido {
		display:none;
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
								<c:choose>
									<c:when test="${param.grupoAtendimento eq 1 }">
										<!-- panel content -->
										<div class="x_content">
											<br />
											<form id="demo-form2" data-parsley-validate
												class="form-horizontal form-label-left"
												action="SolicitacaoController.do">

												<div class="form-group">
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Tipo de Atendimento
															<span class="required">*</span>
													</label>
													
													<div class="col-md-1 col-sm-1 col-xs-12">
														<input type="tel" id="tipo-atendimento-cdg"
															name="tipo-atendimento-cdg" required="required"
															class="form-control col-md-7 col-xs-12" value="" readonly>
													</div>
													
													<div class="col-md-11 col-sm-5 col-xs-12">
														<select id="tipo-atendimento-descricao"
															name="tipo-atendimento-descricao" required="required"
															class=" form-control" form="demo-form2"
															onchange="tipoAtendimento(this)">
															<option value="" selected></option>
															<c:forEach var="tipoAtendimento"
																items="${bancoTipoAtendimento.getBanco() }">
																<c:if
																	test="${tipoAtendimento.getGrupo().getCodigo() eq  param.grupoAtendimento}">
																	<option value="${tipoAtendimento.getCodigo() }">${tipoAtendimento.getTipo() }</option>
																</c:if>
															</c:forEach>
														</select>
													</div>
													
												</div>

												<div class="form-group">
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Matrícula / Cliente
															<span class="required">*</span>
													</label>													
													
													<div class="col-md-3 col-sm-2 col-xs-12">
														<input type="text" id="matricula" name="matricula"
															required="required"
															class="form-control col-md-7 col-xs-12" value="" readonly>
													</div>
													
													<div class="col-md-9 col-sm-5 col-xs-12">
														<select id="nome" name="nome" required="required"
															class=" form-control"
															onchange="matriculaAluno(this)">
															<option value=""></option>
															<c:forEach var="aluno" items="${bancoAluno.getBanco() }">
																<option value="${aluno.getMatricula() }">${aluno.getNome() }</option>
															</c:forEach>
														</select>
													</div>
													
												</div>
												
												<div class="form-group">
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Grupo / Abertura / Fechamento
															<span class="required"></span>
													</label>													
													
													<div class="col-md-4 col-sm-2 col-xs-12">
														<c:if test="${param.grupoAtendimento == '1'}">
															<input id="grupo" class="form-control col-md-7 col-xs-12"
																type="text" name="grupo" value="SECRETARIA" readonly>
														</c:if>
													</div>
													<div class="col-md-4 col-sm-2 col-xs-12">
														<input id="abertura"
															class="form-control col-md-7 col-xs-12" type="date"
															name="abertura" value="${now.getDataAtualHtml() }"
															disabled>
													</div>
													<div class="col-md-4 col-sm-2 col-xs-12">
														<input id="fechamento"
															class="form-control col-md-7 col-xs-12" type="date"
															name="fechamento" disabled>
													</div>
													
												</div>

												<div class="form-group">
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Assunto
															<span class="required">*</span>
													</label>													

													<div class="col-md-12 col-sm-6 col-xs-12">
														<input id="assunto" name="assunto"
															class="date-picker form-control col-md-7 col-xs-12"
															required="required" type="text">
													</div>
													
												</div>

												<div class="form-group">
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Descrição
															<span class="required">*</span>
													</label>													
													
													<div class="col-md-12 col-sm-6 col-xs-12">
														<textarea id="message" required="required"
															class="form-control" name="message"
															data-parsley-trigger="keyup" data-parsley-minlength="20"
															data-parsley-maxlength="100"
															data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
															data-parsley-validation-threshold="10"></textarea>
													</div>
													
												</div>																							
												
												<div class="form-group" id="divDis">
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Disciplina
															<span class="required"></span>
													</label>													
													
													<div class="col-md-12 col-sm-5 col-xs-12">
														<select id="disciplina" name="disciplina"
														class=" form-control col-md-6 col-sm-5 col-xs-12">
															<option value="" selected></option>
															<c:forEach var="disciplina"
																items="${bancoDisciplina.getBanco() }">
																<option value="${disciplina.getCodigo() }">${disciplina.getNome() }</option>
															</c:forEach>
														</select>
													</div>
												</div>
												
												<div class="escondido" id="divAv">																								
													<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Avaliação
															<span class="required"></span>
													</label>												
													
													<div class="col-md-1 col-sm-1 col-xs-12">
														<select name="avaliacao" id="avaliacao"
															class=" form-control">
															<option value=""></option>
															<c:forEach var="av"
																items="${bancoAvaliacao.getBanco() }">
																<option value="${av.name() }">${av.name() }</option>
															</c:forEach>
														</select>
													</div>												
													
												</div>
												
												<!-- 												<div class="form-group"> -->
												<!-- 													<label class="control-label col-md-3 col-sm-3 col-xs-12">Professor -->
												<!-- 														<span class="required">*</span> -->
												<!-- 													</label> -->

												<!-- 													<div class="col-md-6 col-sm-6 col-xs-12"> -->
												<!-- 														<select id="professor" name="professor" -->
												<!-- 															class="select2_multiple form-control" -->
												<!-- 															required="required" type="text"> -->
												<!-- 															<option value=""></option> -->
												<%-- 															<c:forEach var="professor" --%>
												<%-- 																items="${bancoProfessor.getBanco() }"> --%>
												<%-- 																<option value="${professor.getMatricula() }">${professor.getNome() }</option> --%>
												<%-- 															</c:forEach> --%>
												<!-- 														</select> -->
												<!-- 													</div> -->
												<!-- 												</div> -->

												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-sm-6 col-xs-12">
														<button type="reset" class="btn btn-cancel">Cancelar</button>
														<button type="submit" class="btn btn-success">Cadastrar</button>
													</div>
												</div>
											</form>
										</div>
										<!-- /panel content -->
									</c:when>
									<c:otherwise>
										Parâmetro Inválido
									</c:otherwise>
								</c:choose>
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

	<script src="js/solicitacoes.js"></script>

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