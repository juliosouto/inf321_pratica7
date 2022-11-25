#language:pt
#encoding:utf-8

# Cadastro de nova conta
# Dado, Quando, Então, E, Mas (Passos)


@cadastroDeNovaConta
Funcionalidade: Cadastro de nova conta
  Como usuário
  "Pedro" deseja cadastrar uma nova conta
  Para que "Pedro" possa efetuar comprar no site

  Contexto:
    Dado que "Pedro" acessou o site da multibags e entrou em Register
    E preencheu o formulário para realizar o cadastrado

  @incorretoName @incorretoLastName @incorretoCountry @incorretoStateProvice @incorretoEmailAddress @incorretoPassword @incorretoRepeatPassword
  Esquema do Cenário: Inserir múltiplos dados
    Quando é inserido "<firstName>" com "<lastName>" com "<country>" com "<stateProvince>" com "<emailAddress>" com "<password>" com "<repeatPassword>"
    Então O resultado será "<resultado>"
    E A resposta será "<resposta>"
    Exemplos:
      | firstName | lastName | country | stateProvince | emailAddress                | password | repeatPassword | resultado | resposta               |
      | Leonardo  | Moscardo | Brasil  | SP            | leonardo.moscardo@gmail.com | A123     | A123           | Sem erro  | Cadastrado com sucesso |
