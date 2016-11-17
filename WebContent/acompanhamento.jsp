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

<title>Portal Fametro | Acompanhamento de Solicitações</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="css/custom.min.css" rel="stylesheet">
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
									<p>
										Add class
										<code>bulk_action</code>
										to table for bulk actions options on row select
									</p>

									<div class="table-responsive">
										<table class="table table-striped jambo_table bulk_action">
											<thead>
												<tr class="headings">
													<th><input type="checkbox" name="check" id="check"
														class="flat"></th>
													<th class="column-title">Código</th>
													<th class="column-title">Assunto</th>
													<th class="column-title">Etapa atual</th>
													<th class="column-title">Abertura</th>
													<th class="column-title">Fechamento</th>
													<th class="column-title">Código do cliente</th>
													<th class="column-title">Tipo</th>
													<th class="column-title">Status</th>
													<th class="column-title no-link last"><span
														class="nobr">Ação</span></th>
													<th class="bulk-actions" colspan="7"><a class="antoo"
														style="color: #fff; font-weight: 500;">Bulk Actions (
															<span class="action-cnt"> </span> ) <i
															class="fa fa-chevron-down"></i>
													</a></th>
												</tr>
											</thead>

											<tbody>
												<tr class="even pointer">
													<td class="a-center "><input type="checkbox"
														class="flat" name="table" id="table"></td>
													<td class=" ">46001</td>
													<td class=" ">QUEBRA DE PRÉ-REQUISITO</td>
													<td class=" ">Quebra Aceita</td>
													<td class=" ">12/09/2016 10:22</td>
													<td class=" ">19/09/2016 14:47</td>
													<td class=" ">2016200001</td>
													<td class=" ">Aluno</td>
													<td class=" ">Concluído confirmado</td>
													<td class=" last"><a href="#">Ver</a></td>
												</tr>
												<tr class="odd pointer">
													<td class="a-center "><input type="checkbox"
														class="flat" name="table-2" id="table-2"></td>
													<td class=" ">46001</td>
													<td class=" ">QUEBRA DE PRÉ-REQUISITO</td>
													<td class=" ">Quebra Aceita</td>
													<td class=" ">12/09/2016 10:22</td>
													<td class=" ">19/09/2016 14:47</td>
													<td class=" ">2016200001</td>
													<td class=" ">Aluno</td>
													<td class=" ">Concluído confirmado</td>
													<td class=" last"><a href="#">Ver</a></td>
												</tr>
											</tbody>
										</table>
									</div>
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
</body>
</html>