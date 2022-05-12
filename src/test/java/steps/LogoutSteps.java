package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogoutSteps {
    @And("I click site switcher button")
    public void iClickSiteSwitcherButton(){
        $(By.xpath("/html/body/header/div/ol[2]/li[6]/a")).click();
    }

    @And("I click log out button")
    public void iClickLogOutAnchorButton() {
        $(By.xpath("/html/body/header/div/ol[2]/li[7]/div/div[2]/ul/li[1]/div[2]/a[3]")).click();
    }

    @Then("I check if {string} and {string} button are present")
    public void iCheckifbuttonsarepresent(String arg0, String arg1){
        $(By.xpath("//a[text()='" + arg0 + "']")).shouldBe(Condition.exist);
        $(By.xpath("//a[text()='" + arg1 + "']")).shouldBe(Condition.exist);
    }
}
