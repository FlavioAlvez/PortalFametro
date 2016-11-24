<form id="formularioCadastro" class="form-horizontal form-label-left"
	method="post" action="ProfessorController.do">
	<%@ include file="padrao.jsp"%>
	<br />
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Educacional</h2>
		</div>
	</div>
	<br />
	<div class="form-group">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<label for="disciplina"> Disciplinas</label>
			<div class="">
				<select name="disciplina" id="disciplina"
					class="selectpicker form-control" multiple
					data-selected-text-format="count > 3" data-actions-box="true">
					<c:forEach var="disciplina" items="${bancoDisciplina.getBanco() }">
						<option value="${disciplina.getCodigo() }">${disciplina.getNome() }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<label for="coordenador"> <input name="coordenador"
				id="coordenador" type="checkbox" class="js-switch" />
				&nbsp;Coordenador
			</label>
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