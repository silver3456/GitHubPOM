package core;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    public MainPageTest() {
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test

    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("fdfsdf", "fsdf@mail.ru", "ffa33f");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test

    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "fdsfsdf7@mail.ru", "sldfj&");
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test

    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("afpp", "@mail.ru", "sleedfj&");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

