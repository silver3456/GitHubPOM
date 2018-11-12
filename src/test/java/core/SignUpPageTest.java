package core;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;



    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join/");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassTest(){
        SignUpPage newSignUp = signUpPage.typePassword("ffd");
        String error = newSignUp.getPasswordErrorText();
        Assert.assertEquals("Make sure it's more than 15 characters, or at least 8 characters, and including a number.", error);
    }

    @Test
    public void signUpReservedUsernameTest() throws InterruptedException {
        SignUpPage sp = signUpPage.typeUserName("username");
        Thread.sleep(1000);
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username name 'username' is a reserved word", error);
    }

    @Test
    public void signUpTakenUsernameTest() throws InterruptedException {
        SignUpPage sp = signUpPage.typeUserName("ff");
        Thread.sleep(1000);
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }

    @Test
    public void getHeadingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
