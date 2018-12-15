package stepImplementations;

import core.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class BDDLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        System.out.println("User is on the login page");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login/");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("User enters username and password");

        loginPage = new LoginPage(driver);
        loginPage.loginWithValidCreds("alex.malkinn@gmail.com", "Silver@3456");
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        System.out.println("User gets confirmation");
        Assert.assertTrue(loginPage.getLoginVerificationLocator());
        driver.quit();
    }
}
