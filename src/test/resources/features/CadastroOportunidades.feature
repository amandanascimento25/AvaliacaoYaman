#language: pt
@CadastroOportunidades
Funcionalidade: Teste basico no Vtiger
  Eu como um usuario 
  Quero acessar o sistema
  Para realizar cadastro de oportunidades

  Contexto: Realiza login no sistema
    Dado que acesso o sistema
    Entao realizo login

  Cenario: @ct01_CadastroOportunidades
    Dado que estou na tela inicial
    E no menu seleciono vendas > oportunidades
    Quando clico em Adicionar Oportunidade
    Entao realizo o cadastro