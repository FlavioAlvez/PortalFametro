<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="table-responsive">
	<table class="table table-striped jambo_table bulk_action">
		<thead>
			<tr class="headings">
				<th class="column-title">Código</th>
				<th class="column-title">Grupo de Atendimento</th>
				<th class="bulk-actions" colspan="7"><a class="antoo"
					style="color: #fff; font-weight: 500;">Bulk Actions ( <span
						class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i>
				</a></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="grupoAtendimento"
				items="${bancoGrupoAtendimento.getBanco() }" varStatus="status">
				<tr
					class="${status.index mod 2 == 0 ? 'even' : 'odd'} pointer cursor-handle"
					onClick="location.href = 'cadastrar-solicitacao.jsp?grupo=${grupoAtendimento.getCodigo() }'">
					<td class=" ">${grupoAtendimento.getCodigo() }</td>
					<td class=" ">${grupoAtendimento.getGrupo() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
