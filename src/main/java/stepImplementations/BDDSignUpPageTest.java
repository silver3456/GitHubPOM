package stepImplementations;

import core.MainPage;
import core.SignUpPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BDDSignUpPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private SignUpPage signUpPage;

    @Before
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        signUpPage = new SignUpPage(driver);

    }

    @Given("^user is on main page$")
    public void user_is_on_main_page() {
        System.out.println("User is on the main page");
        driver.get("https://github.com");

    }

    @When("^user enters new username (.*)$")
    public void user_enters_username(String username) {
        mainPage.typeUserName(username);
    }

    @And("^user enters new email (.*)$")
    public void user_enters_email(String email) {
        mainPage.typeUserName(email);
    }

    @And("^user enters new password (.*)$")
    public void user_enters_password(String password) {
        mainPage.typeUserName(password);
        mainPage.clickSignUpFormButton();
    }

    @Then("^user sees welcome message$")
    public void user_sees_welcome_message() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }
}
