function campoDisciplina(valor){
	if(valor.includes("DISCIPLINA") == true){
		document.getElementById("campo_disciplina").disabled = false;
	} else {
		/*var apagaCampo = document.getElementById("campo_disciplina");
		
	    while (apagaCampo.length) {
	    	apagaCampo.remove(0);
	    } */
		document.getElementById("campo_disciplina").selectedIndex = 0;
		document.getElementById("campo_disciplina").disabled = true;
	}
}
	
