<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- sidebar menu -->
<c:choose>
	<c:when
		test="${tipoUsuarioLogado.getNome().equalsIgnoreCase('Secretario') }">
		<%@ include file="menu-lateral/secretario.jsp"%>
	</c:when>
	<c:when
		test="${tipoUsuarioLogado.getNome().equalsIgnoreCase('Professor') }">
		<%@ include file="menu-lateral/professor.jsp"%>
	</c:when>
	<c:when
		test="${tipoUsuarioLogado.getNome().equalsIgnoreCase('Aluno') }">
		<%@ include file="menu-lateral/aluno.jsp"%>
	</c:when>
</c:choose>
<!-- /sidebar menu -->