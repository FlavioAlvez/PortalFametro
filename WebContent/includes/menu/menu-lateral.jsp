<!-- sidebar menu -->

<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3></h3>
		<ul class="nav side-menu"></ul>
	</div>
	<div class="menu_section">
		<h3>Geral</h3>
		<ul class="nav side-menu">
			<li><a href="home.jsp"><i class="fa fa-home"></i> Home</a></li>
			<li><a><i class="fa fa-desktop"></i> Cadastro de Usuário <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="cadastrar-usuario.jsp?tipo=Aluno">Aluno</a></li>
					<li><a href="cadastrar-usuario.jsp?tipo=Professor">Professor</a></li>
					<li><a href="cadastrar-usuario.jsp?tipo=Secretario">Secretário</a></li>
				</ul></li>
		</ul>
	</div>
	<div class="menu_section">
		<h3>Solicitações</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-cog"></i> Solicitação <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="solicitacao.jsp?grupoAtendimento=1">Secretaria</a></li>
<!-- 					<li><a href="solicitacao.jsp?tipo=2">Financeiro</a></li> -->
<!-- 					<li><a href="solicitacao.jsp?tipo=3">Relacionamento</a></li> -->
				</ul></li>
			<li><a href="acompanhamento.jsp"><i class="fa fa-table"></i>
					Acompanhamento</a></li>
			<li><a href="pesquisa.jsp"><i class="fa fa-bar-chart-o"></i>
					Pesquisa</a></li>
		</ul>
	</div>
</div>
<!-- /sidebar menu -->