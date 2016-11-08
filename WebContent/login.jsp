<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Portal Fametro | Login</title>

<!-- <meta name="viewport" -->
<!-- 	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"> -->
<!-- <meta name="apple-mobile-web-app-capable" content="yes"> -->

<link href="css/login/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/login/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="css/login/font-awesome.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">

<link href="css/login/style.css" rel="stylesheet" type="text/css">
<link href="css/pages/signin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<!--/.nav-collapse -->
			</div>
			<!-- /container -->
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- /navbar -->
	<div class="account-container">
		<div class="content clearfix">
			<form id="formlogin" action="LoginController.do" method="post">
				<img class="img-logo" src="img/logo-login-page.png" alt="logo">
				<h2>Portal Acadêmico</h2>
				<div class="login-fields">
					<p>Insira seu usuário e senha</p>
					<c:if test="${loginInvalido }">
						<div class="alert alert-danger" role="alert">
							<img src="img/exclamação.png">&nbsp; &nbsp; A matrícula ou
							senha está incorreta!
						</div>
					</c:if>

					<div class="field">
						<label for="matricula">Matricula</label> <input type="text"
							id="username" name="username" value="" placeholder="Matrícula"
							class="login username-field" />
					</div>
					<!-- /field -->
					<div class="field">
						<label for="password">Senha:</label> <input type="password"
							id="password" name="password" value="" placeholder="Senha"
							class="login password-field" />
					</div>
					<!-- /password -->
				</div>
				<!-- /login-fields -->
				<div class="login-actions">
					<input type="submit" name="action" value="Entrar"
						class="button btn btn-success btn-large">
				</div>
				<!-- .actions -->
			</form>
		</div>
		<!-- /content -->
	</div>
	<!-- /account-container -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/signin.js"></script>
</body>
</html>