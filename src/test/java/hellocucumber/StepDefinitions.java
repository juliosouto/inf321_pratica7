package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }

}

class User {

    String firstName;
    String lastName;
    String country;
    String state;
    String email;
    String password;
    String repeatPassword;

    public User(String firstName, String lastName, String country,
                String state, String email, String password,
                String repeatPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.state = state;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    @Override
    public String toString() {
        return this.email.toLowerCase();
    }

}

class Login {
    static boolean verifiUsername(String username) {
        return "teste@123.com".equals(username);
    }

    static boolean verifiPassword(String password) {
        return "teste123".equals(password);
    }
}

public class StepDefinitions {

    private String today;

    private List<User> usuarios;

    private String actualAnswer;

    private Throwable throwable;

    private String operator;

    private String username;

    private Boolean formFill;

    //region Selenium
    private final WebDriver driverFirefox = new FirefoxDriver();
    //private final WebDriver driverChrome = new ChromeDriver();
    int pageLoadTime_ms = 5000;
    int reactTime_ms = 2000;
    //endregion


    //region Selenium Alterar Senha
    private String senhaConfirmacao;
    private final String resetSenha = "123456";
    private String password;

    private void reseta_senha() {
        try {
            driverFirefox.get("http://multibags.1dt.com.br/shop/customer/password.html");
            Thread.sleep(5000);
            WebElement currentPassword = driverFirefox.findElement(By.xpath("//*[@id=\"currentPassword\"]"));
            currentPassword.sendKeys(this.password);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void set_senha_atual() {
        try {
            WebElement currentPassword = driverFirefox.findElement(By.xpath("//*[@id=\"currentPassword\"]"));
            currentPassword.sendKeys(this.resetSenha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Então("Devo receber mensagem de erro {string}")
    public void devo_receber_mensagem_de_erro(String string) {
        System.out.println(string);
        WebElement notifyError = driverFirefox.findElement(By.xpath("//*[@id=\"formError\"]"));

        assertEquals(string, notifyError.getText());
    }

    private void entra_troca_senha_tela() {
        try {
            driverFirefox.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");
            Thread.sleep(2000);
            WebElement login = driverFirefox.findElement(By.name("signin_userName"));
            WebElement senha = driverFirefox.findElement(By.name("signin_password"));
            WebElement signBtn = driverFirefox.findElement(By.id("genericLogin-button"));
            login.sendKeys("test@test");
            senha.sendKeys("123456");
            signBtn.click();
            Thread.sleep(2000);
            WebElement changePassword = driverFirefox.findElement(
                    By.xpath("/html/body/div[3]/div/div/div[1]/div/ul/li[3]/a"));
            changePassword.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void registra_conta() {
        try {
            int pageLoadTime_ms = 5000;
            int reactTime_ms = 2000;
            driverFirefox.get("http://multibags.1dt.com.br/shop/customer/registration.html");
            Thread.sleep(pageLoadTime_ms);
            WebElement firstName = driverFirefox.findElement(By.name("billing.firstName"));
            WebElement lastName = driverFirefox.findElement(By.name("billing.lastName"));
            Select country = new Select(driverFirefox.findElement(By.name("billing.country")));
            WebElement stateProvince = driverFirefox.findElement(By.name("billing.stateProvince"));
            WebElement email = driverFirefox.findElement(By.name("emailAddress"));
            WebElement password = driverFirefox.findElement(By.name("password"));
            WebElement Repeapassword = driverFirefox.findElement(By.name("checkPassword"));
            WebElement CreateBtn = driverFirefox.findElement(By.cssSelector(".btn.btn-default.login-btn"));
            // preenche as infos
            firstName.sendKeys("daniel");
            lastName.sendKeys("sobrenome");
            country.selectByVisibleText("Peru");
            stateProvince.sendKeys("estado");
            email.sendKeys("email_valido@example.com");
            password.sendKeys("dadada");
            Repeapassword.sendKeys("dada");
            Thread.sleep(reactTime_ms);
            // clicka em criar conta
            CreateBtn.click();
            Thread.sleep(pageLoadTime_ms);
            WebElement errorMsgs = driverFirefox.findElement(By.id("customer.errors"));
            System.out.println("msgs de errors: \n\n");
            System.out.println(errorMsgs.getText());
            System.out.println("-------------------------------------------------");
            Thread.sleep(4*reactTime_ms); // tirar depois, to usando somente pra depurrar
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Dado("senha é escrita")
    public void senha_é_escrita() {
        entra_troca_senha_tela();
    }

    @Quando("a {string} menor que 6 caracteres")
    public void senha_menor_oito(String string) {
        System.out.println("resultado = " + string + " menor 6");
        this.password = string;
        assertTrue(string.length() < 6);

        WebElement currentPass = driverFirefox.findElement(By.xpath("//*[@id=\"currentPassword\"]"));
        WebElement newPass = driverFirefox.findElement(By.xpath("//*[@id=\"password\"]"));
        currentPass.sendKeys("12345");
        newPass.sendKeys(this.password);
    }

    @E("senha de confirmação {string} batem")
    public void senha_confirmacao_bate(String string) {
        this.senhaConfirmacao = string;
        assertEquals(this.password, this.senhaConfirmacao);
        WebElement confirmPass = driverFirefox.findElement(By.xpath("//*[@id=\"checkPassword\"]"));
        confirmPass.sendKeys(this.senhaConfirmacao);
    }

    @Dado("a senha nova não é escrita")
    public void a_senha_nova_não_é_escrita() {
        entra_troca_senha_tela();
    }

    @Quando("a {string} nova for vazia")
    public void senha_e_vazia(String string) {
        try {
            System.out.println("resultado = " + string);
            assertTrue(string.isEmpty());

            WebElement currentPass = driverFirefox.findElement(By.xpath("//*[@id=\"currentPassword\"]"));
            currentPass.sendKeys("123456");
            WebElement newPass = driverFirefox.findElement(By.xpath("//*[@id=\"password\"]"));
            newPass.sendKeys("");
            Thread.sleep(1000);
            WebElement confirmPass = driverFirefox.findElement(By.xpath("//*[@id=\"checkPassword\"]"));
            confirmPass.sendKeys(string);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Quando("a {string} nova não bate com a confirmação")
    public void senha_nao_bate_confirmacao(String string) {
        System.out.println("resultado = " + string + " - " + this.senhaConfirmacao);
        this.password = string;
        this.senhaConfirmacao = "";
        assertNotEquals(this.password, this.senhaConfirmacao);

        set_senha_atual();
        WebElement newPass = driverFirefox.findElement(By.xpath("//*[@id=\"password\"]"));
        newPass.sendKeys(string);
    }

    @Dado("que as duas senhas não batem")
    public void que_as_duas_senhas_não_batem() {
        System.out.println("senhas diferentes");
        entra_troca_senha_tela();
    }

    @E("senha de confirmação {string} não batem")
    public void senha_confirmacao_nao_bate(String string) {
        this.senhaConfirmacao = string;
        assertNotEquals(this.password, this.senhaConfirmacao);

        WebElement confirmPass = driverFirefox.findElement(By.xpath("//*[@id=\"checkPassword\"]"));
        confirmPass.sendKeys(string);
    }

    @After()
    public void closeBrowser() {
        driverFirefox.quit();
    }
    //endregion

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

    /***
     * Código da documentação acima:
     * https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java
     **********/

    @Given("Dado que {string} acessou o site da multibags e entrou em Register")
    public void inicio_register(String string) {
        try {
            driverFirefox.get("http://multibags.1dt.com.br/shop/customer/registration.html");
            Thread.sleep(pageLoadTime_ms);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Given("Preenchi o form de cadastro com {string}, {string}, {string}, {string}, {string}, {string} e {string}")
    public void preenchiOFormDeCadastroComE(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws InterruptedException {
        WebElement firstName = driverFirefox.findElement(By.name("billing.firstName"));
        WebElement lastName = driverFirefox.findElement(By.name("billing.lastName"));
        Select country = new Select(driverFirefox.findElement(By.name("billing.country")));
        WebElement stateProvince = driverFirefox.findElement(By.name("billing.stateProvince"));
        WebElement email = driverFirefox.findElement(By.name("emailAddress"));
        WebElement password = driverFirefox.findElement(By.name("password"));
        WebElement Repeapassword = driverFirefox.findElement(By.name("checkPassword"));
        firstName.sendKeys(arg0);
        lastName.sendKeys(arg1);
        country.selectByVisibleText(arg2);
        stateProvince.sendKeys(arg3);
        String email_final;
        if(arg4.equals("email_valido")){
            String email_prefix = "email+";
            String email_domain = "@bol.com.br";
            Random rand = new Random();
            int randnum = rand.nextInt(1000000);
            email_final = email_prefix + Integer.toString(randnum) + email_domain;
            System.out.println(arg4);
            System.out.println(email_final);
            System.out.println("------------------");
            Thread.sleep(reactTime_ms);
        }
        else if(arg4.equals("blank")){
            email_final = "";
        }
        else{
            email_final = "email_invalido";
        }
        email.sendKeys(email_final);
        password.sendKeys(arg5);
        Repeapassword.sendKeys(arg6);
        Thread.sleep(reactTime_ms);
    }

    @When("submeto as infos de cadastro, pressionando o botao {string}")
    public void submetoAsInfosDeCadastroPressionandoOBotao(String arg0) throws InterruptedException {
        WebElement CreateBtn = driverFirefox.findElement(By.cssSelector(".btn.btn-default.login-btn"));
        CreateBtn.click();
        Thread.sleep(pageLoadTime_ms);
    }

    @Then("o form de cadastro deve ser gerar a msg {string}")
    public void oFormDeCadastroDeveSerGerarAMsg(String arg0) throws InterruptedException {
        WebElement errorMsgs = driverFirefox.findElement(By.id("customer.errors"));
        System.out.println("msgs de errors: \n\n");
        String msgs_erro_obtida = errorMsgs.getText();
        System.out.println(msgs_erro_obtida);
        System.out.println("\n\nesperado: "+ arg0);
        System.out.println("-------------------------------------------------");
        Thread.sleep(4*reactTime_ms); // tirar depois, to usando somente pra depurrar
        assertEquals(msgs_erro_obtida, arg0);
    }

    @Dado("que {string} possui uma conta com senha fraca.")
    public void que_possui_uma_conta_com_senha_fraca(String string) {
        System.out.println("name =" + string);
    }



//    @Given("Minha infos são:")
//    public void minha_infos_são(String step) {
//        // TODO
//        System.out.println("Write code here that turns the phrase above into concrete actions");
//        System.out.println("throw new io.cucumber.java.PendingException();");
////        int index = -1;
////        User userDaniel = new User(fN, lN, country, state, email, pass, rPass);
////        if(this.usuarios == null)
////            this.usuarios = new ArrayList<>();
////
////        this.usuarios.add(userDaniel);
////        index = usuarios.size() -1;
////
////        User fetchedUser = usuarios.get(index);
//
//       /* TODO Plugin do selenium deve tentar recuperar o máximo de informações
//        * possivel do multibags.
//        */
//
//        /* TODO Criar um assertEquals para cara informacao recuperada
//         * ex: asserEquals("teste_t@123.com", fetchedUser.email)
//         * firstName = Teste
//         * lastName = Daniel
//         * country = Brazil
//         * state = AAA
//         * email = teste_t@123.com
//         * password = teste123
//         * rPassword = teste123 (optional)
//         */
//    }

    @Given("Minha infos são:")
    public void minha_infos_são(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        // Write code here that turns the phrase above into concrete actions
        // TODO
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

    @Então("a aplicacao deve exibir uma mensagem de credenciais invalidas")
    public void aAplicacaoDeveExibirUmaMensagemDeCredenciaisInvalidas() {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @E("o valor do {string} deve ser invalido")
    public void oValorDoDeveSerInvalido(String arg0) {
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

    @E("o {string} deve ser logado")
    public void oDeveSerLogado(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }

    @Quando("Daniel tenta logar com {string} e com {string}")
    public void daniel_tenta_logar_com_e_com(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        // TODO
        System.out.println("Write code here that turns the phrase above into concrete actions");
        System.out.println("throw new io.cucumber.java.PendingException();");
    }
}
