function tipoAtendimento(valor) {
	var taCdg = document.getElementById("tipo-atendimento-cdg");

	var taDescricao = document.getElementById("tipo-atendimento-descricao");

	taCdg.value = taDescricao.value;

	var av = document.getElementById("divAv");
	var dis = document.getElementById("divDis");

	switch (taCdg.value) {
	case "1":
		av.setAttribute("class", "escondido");
		dis.setAttribute("class", "form-group");
		break;
	case "2":
		av.setAttribute("class", "form-group");
		dis.setAttribute("class", "form-group");
		break;
	case "3":
		av.setAttribute("class", "escondido");
		dis.setAttribute("class", "form-group");
		break;
	case "4":
		av.setAttribute("class", "escondido");
		dis.setAttribute("class", "escondido");
		break;
	default:
		av.setAttribute("class", "escondido");
		dis.setAttribute("class", "form-group");
		break;
	}
}

function matriculaAluno(valor) {
	var mat = document.getElementById("matricula");

	var nome = document.getElementById("nome");

	mat.value = nome.value;
}

function carregaEscondidos(){
	av.setAttribute("class", "escondido");
	dis.setAttribute("class", "escondido");
}