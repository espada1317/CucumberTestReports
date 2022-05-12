package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModifyDataSteps {

    @And("I click user image")
    public void iClickUserImage() {
        $(By.xpath("/html/body/header/div/ol[2]/li[2]/a/div[1]/img")).click();
    }

    @And("I click Edit profile link")
    public void iClickEditProfileLink() {
        $(By.xpath("//*[@id=\"content\"]/div[3]/nav/ul/li[2]/a")).click();
    }

    @And("I change {string} to {string}")
    public void iChangeInputValue(String arg0, String arg1)
    {
        SelenideElement displayNameInput = $(By.xpath("//*[@id=\"" + arg0 + "\"]"));
        displayNameInput.val(arg1);
    }

    @And("I check if I get message error")
    public void iCheckIfIGetMessageError() {
        $(By.xpath("//*[@id=\"user-edit-form\"]/div[7]")).shouldBe(Condition.exist);
        LogInSteps logInSteps = new LogInSteps();
        logInSteps.iSubmitButton("Save profile");
    }

    @Then("I should get {string} informative message")
    public void iShouldGetInformativeMessage(String arg0) {
        Selenide.sleep(2000);
        $(By.xpath("//p[text()='" + arg0 + "']")).shouldBe(Condition.exist);
    }
}