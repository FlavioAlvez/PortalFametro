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
<!-- Mascara -->
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="jquery/jquery.maskedinput.js"></script>

<script>
function validarSenha(){
	novasenha = document.getElementById('nova-senha').value;
	confirmarsenha = document.getElementById('confirmar-senha').value;
   if (novasenha != confirmarsenha) {
      alert("Você deve inserir a mesma senha duas vezes para confirmá-la. !");
	  document.getElementById('confirmar-senha').value='';
	   
   }else{
      document.FormSenha.submit();
   }
}
</script>


<script type="text/javascript">
$(document).ready(function(){
		$("#data-nascimento").mask("99/99/9999");               
});
</script>

<title>Portal Fametro | Perfil</title>

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
					<div class="page-title">
						<div class="title_left">
							<h3>Troca de Senha</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" name="search" id="search" class="form-control"
										placeholder="Search for..."> <span
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
									<h2>Informações do Aluno/Professor/Secretário</h2>
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
								<div class="x_content">
									<div class="col-md-3 col-sm-3 col-xs-12 profile_left">
										<div class="profile_img">
											<div id="crop-avatar">
												<!-- Current avatar -->
												<img class="img-responsive avatar-view" src="images/img.jpg"
													alt="Avatar" title="Change the avatar">
											</div>
										</div>
										<h3>Admin</h3>

										<ul class="list-unstyled user_data">
											<li><i class="fa fa-map-marker user-profile-icon"></i>
												Bom Jardim, Fortaleza, CE</li>

											<li><i class="fa fa-briefcase user-profile-icon"></i>
												Análise e Desenvolvimento de Sistemas</li>
										</ul>
									</div>
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-9">
										<div class="x_content">
											<br />
											<form id="demo-form2" name="demo-form2" data-parsley-validate
												class="form-horizontal form-label-left" method="post"
												action="home.jsp">
												<div class="profile_title">
													<div class="col-md-6">
														<h2>Identificação</h2>
													</div>
												</div>
												<br />
												<div class="form-group">
													<label class="col-md-3 col-sm-3 col-xs-12" for="registro">Registro Acadêmico 
                                                    	<span class="required">*</span>
													</label> 
                                                    
                                                    <label class="col-md-9 col-sm-9 col-xs-12" for="nome">Nome 
														<span class="required">*</span>
													</label>
                                                    
													<div class="col-md-3 col-sm-3 col-xs-12">
														<input disabled ="text" name="registro" id="registro" required
															class="form-control col-md-7 col-xs-12">
													</div>
													
													<div class="col-md-9 col-sm-9 col-xs-12">
														<input disabled type="text" name="nome" id="nome" required
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-md-3 col-sm-3 col-xs-12" for="data-nascimento">Data de Nascimento 
                                                    	<span class="required">*</span>
													</label> 
                                                    
                                                    <label class="col-md-5 col-sm-5 col-xs-12" for="naturalidade">Naturalidade 
														<span	class="required">*</span>
													</label> 
                                                    
                                                    <label class="col-md-4 col-sm-4 col-xs-12" for="estado-natal">Estado Natal 
                                                    	<span class="required">*</span>
													</label>
                                                    
													<div class="col-md-3 col-sm-3 col-xs-12">
														<input disabled type="text" name="data-nascimento" id="data-nascimento" required
															class="form-control col-md-7 col-xs-12">
													</div>
													<div class="col-md-5 col-sm-5 col-xs-12">
														<input disabled type="text" name="naturalidade" id="naturalidade" required
															class="form-control col-md-7 col-xs-12">
													</div>
													<div class="col-md-4 col-sm-4 col-xs-12">
														<input disabled type="text" name="estado-natal" id="estado-natal" required
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>
												<br />
												<div class="profile_title">
													<div class="col-md-6">
														<h2>Segurança</h2>
													</div>
												</div>
												<br />
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12" for="senha-atual">Senha Atual 
														<span class="required">*</span>
													</label>
                                                    
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="password" name="senha-atual" id="senha-atual" required
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>
                                                
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12" for="nova-senha">Nova Senha 
														<span class="required">*</span>
													</label>
                                                    
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="password" name="nova-senha" id="nova-senha" required="required"
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>
                                                
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Confirmar Nova Senha 
														<span class="required">*</span>
													</label>
                                                    
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="password" name="confirmar-senha" id="confirmar-senha" required="required"
															class="form-control col-md-7 col-xs-12">
													</div>
												</div>
                                                
												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="submit" class="btn btn-cancel" name="concluir" value="Cancelar"> 
														<input type="submit" class="btn btn-success" name="" value="Concluir" onClick="validarSenha()">
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
			<%@ include file="conteudo-do-rodape.jsp"%>
		</div>
	</div>

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="js/custom.min.js"></script>
</body>
</html>