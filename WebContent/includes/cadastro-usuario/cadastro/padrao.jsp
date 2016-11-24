<div class="profile_title">
	<div class="col-md-6">
		<h2>Identifica��o</h2>
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
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label class="" for="rg">RG <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="rg" id="rg" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label class="" for="cpf">CPF <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="cpf" id="cpf" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label class="" for="genero">G�nero <span class="required">*</span>
		</label>
		<div class="">
			<select name="genero" id="genero"
				class=" form-control col-sm-12 col-md-12 col-xs-12 select2_single"
				required>
				<option value="" selected></option>
				<c:forEach var="genero" items="${bancoGenero.getBanco() }">
					<option value="${genero.name() }">${genero.name() }</option>
				</c:forEach>
			</select>
		</div>
	</div>
</div>
<div class="form-group">
	<div class="col-md-3 col-sm-3 col-xs-3">
		<label class="" for="nascimento">Data de Nascimento <span
			class="required">*</span>
		</label>
		<div class="">
			<input type="date" name="nascimento" id="nascimento" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-5 col-sm-5 col-xs-5">
		<label class="" for="naturalidade">Naturalidade <span
			class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="naturalidade" id="naturalidade" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
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
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-6 col-sm-6 col-xs-12">
		<label class="" for="mae">Nome da M�e <span class="required">*</span>
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
		<h2>Endere�o</h2>
	</div>
</div>
<br />
<div class="form-group">
	<div class="col-md-3 col-sm-3 col-xs-3">
		<label class="" for="cep">CEP <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="cep" id="cep" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-9 col-sm-9 col-xs-9">
		<label class="" for="rua">Logradouro <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="rua" id="rua" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
</div>

<div class="form-group">
	<div class="col-md-5 col-sm-5 col-xs-5">
		<label for="complemento">Complemento <span class="required">*</span>
		</label>
		<div>
			<input type="text" name="complemento" id="complemento" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-3">
		<label for="numero">N�mero <span class="required">*</span>
		</label>
		<div>
			<input type="number" min=0 max=999999999 name="numero" id="numero"
				required class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label for="bairro">Bairro <span class="required">*</span>
		</label>
		<div>
			<input type="text" name="bairro" id="bairro" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
</div>
<div class="form-group">
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label for="uf">Estado <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="uf" id="uf" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label for="cidade">Cidade <span class="required">*</span>
		</label>
		<div class="">
			<input type="text" name="cidade" id="cidade" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
		<label for="pais">Pa�s <span class="required">*</span>
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
	<div class="col-md-3 col-sm-3 col-xs-4">
		<label for="fone-residencial">Telefone Residencial <span
			class="required">*</span>
		</label>
		<div>
			<input type="text" name="fone-residencial" id="fone-residencial"
				required class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-4">
		<label for="fone-celular">Telefone Celular <span
			class="required">*</span>
		</label>
		<div>
			<input type="text" name="fone-celular" id="fone-celular" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-4">
		<label for="fone-3">Telefone 3 <span class="required">*</span>
		</label>
		<div>
			<input type="text" name="fone-3" id="fone-3" required
				class="form-control col-md-7 col-xs-12">
		</div>
	</div>
</div>