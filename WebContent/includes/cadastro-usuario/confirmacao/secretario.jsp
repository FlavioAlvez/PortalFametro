<form id="formularioCadastro" class="form-horizontal form-label-left"
	method="post" action="SecretarioController.do">
	<%@ include file="padrao.jsp"%>
	<div class="ln_solid"></div>
	<div class="form-group">
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="button" class="btn btn-primary" name="voltar"
				value="Voltar"
				onClick="location.href='cadastrar-usuario.jsp?tipo=Secretario'">

			<button type="submit" class="btn btn-success" name="action"
				value="Imprimir">
				<i class="fa fa-print" aria-hidden="true"></i>&nbsp;Imprimir
			</button>
		</div>
	</div>
</form>