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
<!-- Mascara -->
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="jquery/jquery.maskedinput.js"></script>

<!-- Adicionando Javascript -->
<script type="text/javascript">
	$(document).ready(
			function() {

				function limpa_formulário_cep() {
					// Limpa valores do formulário de cep.
					$("#logradouro").val("");
					$("#bairro").val("");
					$("#cidade").val("");
					$("#uf").val("");
				}

				//Quando o campo cep perde o foco.
				$("#cep").blur(
						function() {

							//Nova variável "cep" somente com dígitos.
							var cep = $(this).val().replace(/\D/g, '');

							//Verifica se campo cep possui valor informado.
							if (cep != "") {

								//Expressão regular para validar o CEP.
								var validacep = /^[0-9]{8}$/;

								//Valida o formato do CEP.
								if (validacep.test(cep)) {

									//Preenche os campos com "..." enquanto consulta webservice.
									$("#rua").val("...");
									$("#bairro").val("...");
									$("#cidade").val("...");
									$("#uf").val("...");

									//Consulta o webservice viacep.com.br/
									$.getJSON("//viacep.com.br/ws/" + cep
											+ "/json/?callback=?", function(
											dados) {

										if (!("erro" in dados)) {
											//Atualiza os campos com os valores da consulta.
											$("#rua").val(dados.logradouro);
											$("#bairro").val(dados.bairro);
											$("#cidade").val(dados.localidade);
											$("#uf").val(dados.uf);
										} //end if.
										else {
											//CEP pesquisado não foi encontrado.
											limpa_formulário_cep();
											alert("CEP não encontrado.");
										}
									});
								} //end if.
								else {
									//cep é inválido.
									limpa_formulário_cep();
									alert("Formato de CEP inválido.");
								}
							} //end if.
							else {
								//cep sem valor, limpa formulário.
								limpa_formulário_cep();
							}
						});
			});
</script>

</head>


<script type="text/javascript">
	$(document).ready(function() {
		$("#nascimento").mask("99/99/9999");
		$("#cpf").mask("999.999.999-99");
		$("#cep").mask("99999-999");
		$("#fone-residencial").mask("(99)99999-9999");
		$("#fone-celular").mask("(99)99999-9999");
		$("#fone-3").mask("(99)99999-9999");
	});
</script>


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
												<c:if test="${erro }">
													<div class="alert alert-danger" role="alert">
														<img src="img/exclamação.png">&nbsp; &nbsp; Houve um
														erro durante o cadastro!
													</div>
												</c:if>
												<c:if test="${sucesso }">
													<div class="alert alert-danger" role="alert">
														<img src="img/success.png">&nbsp; &nbsp; Cadastrado
														com sucesso!
													</div>
												</c:if>
												<div class="x_content">
													<br />
													<c:if test="${param.tipo.equalsIgnoreCase('aluno') }">
														<%@ include
															file="includes/cadastro-usuario/cadastro-aluno.jsp"%>
													</c:if>
													<c:if test="${param.tipo.equalsIgnoreCase('professor') }">
														<%@ include
															file="includes/cadastro-usuario/cadastro-professor.jsp"%>
													</c:if>
													<c:if test="${param.tipo.equalsIgnoreCase('secretario') }">
														<%@ include
															file="includes/cadastro-usuario/cadastro-secretario.jsp"%>
													</c:if>
												</div>
											</div>
										</div>
										<c:if test="${sucesso }">
											<!-- Script que desabilita campos -->
										</c:if>
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


	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="js/custom.min.js"></script>

	<script src="js/validacoes.js"></script>

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

		$(document).ready(function() {
			$("#nascimento").mask("99/99/9999");
			$("#cpf").mask("999.999.999-99");
			$("#cep").mask("99999-999");
			$("#fone-residencial").mask("(99)99999-9999");
			$("#fone-celular").mask("(99)99999-9999");
			$("#fone-3").mask("(99)99999-9999");
		});
	</script>
	<!-- /Select2 e Mascaras -->
</body>
</html>