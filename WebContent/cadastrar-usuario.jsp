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

<title>Portal Fametro | Cadastrar Usuário</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="css/custom.min.css" rel="stylesheet">

<!-- Switchery -->
<link href="css/switchery/switchery.min.css" rel="stylesheet">
<!-- Select2 -->
<link href="css/select2/select2.min.css" rel="stylesheet">

</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<c:import url="menu-de-navegacao.jsp" />

			<c:import url="navegacao-de-topo.jsp" />

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Cadastrar Usuário</h3>
						</div>

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
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<c:if test="${param.tipo.equalsIgnoreCase('aluno')}">
										<h2>Informações do Aluno</h2>
									</c:if>
									<c:if test="${param.tipo.equalsIgnoreCase('professor')}">
										<h2>Informações do Professor</h2>
									</c:if>
									<c:if test="${param.tipo.equalsIgnoreCase('secretario')}">
										<h2>Informações do Secretário</h2>
									</c:if>
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
									<div class="clearfix"></div>
								</div>
								<c:choose>
									<c:when
										test="${param.tipo.equalsIgnoreCase('aluno') or param.tipo.equalsIgnoreCase('professor') or param.tipo.equalsIgnoreCase('secretario')}">
										<div class="x_content">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="x_content">
													<br />
													<c:if test="${param.tipo.equalsIgnoreCase('aluno') }">
														<form id="formularioCadastro"
															class="form-horizontal form-label-left" method="post"
															action="AlunoController.do">
													</c:if>
													<c:if test="${param.tipo.equalsIgnoreCase('professor') }">
														<form id="formularioCadastro"
															class="form-horizontal form-label-left" method="post"
															action="ProfessorController.do">
													</c:if>
													<c:if test="${param.tipo.equalsIgnoreCase('secretario') }">
														<form id="formularioCadastro"
															class="form-horizontal form-label-left" method="post"
															action="SecretarioController.do">
													</c:if>
													<div class="profile_title">
														<div class="col-md-6">
															<h2>Identificação</h2>
														</div>
													</div>
													<br />
													<div class="form-group">
														<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Nome
															<span class="required">*</span>
														</label>

														<div class="col-md-12 col-sm-12 col-xs-12">
															<input type="text" name="nome" id="nome" required
																class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 col-sm-4 col-xs-8" for="rg">RG
															<span class="required">*</span>
														</label> <label class="col-md-4 col-sm-4 col-xs-8" for="cpf">CPF
															<span class="required">*</span>
														</label> <label class="col-md-4 col-sm-4 col-xs-8" for="genero">Gênero
															<span class="required">*</span>
														</label>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="rg" id="rg" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="cpf" id="cpf" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="genero" id="genero" required
																class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-6" for="nascimento">Data
															de Nascimento <span class="required">*</span>
														</label> <label class="col-md-5 col-sm-5 col-xs-10"
															for="naturalidade">Naturalidade <span
															class="required">*</span>
														</label> <label class="col-md-4 col-sm-4 col-xs-8"
															for="estado-natal">Estado Natal <span
															class="required">*</span>
														</label>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="nascimento" id="nascimento"
																required class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-5 col-sm-5 col-xs-10">
															<input type="text" name="naturalidade" id="naturalidade"
																required class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="estado-natal" id="estado-natal"
																required class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<br />
													<div class="profile_title">
														<div class="col-md-6">
															<h2>Filiação</h2>
														</div>
													</div>
													<br />
													<div class="form-group">
														<label class="col-md-6 col-sm-6 col-xs-12" for="pai">Nome
															do Pai <span class="required">*</span>
														</label> <label class="col-md-6 col-sm-6 col-xs-12" for="mae">Nome
															da Mãe <span class="required">*</span>
														</label>

														<div class="col-md-6 col-sm-6 col-xs-12">
															<input type="text" name="pai" id="pai" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-6 col-sm-6 col-xs-11">
															<input type="text" name="mae" id="mae" required
																class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<br />
													<div class="profile_title">
														<div class="col-md-6">
															<h2>Endereço</h2>
														</div>
													</div>
													<br />
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-6" for="cep">CEP
															<span class="required">*</span>
														</label> <label class="col-md-9 col-sm-9 col-xs-18"
															for="logradouro">Logradouro <span
															class="required">*</span>
														</label>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="cep" id="cep" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-9 col-sm-9 col-xs-18">
															<input type="text" name="logradouro" id="logradouro"
																required class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-5 col-sm-5 col-xs-10"
															for="complemento">Complemento <span
															class="required">*</span>
														</label> <label class="col-md-3 col-sm-3 col-xs-6" for="numero">Número
															<span class="required">*</span>
														</label> <label class="col-md-4 col-sm-4 col-xs-8" for="bairro">Bairro
															<span class="required">*</span>
														</label>

														<div class="col-md-5 col-sm-5 col-xs-10">
															<input type="text" name="complemento" id="complemento"
																required class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="numero" id="numero" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="bairro" id="bairro" required
																class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 col-sm-4 col-xs-8" for="estado">Estado
															<span class="required">*</span>
														</label> <label class="col-md-4 col-sm-4 col-xs-8" for="cidade">Cidade
															<span class="required">*</span>
														</label> <label class="col-md-4 col-sm-4 col-xs-8" for="pais">País
															<span class="required">*</span>
														</label>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="estado" id="estado" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="cidade" id="cidade" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-4 col-sm-4 col-xs-8">
															<input type="text" name="pais" id="pais" required
																class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<br />
													<div class="profile_title">
														<div class="col-md-6">
															<h2>Contato</h2>
														</div>
													</div>
													<br />
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-6" for="email">Email
															<span class="required">*</span>
														</label> <label class="col-md-3 col-sm-3 col-xs-6"
															for="fone-residencial">Telefone Residencial <span
															class="required">*</span>
														</label> <label class="col-md-3 col-sm-3 col-xs-6"
															for="fone-celular">Telefone Celular <span
															class="required">*</span>
														</label> <label class="col-md-3 col-sm-3 col-xs-6" for="fone-3">Telefone
															3 <span class="required">*</span>
														</label>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="email" id="email" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="fone-residencial"
																id="fone-residencial" required
																class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="fone-celular" id="fone-celular"
																required class="form-control col-md-7 col-xs-12">
														</div>

														<div class="col-md-3 col-sm-3 col-xs-6">
															<input type="text" name="fone-3" id="fone-3" required
																class="form-control col-md-7 col-xs-12">
														</div>
													</div>

													<br />
													<c:if
														test="${param.tipo.equalsIgnoreCase('aluno') or param.tipo.equalsIgnoreCase('professor')}">
														<div class="profile_title">
															<div class="col-md-6">
																<h2>Educacional</h2>
															</div>
														</div>
														<c:if test="${param.tipo.equalsIgnoreCase('aluno') }">
															<br />
															<div class="form-group">
																<label class="col-md-12 col-sm-12 col-xs-12" for="curso">
																	Curso</label>
																<div class="col-md-12 col-sm-12 col-xs-12">
																	<select name="curso" id="curso"
																		class="select2_single form-control" required>
																		<option value="" selected></option>
																		<c:forEach var="curso"
																			items="${bancoCurso }">
																			<option value="${curso.getCodigo() }">${curso.getNome() }</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
														</c:if>
														<c:if test="${param.tipo.equalsIgnoreCase('professor') }">
															<div class="form-group">
																<label class="col-md-12 col-sm-12 col-xs-12"
																	for="disciplina"> Disciplinas</label>
																<div class="col-md-12 col-sm-12 col-xs-12">
																	<select name="disciplina" id="disciplina"
																		class="select2_multiple form-control"
																		multiple="multiple" name="">
																		<c:forEach var="disciplina"
																			items="${bancoDisciplina }">
																			<option value="${disciplina.getCodigo() }">${disciplina.getNome() }</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="form-group">
																<div class="col-md-12 col-sm-12 col-xs-12">
																	<label for="coordenador"> <input
																		name="coordenador" id="coordenador" type="checkbox"
																		class="js-switch" /> Coordenador
																	</label>
																</div>
															</div>
														</c:if>
													</c:if>
													<div class="ln_solid"></div>
													<div class="form-group">
														<div class="col-md-6 col-sm-6 col-xs-12">
															<input type="submit" class="btn btn-success"
																name="action" value="Concluir cadastro">
														</div>
													</div>
													</form>
												</div>
											</div>
										</div>
									</c:when>
									<c:otherwise>Parâmetro Inválido</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
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