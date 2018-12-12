package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCreds() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCreds() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("fdsf", "fdsf");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithCorrectCreds() {
        loginPage.loginWithValidCreds("alex.malkinn@gmail.com", "Silver@3456");
        Boolean searchBoxDisplayed = loginPage.getLoginVerificationLocator();
        Assert.assertTrue("Expected result:", searchBoxDisplayed);

    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
