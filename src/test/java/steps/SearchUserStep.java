package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchUserStep {
	
	@And("I click Users search")
	public void clickUserSearch()
	{
		$(By.xpath("//*[@id=\"nav-users\"]/div/div")).click();
	}
	
	@And("I type {string} in user filter")
	public void writeUserFilter(String s)
	{
		SelenideElement username = $(By.xpath("//*[@id=\"userfilter\"]"));
		username.val(s);
	}
	
	@Then("I see {string} page")
	public void iSee(String s)
	{
		String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
		Assert.assertEquals(s,currentUrl);
	}
}
