<form id="formularioCadastro" class="form-horizontal form-label-left"
	method="post" action="ProfessorController.do">
	<%@ include file="padrao.jsp"%>
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Educacional</h2>
		</div>
	</div>
	<c:if test="${usuario.getDisciplinas().size() > 0 }">
		<div class="form-group">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<label for="disciplina"> Disciplinas</label>
				<div class="">
					<c:forEach var="disciplina" items="${usuario.getDisciplinas() }">
						<input type="text" name="disciplina" id="" required
							class="form-control col-sm-12 col-md-12 col-xs-12"
							value="[${disciplina.getCodigo() }] ${disciplina.getNome() }">
					</c:forEach>
				</div>
			</div>
		</div>
	</c:if>
	<div class="form-group">
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label for="coordenador">É coordenador <span class="required">*</span>
			</label>
			<div>
				<input type="text" name="fone-3" id="fone-3" required
					class="form-control col-md-7 col-xs-12"
					value="${usuario.isCoordenador() ? 'Sim' : 'Não'}">
			</div>
		</div>
	</div>
	<div class="ln_solid"></div>
</form>