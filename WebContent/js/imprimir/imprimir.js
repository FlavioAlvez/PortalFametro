function imprimir(form_pesquisa){
   var conteudo = document.getElementById(form_pesquisa).innerHTML;
   tela_impressao = window.open('about:blank');
   tela_impressao.document.write(conteudo);
   tela_impressao.window.print();
   tela_impressao.window.close();
}
