package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchCompanies {

    @And("I click Companies search")
    public void iClickCompaniesSearch() {
        $(By.xpath("//*[@id=\"nav-companies\"]/div/div")).click();
    }

    @And("I check if header is {string}")
    public void checkIfHeaderIs(String arg0) {
        SelenideElement header = $(By.xpath("//*[@id=\"company-page\"]/header/div[1]/div[2]/h1"));
        String headerText = header.getText();
        Assert.assertEquals(headerText, arg0);
    }

    @Then("I check follow button state and change to another")
    public void iCheckFollowButtonStateAndChangeToAnother() {
        String toFollow = "Follow";
        String toUnfollow = "Following";
        String modifiedState = "";

        SelenideElement button = $(By.xpath("//*[@id=\"company-page\"]/header/div[1]/div[2]/div/div/div[1]/form/button"));
        String currentState = button.getText();
        Selenide.sleep(1000);
        button.click();
        Selenide.sleep(4000);

        if( currentState.equals(toFollow) ) {
            modifiedState = button.getText();
            Assert.assertEquals(modifiedState, toUnfollow);
        } else if ( currentState.equals(toUnfollow) ) {
            modifiedState = button.getText();
            Assert.assertEquals(modifiedState, toFollow);
        }
    }
}