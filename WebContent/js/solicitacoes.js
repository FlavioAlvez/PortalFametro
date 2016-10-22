function tipoAtendimento(valor) {
	var taCdg = document.getElementById("tipo-atendimento-cdg");

	var taDescricao = document.getElementById("tipo-atendimento-descricao");

	taCdg.value = taDescricao.value;

	var av = document.getElementById("divAv");
	var dis = document.getElementById("divDis");

	switch (taCdg.value) {
	case "1":
		av.style.display = "none";
		dis.style.display = "";
		document.getElementById("disciplina").class = "select2_multiple form-control col-md-6 col-sm-6 col-xs-12";
		break;
	case "2":
		av.style.display = "";
		dis.style.display = "";
		break;
	case "3":
		av.style.display = "none";
		dis.style.display = "";
		break;
	case "4":
		av.style.display = "none";
		dis.style.display = "none";
		break;
	default:
		av.style.display = "none";
		dis.style.display = "";
		break;
	}
}

function matriculaAluno(valor) {
	var mat = document.getElementById("matricula");

	var nome = document.getElementById("nome");

	mat.value = nome.value;
}