#language: pt
@ConsultaOportunidades
Funcionalidade: Teste basico no Vtiger
  Eu como um usuario 
  Quero acessar o sistema
  Para consultar Oportunidades

  Contexto: Realiza login no sistema
    Dado que acesso o sistema
    Entao realizo login

  Cenario: @ct01_ConsultaOportunidades
    Dado que estou na tela inicial
    E no menu seleciono vendas > oportunidades
    Entao consulto o nome da Oportunidade desejada