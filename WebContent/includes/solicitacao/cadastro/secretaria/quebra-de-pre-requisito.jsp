<form id="demo-form2" data-parsley-validate
	class="form-horizontal form-label-left"
	action="SolicitacaoController.do">
	<%@ include file="../padrao.jsp"%>
	<br />
	<div class="profile_title">
		<div class="col-md-12">
			<h2>Parâmetros</h2>
		</div>
	</div>
	<br />
	<div class="form-group" id="divDis">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<label class="col-md-12 col-sm-12 col-xs-12" for="disciplina">Disciplina
				<span class="required"></span>
			</label>
			<div class="col-md-3 col-sm-3 col-xs-3">
				<input type="text" id="disciplina-cdg" name="disciplina-cdg"
					required="required" class="form-control col-md-7 col-xs-12"
					value="" placeholder="Código" readonly>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-9">
				<select id="disciplina" name="disciplina"
					class=" form-control select2_single"
					onchange="setCodigoDisciplina(this)" required>
					<option value="" selected></option>
					<c:forEach var="disciplina" items="${bancoDisciplina.getBanco() }">
						<option value="${disciplina.getCodigo() }">${disciplina.getCodigo() }&emsp;${disciplina.getNome() }
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="ln_solid"></div>
	<div class="form-group">
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="reset" class="btn btn-cancel" value="Redefinir">
			<input type="submit" class="btn btn-success" name="action" value="Registrar">
		</div>
	</div>
</form>