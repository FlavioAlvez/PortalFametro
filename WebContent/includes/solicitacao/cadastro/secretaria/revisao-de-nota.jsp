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
		<div class="col-md-2 col-sm-2 col-xs-2">
			<label class="col-md-12 col-sm-12 col-xs-12" for="disciplina">Avaliação
				<span class="required"></span>
			</label>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<select id="avaliacao" name="avaliacao"
					class=" form-control select2_single" required>
					<option value="" selected></option>
					<c:forEach var="avaliacao" items="${bancoAvaliacao.getBanco() }">
						<option value="${avaliacao.name() }">${avaliacao.name() }
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-10">
			<label class="col-md-12 col-sm-12 col-xs-12" for="disciplina">Disciplina
				<span class="required"></span>
			</label>
			<div class="col-md-2 col-sm-2 col-xs-2">
				<input type="text" id="disciplina-cdg" name="disciplina-cdg"
					required="required" class="form-control col-md-7 col-xs-12"
					value="" placeholder="Código" readonly>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10">
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
	<div class="form-group" id="divPro">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<label class="col-md-12 col-sm-12 col-xs-12" for="disciplina">Professor
				<span class="required"></span>
			</label>
			<div class="col-md-2 col-sm-2 col-xs-2">
				<input type="text" id="professor-cdg" name="professor-cdg"
					required="required" class="form-control col-md-7 col-xs-12"
					value="" placeholder="Código" readonly>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10">
				<select id="professor" name="professor"
					class=" form-control select2_single"
					onchange="setMatriculaProfessor(this)" required>
					<option value="" selected></option>
					<c:forEach var="professor" items="${bancoProfessor.getBanco() }">
						<option value="${professor.getMatricula() }">${professor.getMatricula() }&emsp;${professor.getNome() }
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
			<input type="submit" class="btn btn-success" value="Registrar">
		</div>
	</div>
</form>