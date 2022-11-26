package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class StepDefinitions {

    private String senhaConfirmacao;

    private String today;

    private String actualAnswer;

    private Throwable throwable;

    private String operator;

    private Boolean formFill;

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    /*** Código da documentação acima: https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java **********/

    @Given("Dado que {string} acessou o site da multibags e entrou em Register")
    public void dado_que_acessou_o_site_da_multibags_e_entrou_em_register(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("preencheu o formulário para realizar o cadastrado")
    public void preencheu_o_formulário_para_realizar_o_cadastrado() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("é inserido {string} com {string} com {string} com {string} com {string} com {string} com {string}")
    public void é_inserido_com_com_com_com_com_com(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Então("O resultado será {string}")
    public void o_resultado_será(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Então("A resposta será {string}")
    public void a_resposta_será(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("que {string} acessou o site da multibags e entrou em Register")
    public void queAcessouOSiteDaMultibagsEEntrouEmRegister(final String name) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("que {string} possui uma conta com senha fraca.")
    public void que_possui_uma_conta_com_senha_fraca(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("que as duas senhas não batem")
    public void que_as_duas_senhas_não_batem() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("a senha nova não bate com a confirmação")
    public void a_senha_nova_não_bate_com_a_confirmação() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Então("Devo receber mensagem de erro {string}")
    public void devo_receber_mensagem_de_erro(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("Estou em http:\\/\\/multibags.1dt.com.br\\/shop\\/customer\\/registration.html")
    public void estou_em_http_multibags_1dt_com_br_shop_customer_registration_html() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei nome no campo {string}")
    public void digitei_nome_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei sobrenome no campo {string}")
    public void digitei_sobrenome_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei Brazil no campo {string}")
    public void digitei_brazil_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei sp no campo {string}")
    public void digitei_sp_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei email@bol.com no campo {string}")
    public void digitei_email_bol_com_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei dadada no campo {string}")
    public void digitei_dadada_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei dada no campo {string}")
    public void digitei_dada_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @When("preciono o botao {string}")
    public void preciono_o_botao(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg password.notequal")
    public void deve_ser_gerada_a_msg_password_notequal() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("senha é escrita")
    public void senha_é_escrita() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("a senha menor que {int} caracteres")
    public void a_senha_menor_que_caracteres(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("a senha nova não é escrita")
    public void a_senha_nova_não_é_escrita() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("a senha nova for vazia")
    public void a_senha_nova_for_vazia() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("quando a senha atual é vazia")
    public void quando_a_senha_atual_é_vazia() {
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("a senha atual não for escrita")
    public void a_senha_atual_não_for_escrita() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Então("Devo recebe mensagem de erro {string}")
    public void devo_recebe_mensagem_de_erro(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei  no campo {string}")
    public void digitei_no_campo(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg User name is required Email address is required")
    public void deve_ser_gerada_a_msg_user_name_is_required_email_address_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg Field required")
    public void deve_ser_gerada_a_msg_field_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("Minha infos são:")
    public void minha_infos_são(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @When("aperto botão {string}")
    public void aperto_botão(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("devo ser redirecionado para {string}")
    public void devo_ser_redirecionado_para(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("usuario ja esta previamente criado")
    public void usuario_ja_esta_previamente_criado() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("mensagem {string}")
    public void mensagem(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @When("digito as infos, sem precionar o botao {string}")
    public void digito_as_infos_sem_precionar_o_botao(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg Both password must match")
    public void deve_ser_gerada_a_msg_both_password_must_match() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Given("digitei email_sem_dominio no campo {string}")
    public void digitei_email_sem_dominio_no_campo(String string) {
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg Please provide a valid email address.")
    public void deve_ser_gerada_a_msg_please_provide_a_valid_email_address() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg Repeated password is required")
    public void deve_ser_gerada_a_msg_repeated_password_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg A password is required")
    public void deve_ser_gerada_a_msg_a_password_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg Email address is required")
    public void deve_ser_gerada_a_msg_email_address_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg State Province is required")
    public void deve_ser_gerada_a_msg_state_province_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg Last name is required")
    public void deve_ser_gerada_a_msg_last_name_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Then("deve ser gerada a msg First name is required")
    public void deve_ser_gerada_a_msg_first_name_is_required() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @E("senha de confirmação {string} batem")
    public void senha_confirmacao_bate(String string) {
        this.formFill = true;
        this.senhaConfirmacao = string;
    }

    @E("senha de confirmação {string} não batem")
    public void senha_confirmacao_nao_bate(String string) {
        this.formFill = true;
        this.senhaConfirmacao = string;
    }

    @Quando("a {string} menor que 8 caracteres")
    public void senha_menor_oito(String string) {
        System.out.println("resultado = " + string + " " + this.senhaConfirmacao);
    }

    @Quando("a {string} nova for vazia")
    public void senha_e_vazia(String string) {
        System.out.println("resultado = " + string + " " + this.senhaConfirmacao);
    }

    @Quando("a {string} nova não bate com a confirmação")
    public void senha_nao_bate_confirmacao(String string) {
        System.out.println("resultado = " + string + " " + this.senhaConfirmacao);
    }

    @Dado("que {string} está cadastrado na aplicação")
    public void que_está_cadastrado_na_aplicação(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Dado("que ele acessou o caminho My Account -> Sign In")
    public void que_ele_acessou_o_caminho_my_account_sign_in() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("João tenta logar com {string} e com {string}")
    public void joão_tenta_logar_com_e_com(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Então("a aplicacao deve receber uma mensagem de credenciais invalidas")
    public void a_aplicacao_deve_receber_uma_mensagem_de_credenciais_invalidas() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("Joao digitar corretamente as credenciais {string} e {string}:")
    public void joao_digitar_corretamente_as_credenciais_e(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }
    @Então("a aplicação deve exibir corretamente o {string} e carrinho conforme ultimo estado")
    public void a_aplicação_deve_exibir_corretamente_o_e_carrinho_conforme_ultimo_estado(String string) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

}
