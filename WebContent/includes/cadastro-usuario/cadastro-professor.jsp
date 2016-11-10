<form id="formularioCadastro" class="form-horizontal form-label-left"
	method="post" action="ProfessorController.do">
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Identificação</h2>
		</div>
	</div>
	<br />
	<div class="form-group">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<label class="" for="nome">Nome <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="nome" id="nome" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label class="" for="rg">RG <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="rg" id="rg" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label class="" for="cpf">CPF <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="cpf" id="cpf" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label class="" for="genero">Gênero <span class="required">*</span>
			</label>
			<div class="">
				<select name="genero" id="genero"
					class=" form-control col-sm-12 col-md-12 col-xs-12">
					<option value="" selected></option>
					<c:forEach var="genero" items="${bancoGenero.getBanco() }">
						<option value="${genero.name() }">${genero.name() }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label class="" for="nascimento">Data de Nascimento <span
				class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="nascimento" id="nascimento" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-5 col-sm-5 col-xs-12">
			<label class="" for="naturalidade">Naturalidade <span
				class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="naturalidade" id="naturalidade" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label class="" for="estado-natal">Estado Natal <span
				class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="estado-natal" id="estado-natal" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>
	<br />
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Filiação</h2>
		</div>
	</div>
	<br />
	<div class="form-group">
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label class="col-md-6 col-sm-6 col-xs-12" for="pai">Nome do
				Pai <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="pai" id="pai" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<label class="" for="mae">Nome da Mãe <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="mae" id="mae" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>
	<br />
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Endereço</h2>
		</div>
	</div>
	<br />
	<div class="form-group">
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label class="" for="cep">CEP <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="cep" id="cep" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-9 col-sm-9 col-xs-12">
			<label class="" for="rua">Logradouro <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="rua" id="rua" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-5 col-sm-5 col-xs-12">
			<label for="complemento">Complemento <span class="required">*</span>
			</label>
			<div>
				<input type="text" name="complemento" id="complemento" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label for="numero">Número <span class="required">*</span>
			</label>
			<div>
				<input type="number" min=0 name="numero" id="numero" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label for="bairro">Bairro <span class="required">*</span>
			</label>
			<div>
				<input type="text" name="bairro" id="bairro" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label for="uf">Estado <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="uf" id="uf" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label for="cidade">Cidade <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="cidade" id="cidade" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<label for="pais">País <span class="required">*</span>
			</label>
			<div class="">
				<input type="text" name="pais" id="pais" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>
	<br />
	<div class="profile_title">
		<div class="col-md-6">
			<h2>Contato</h2>
		</div>
	</div>
	<br />
	<div class="form-group">
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label for="email">Email <span class="required">*</span>
			</label>
			<div>
				<input type="email" name="email" id="email" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label for="fone-residencial">Telefone Residencial <span
				class="required">*</span>
			</label>
			<div>
				<input type="text" name="fone-residencial" id="fone-residencial"
					required class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label for="fone-celular">Telefone Celular <span
				class="required">*</span>
			</label>
			<div>
				<input type="text" name="fone-celular" id="fone-celular" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-12">
			<label for="fone-3">Telefone 3 <span class="required">*</span>
			</label>
			<div>
				<input type="text" name="fone-3" id="fone-3" required
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
	</div>
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
					class="selectpicker form-control" multiple data-selected-text-format="count > 3" data-actions-box="true">
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
			<input type="submit" class="btn btn-success" name="action"
				value="Cadastrar">
		</div>
	</div>
</form>