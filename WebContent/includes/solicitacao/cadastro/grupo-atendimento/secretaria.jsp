<div class="table-responsive">
	<table class="table table-striped jambo_table bulk_action">
		<thead>
			<tr class="headings">
				<th class="column-title">Código</th>
				<th class="column-title">Tipo de Atendimento</th>
				<th class="column-title">Grupo de Atendimento</th>
				<th class="bulk-actions" colspan="7"><a class="antoo"
					style="color: #fff; font-weight: 500;">Bulk Actions ( <span
						class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i>
				</a></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="tipoAtendimento"
				items="${bancoTipoAtendimento.getBanco() }" varStatus="status">
				<c:if test="${tipoAtendimento.getGrupo().getCodigo() eq param.grupoAtendimento }">
					<tr
						class="${status.index mod 2 == 0 ? 'even' : 'odd'} pointer cursor-handle"
						onClick="location.href = 'cadastro-solicitacao.jsp?grupo=${tipoAtendimento.getGrupo().getCodigo() }&tipo=${tipoAtendimento.getCodigo() }'">
						<td class=" ">${tipoAtendimento.getCodigo() }</td>
						<td class=" ">${tipoAtendimento.getTipo() }</td>
						<td class=" ">${tipoAtendimento.getGrupo().getCodigo() }&nbsp;-&nbsp;${tipoAtendimento.getGrupo().getGrupo() }</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</div>
