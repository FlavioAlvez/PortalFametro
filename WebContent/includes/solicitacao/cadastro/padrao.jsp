<div class="form-group">
	<div class="col-md-6 col-sm-6 col-xs-6">
		<label class="col-md-12 col-sm-12 col-xs-12">Grupo de
			Atendimento <span class="required">*</span>
		</label>
		<div class="col-md-3 col-sm-3 col-xs-3">
			<input type="tel" id="grupo-atendimento-cdg"
				name="grupo-atendimento-cdg" required="required"
				class="form-control col-md-7 col-xs-12" value="${param.grupo }"
				placeholder="Código" readonly>
		</div>
		<div class="col-md-9 col-sm-9 col-xs-9">
			<input type="tel" id="grupo-atendimento" name="grupo-atendimento"
				required="required" class="form-control col-md-7 col-xs-12"
				value="${bancoGrupoAtendimento.pesquisaCodigo(param.grupo).getGrupo() }"
				placeholder="Grupo de Atendimento" readonly>
		</div>
	</div>
	<div class="col-md-6 col-sm-6 col-xs-6">
		<label class="col-md-12 col-sm-12 col-xs-12">Tipo de
			Atendimento <span class="required">*</span>
		</label>
		<div class="col-md-3 col-sm-3 col-xs-3">
			<input type="tel" id="tipo-atendimento-cdg"
				name="tipo-atendimento-cdg" required="required"
				class="form-control col-md-7 col-xs-12" value="${param.tipo }"
				placeholder="Código" readonly>
		</div>
		<div class="col-md-9 col-sm-9 col-xs-9">
			<input type="tel" id="tipo-atendimento" name="tipo-atendimento"
				required="required" class="form-control col-md-7 col-xs-12"
				value="${bancoTipoAtendimento.pesquisaCodigo(param.tipo).getTipo() }"
				placeholder="Tipo de Atendimento" readonly>
		</div>
	</div>
</div>
<div class="form-group">
	<div class="col-md-3 col-sm-3 col-xs-3">
		<label class="col-md-12 col-sm-12 col-xs-12" for="matricula">Matrícula
			do cliente <span class="required">*</span>
		</label>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<input type="text" id="matricula" name="matricula"
				required="required" class="form-control" value="" readonly>
		</div>
	</div>
	<div class="col-md-6 col-sm-6 col-xs-6">
		<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Nome
			do cliente <span class="required">*</span>
		</label> <select id="nome" name="nome" required="required"
			class="form-control select2_single" onchange="matriculaAluno(this)">
			<option value="" selected></option>
			<c:forEach var="aluno" items="${bancoAluno.getBanco() }">
				<option value="${aluno.getMatricula() }">${aluno.getMatricula() }&emsp;${aluno.getNome() }</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-3">
		<label class="col-md-12 col-sm-12 col-xs-12" for="tipo-cliente">Tipo
			<span class="required">*</span>
		</label>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<input type="text" id="tipo-cliente" name="tipo-cliente"
				required="required" class="form-control" value="Aluno" readonly>
		</div>
	</div>
</div>
<div class="form-group">
	<div class="col-md-6 col-sm-6 col-xs-6">
		<label class="col-md-12 col-sm-12 col-xs-12" for="abertura">Abertura<span
			class="required"></span>
		</label>
		<div class="col-md-6 col-sm-6 col-xs-6">
			<input id="data-abertura" class="form-control" type="date"
				name="data-abertura" value="${now.getDataAtualHtml() }" required
				readonly>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-6">
			<input id="hora-abertura" class="form-control" type="text"
				name="hora-abertura" value="${now.getHoraAtual() }" required
				readonly>
		</div>
	</div>
	<div class="col-md-6 col-sm-6 col-xs-6">
		<label class="col-md-12 col-sm-12 col-xs-12" for="fechamento">Fechamento<span
			class="required"></span>
		</label>
		<div class="col-md-6 col-sm-6 col-xs-6">
			<input id="data-fechamento" class="form-control col-md-7 col-xs-12"
				type="date" name="data-fechamento" placeholder="dd/mm/aaaa" value=""
				disabled>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-6">
			<input id="hora-fechamento" class="form-control" type="text"
				name="hora-fechamento" placeholder="hh:mm:ss" value="" disabled>
		</div>
	</div>
</div>

<div class="form-group">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<label class="col-md-12 col-sm-12 col-xs-12" for="assunto">Assunto
			<span class="required">*</span>
		</label>

		<div class="col-md-12 col-sm-12 col-xs-12">
			<input id="assunto" name="assunto" class="form-control"
				required="required" type="text">
		</div>
	</div>
</div>

<div class="form-group">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<label class="col-md-12 col-sm-12 col-xs-12" for="nome">Descrição
			<span class="required">*</span>
		</label>

		<div class="col-md-12 col-sm-12 col-xs-12">
			<textarea id="message" required="required" class="form-control"
				name="message" data-parsley-trigger="keyup"
				data-parsley-minlength="5" data-parsley-maxlength="100"
				data-parsley-minlength-message="Vamos! Você precisa digitar pelo menos um comentário de 5 caracteres.."
				data-parsley-validation-threshold="10" required></textarea>
		</div>
	</div>
</div>