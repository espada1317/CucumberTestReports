package Test;

import Config.UserConfig;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Test
    public void Login(){
        open("https://stackoverflow.com/");
        $(By.xpath("//a[text()='Log in']")).click();
        SelenideElement emailinput = $(By.xpath("//*[@id=\"email\"]"));
        SelenideElement passwordinput = $(By.xpath("//*[@id=\"password\"]"));
        emailinput.val(UserConfig.userName);
        passwordinput.val(UserConfig.password);
        $(By.xpath("//*[@id=\"submit-button\"]")).click();
        $(By.xpath("/html/body/header/div/ol[2]/li[2]/a/div[1]/img")).shouldBe(Condition.visible);
    }

    @Test
    public void LoginFailed(){
        open("https://stackoverflow.com/");
        $(By.xpath("//a[text()='Log in']")).click();
        SelenideElement emailinput = $(By.xpath("//*[@id=\"email\"]"));
        SelenideElement passwordinput = $(By.xpath("//*[@id=\"password\"]"));
        emailinput.val(UserConfig.userName+1);
        passwordinput.val(UserConfig.password);
        $(By.xpath("//*[@id=\"submit-button\"]")).click();
        $(By.xpath("/html/body/header/div/ol[2]/li[2]/a/div[1]/img")).shouldNot(Condition.exist);
    }
}
