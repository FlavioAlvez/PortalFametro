<form id="formularioCadastro" class="form-horizontal form-label-left"
	method="post" action="AlunoController.do">
	<%@ include file="cadastro-padrao.jsp" %>
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
				<select name="curso" id="curso" class=" form-control select2_single"
					required>
					<option value="" selected></option>
					<c:forEach var="curso" items="${bancoCurso.getBanco() }">
						<option value="${curso.getCodigo() }">${curso.getNome() }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="ln_solid"></div>
	<div class="form-group">
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="reset" class="btn btn-warning" name="redefinir" value="Redefinir"> 
			<input type="submit" class="btn btn-success" name="action"
				value="Cadastrar">
		</div>
	</div>
</form>