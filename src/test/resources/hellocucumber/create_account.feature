#encoding:utf-8

Feature: Cadastro de nova conta
  Como usuário
  "Pedro" deseja cadastrar uma nova conta
  Para que "Pedro" possa efetuar compras no site e recebê-las no endereço cdastrado

  Background:
    Given Dado que "Pedro" acessou o site da multibags e entrou em Register
    And preencheu o formulário para realizar o cadastrado


  @falha
  Scenario Outline: infos invalidas
    Given digitei <First name> no campo "First name"
    And digitei <Last name> no campo "Last name"
    And digitei <Country> no campo "Country"
    And digitei <State> no campo "State"
    And digitei <Email> no campo "Email"
    And digitei <Password> no campo "Password"
    And digitei <Repeat password> no campo "repeat password"
    When digito as infos, sem precionar o botao "create account"
    Then deve ser gerada a msg <mensagem>

    Examples: # essas msgs aparecem sem precisar pressionar o create account
      | First name | Last name | Country | State | Email             | Password | Repeat password | mensagem                              |
      |            | sobrenome | Brazil  | sp    | email@bol.com     | dadada   | dadada          | First name is required                |
      | nome       |           | Brazil  | sp    | email@bol.com     | dadada   | dadada          | Last name is required                 |
      | nome       | sobrenome | Brazil  |       | email@bol.com     | dadada   | dadada          | State Province is required            |
      | nome       | sobrenome | Brazil  | sp    |                   | dadada   | dadada          | Email address is required             |
      | nome       | sobrenome | Brazil  | sp    | email_sem_dominio | dadada   | dadada          | Please provide a valid email address. |
      | nome       | sobrenome | Brazil  | sp    | email@bol.com     |          |                 | A password is required                |
      | nome       | sobrenome | Brazil  | sp    | email@bol.com     | dadada   |                 | Repeated password is required         |
      | nome       | sobrenome | Brazil  | sp    | email@bol.com     | dadada   | dada            | Both password must match              |

  @falha
  Scenario Outline: infos invalidas ao submeter cadastro
    Given digitei <First name> no campo "First name"
    And digitei <Last name> no campo "Last name"
    And digitei <Country> no campo "Country"
    And digitei <State> no campo "State"
    And digitei <Email> no campo "Email"
    And digitei <Password> no campo "Password"
    And digitei <Repeat password> no campo "repeat password"
    When preciono o botao "create account"
    Then deve ser gerada a msg <mensagem>

    Examples:
      | First name | Last name | Country | State | Email         | Password | Repeat password | mensagem                                        |
      |            | sobrenome | Brazil  | sp    | email@bol.com | dadada   | dadada          | Field required                                  |
      | nome       |           | Brazil  | sp    | email@bol.com | dadada   | dadada          | Field required                                  |
      | nome       | sobrenome | Brazil  | sp    | email@bol.com |          | dadada          | User name is required Email address is required |
      | nome       | sobrenome | Brazil  | sp    | email@bol.com | dadada   |                 | password.notequal                               |
      | nome       | sobrenome | Brazil  | sp    | email@bol.com | dadada   | dada            | password.notequal                               |


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
    Then mensagem "User with user name already exists for this store"
