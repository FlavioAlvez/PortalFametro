<form id="formularioCadastro" class="form-horizontal form-label-left"
	method="post" action="AlunoController.do">
	<%@ include file="padrao-cadastrado.jsp"%>
	<br />
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Educacional</h2>
		</div>
	</div>
	<br />
	<div class="form-group">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<label class="" for="curso">Curso</label>
			<div class="">
				<input type="text" name="curso" id="curso" required
					class="form-control col-md-7 col-xs-12"
					value="[${usuario.getCurso().getCodigo() }] ${usuario.getCurso().getNome() }">
			</div>
		</div>
	</div>
	<div class="ln_solid"></div>
	<div class="form-group">
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="button" class="btn btn-danger" name="home" value="Home"
				onClick="location.href('home.jsp');"> <input type="submit"
				class="btn btn-success" name="action" value="Imprimir">
		</div>
	</div>
</form>