package steps;

import static com.codeborne.selenide.Selenide.$;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.SelenideElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchQuestion {
	
	@And("I search {string} in seacrh field")
	public void searchText(String s)
	{
		SelenideElement question = $(By.xpath("//*[@id=\"search\"]/div/input"));
		question.val(s).pressEnter();
	}
	
	@Then("I check number {string} of results")
	public void checkMore(String s)
	{
		SelenideElement number = $(By.xpath("//*[@id=\"mainbar\"]/div[4]/div/div[1]"));
		String s1 = number.getText();
		s1=s1.trim();
		s1=s1.replaceAll(",", "");
		int desired = Integer.parseInt(s);
		int have = Integer.parseInt(s1.split("")[0]);
		Assert.assertTrue(desired <= have);
	}
}
