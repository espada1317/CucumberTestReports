package Test;

import static com.codeborne.selenide.Selenide.$;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import steps.SearchQuestion;

public class SearchTest {
	@Test
	public void userSearch()
	{
		LoginTest login = new LoginTest();
		login.Login();
		$(By.xpath("//*[@id=\"nav-users\"]/div/div")).click();
		SelenideElement username = $(By.xpath("//*[@id=\"userfilter\"]"));
		username.val("Ion Str");
		$(By.xpath("//a[text()='" + "Ion Str"+ "']")).click();
		String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
		Assert.assertEquals("https://stackoverflow.com/users/12607340/ion-str",currentUrl);
	}

	@Test
	public void postSearch()
	{
		LoginTest login = new LoginTest();
		login.Login();
		SelenideElement question = $(By.xpath("//*[@id=\"search\"]/div/input"));
		question.val("Java").pressEnter();
		SearchQuestion obj = new SearchQuestion();
		obj.checkMore("1");
	}
}
