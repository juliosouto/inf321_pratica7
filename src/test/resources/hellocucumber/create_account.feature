#encoding:utf-8

Feature: Cadastro de nova conta
  Como usuário
  "Pedro" deseja cadastrar uma nova conta
  Para que "Pedro" possa efetuar compras no site e recebê-las no endereço cdastrado

  Background:
    Given Dado que "Pedro" acessou o site da multibags e entrou em Register
    # And preencheu o formulário para realizar o cadastrado

  @falha
  Scenario Outline: infos invalidas ao submeter cadastro
    Given Preenchi o form de cadastro com "<FirstName>", "<Lastname>", "<Country>", "<State>", "<Email>", "<Password>" e "<Repeatpassword>"
    When submeto as infos de cadastro, pressionando o botao "create account"
    Then o form de cadastro deve ser gerar a msg "<mensagem>"
    # obs o email eh tratado depois, estou fazendo assim pra gerar um email unico cada vez, pra nao dar o erro de que a conta ja existe
    Examples:
      | FirstName  | Lastname  | Country | State | Email         | Password | Repeatpassword  | mensagem                                        |
      | nome       | sobrenome | Brazil  | sp    | email_valido  | dadada   | dada            | password.notequal\nBoth password must match     |
      |            | sobrenome | Brazil  | sp    | email_valido  | dadada   | dadada          | Field required                                  |
      | nome       |           | Brazil  | sp    | email_valido  | dadada   | dadada          | Field required                                  |
      | nome       | sobrenome | Brazil  | sp    | email_valido  |          | dadada          | User name is required Email address is required |
      | nome       | sobrenome | Brazil  | sp    | email_valido  | dadada   |                 | password.notequal                               |


  @sucesso
  Scenario: Todas infos validas
    Given Minha infos são:
      | First name | Last name | Country | State | Email            | Password | Repeat password |
      | Teste      | Daniel    | Brazil  | AAA   | teste_t@123.com  | teste123 | teste123        |
    When aperto botão "Create an account"
    Then devo ser redirecionado para "minha conta"

  @falha
  Scenario: Email previamente cadastrado
    Given usuario ja esta previamente criado
    When submeto as infos de cadastro, pressionando o botao "create account"
    Then o form de cadastro deve ser gerar a msg "User with user name already exists for this store"
