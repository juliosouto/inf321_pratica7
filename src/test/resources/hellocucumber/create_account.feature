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
    # obs o email eh tratado depois, esta assim pra gerar um email unico cada vez, pra nao dar o erro de que a conta ja existe
    Examples:
      | FirstName  | Lastname  | Country | State | Email         | Password | Repeatpassword  | mensagem                                             |
      | nome       | sobrenome | Brazil  | sp    | email_valido  | dadada   | dada            | password.notequal\nBoth password must match          |
      |            | sobrenome | Brazil  | sp    | email_valido  | dadada   | dadada          | Field required                                       |
      | nome       |           | Brazil  | sp    | email_valido  | dadada   | dadada          | Field required                                       |
      | nome       | sobrenome | Brazil  | sp    | email_valido  |          | dadada          | password.notequal\n{registration.password.not.empty} |
      | nome       | sobrenome | Brazil  | sp    | blank         | dadada   | dadada          | Email address is required\nUser name is required     |
      | nome       | sobrenome | Brazil  | sp    | not_valid     | dadada   | dadada          | Email address is invalid                             |
      | nome       | sobrenome | Brazil  | sp    | email_valido  | dadada   |                 | password.notequal                                    |


  @sucesso
  Scenario Outline: Todas infos invalidas ao submeter cadastro
    Given Preenchi o form de cadastro com "<FirstName>", "<Lastname>", "<Country>", "<State>", "<Email>", "<Password>" e "<Repeatpassword>"
    When submeto as infos de cadastro, pressionando o botao "create account"
    Then o form de cadastro deve me redirecionar para "minha conta"
    Examples:
      | FirstName  | Lastname  | Country | State | Email         | Password | Repeatpassword  |
      | pedro      | bial      | Brazil  | rj    | email_valido  | dadada   | dadada          |

  @falha
  Scenario Outline: Email previamente cadastrado
    Given Preenchi o form de cadastro com "<FirstName>", "<Lastname>", "<Country>", "<State>", "<Email>", "<Password>" e "<Repeatpassword>"
    When submeto as infos de cadastro, pressionando o botao "create account"
    Then o form de cadastro deve ser gerar a msg "<mensagem>"
    Examples:
      | FirstName  | Lastname  | Country | State | Email         | Password | Repeatpassword  | mensagem                                           |
      | nome       | sobrenome | Brazil  | sp    | fixed         | dadada   | dadada          | User with user name already exists for this store. |
