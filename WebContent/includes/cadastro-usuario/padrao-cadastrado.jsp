<div class="profile_title">
	<div class="col-md-6">
		<h2>Identifica��o</h2>
	</div>
</div>
<br />
<div class="form-group">
	<div class="col-md-3 col-sm-3 col-xs-12">
		<label class="" for="nome">Registro Acad�mico <span
			class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="nome" id="nome" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getMatricula() }">
		</div>
	</div>
	<div class="col-md-9 col-sm-9 col-xs-12">
		<label class="" for="nome">Nome <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="nome" id="nome" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getNome() }">
		</div>
	</div>
</div>
<div class="form-group">
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label class="" for="rg">RG <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="rg" id="rg" required
				class="form-control col-md-7 col-xs-12" value="${usuario.getRg() }">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label class="" for="cpf">CPF <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="cpf" id="cpf" required
				class="form-control col-md-7 col-xs-12" value="${usuario.getCpf() }">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label class="" for="genero">G�nero <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="genero" id="genero" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getGenero().name() }">
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
				class="form-control col-md-7 col-xs-12"
				value="${DateUtility.DateToMask(usuario.getNascimento()) }">
		</div>
	</div>
	<div class="col-md-5 col-sm-5 col-xs-12">
		<label class="" for="naturalidade">Naturalidade <span
			class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="naturalidade" id="naturalidade" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getNaturalidade() }">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label class="" for="estado-natal">Estado Natal <span
			class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="estado-natal" id="estado-natal" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEstadoNatal() }">
		</div>
	</div>
</div>
<br />
<div class="profile_title">
	<div class="col-md-6">
		<h2>Filia��o</h2>
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
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getFiliacao().getPai() }">
		</div>
	</div>
	<div class="col-md-6 col-sm-6 col-xs-12">
		<label class="" for="mae">Nome da M�e <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="mae" id="mae" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getFiliacao().getMae() }">
		</div>
	</div>
</div>
<br />
<div class="profile_title">
	<div class="col-md-6">
		<h2>Endere�o</h2>
	</div>
</div>
<br />
<div class="form-group">
	<div class="col-md-3 col-sm-3 col-xs-12">
		<label class="" for="cep">CEP <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="cep" id="cep" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getCep() }">
		</div>
	</div>
	<div class="col-md-9 col-sm-9 col-xs-12">
		<label class="" for="rua">Logradouro <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="rua" id="rua" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getLogradouro() }">
		</div>
	</div>
</div>

<div class="form-group">
	<div class="col-md-5 col-sm-5 col-xs-12">
		<label for="complemento">Complemento <span class="required">*</span>
		</label>
		<div>
			<input type="text" name="complemento" id="complemento" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getComplemento() }">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-12">
		<label for="numero">N�mero <span class="required">*</span>
		</label>
		<div>
			<input type="number" min=0 name="numero" id="numero" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getNumero() }">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label for="bairro">Bairro <span class="required">*</span>
		</label>
		<div>
			<input type="text" name="bairro" id="bairro" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getBairro() }">
		</div>
	</div>
</div>
<div class="form-group">
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label for="uf">Estado <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="uf" id="uf" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getEstado() }">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label for="cidade">Cidade <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="cidade" id="cidade" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getCidade() }">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-12">
		<label for="pais">Pa�s <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="pais" id="pais" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEndereco().getPais() }">
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
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getEmail() }">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-12">
		<label for="fone-residencial">Telefone Residencial <span
			class="required">*</span>
		</label>
		<div>
			<input type="text" name="fone-residencial" id="fone-residencial"
				required class="form-control col-md-7 col-xs-12"
				value="${usuario.getResidencial() }">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-12">
		<label for="fone-celular">Telefone Celular <span
			class="required">*</span>
		</label>
		<div>
			<input type="text" name="fone-celular" id="fone-celular" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getCelular() }">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-12">
		<label for="fone-3">Telefone 3 <span class="required">*</span>
		</label>
		<div>
			<input type="text" name="fone-3" id="fone-3" required
				class="form-control col-md-7 col-xs-12"
				value="${usuario.getOpcional() }">
		</div>
	</div>
</div>