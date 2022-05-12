package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogInSteps {

    @After
    public void destroyDriver() {
        WebDriverRunner.getWebDriver().quit();
    }

    @Given("I open {string}")
    public void iOpenWebsite(String arg0) {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
        open(arg0);
    }

    @When("I click {string} button")
    public void iClickAnchorButton(String arg0) {
        $(By.xpath("//a[text()='" + arg0 + "']")).click();
    }

    @And("I write username {string} and password {string}")
    public void iWriteUsernameAndPassword(String arg0, String arg1) {
        SelenideElement emailInput = $(By.xpath("//*[@id=\"email\"]"));
        SelenideElement passwordInput = $(By.xpath("//*[@id=\"password\"]"));
        emailInput.val(arg0);
        passwordInput.val(arg1);
    }

    @And("I submit {string} button")
    public void iSubmitButton(String arg0) {
        Selenide.sleep(1000);
        $(By.xpath("//button[text()=\"" + arg0 + "\"]")).click();
        Selenide.sleep(1000);
    }

    @Then("I am logged to account")
    public void iAmLoggedToAccount() {
        $(By.xpath("/html/body/header/div/ol[2]/li[2]/a/div[1]/img")).shouldBe(Condition.visible);
    }

    @Then("I get error message")
    public void iGetErrorMessage() {
        $(By.xpath("//*[@id=\"login-form\"]/div[1]/p")).shouldBe(Condition.visible);
    }
}