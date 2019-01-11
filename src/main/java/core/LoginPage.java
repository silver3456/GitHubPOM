package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By loginField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//input[@type ='submit']");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By error = By.xpath("//div[@id ='js-flash-container']//div[@class = 'container']");
    private By createAccLink = By.xpath("//a[text() = 'Create an account']");
    private By searchRepoBox = By.xpath(".//*[contains(@aria-label, 'Search or jump to')]/child::*");
    private By profileImage = By.xpath("//*[@class = 'dropdown-caret']");
    private By yourProfileLink = By.xpath("//a[text() = 'Your profile']");
    private By editProfileButton = By.xpath("//*[@class = 'octicon octicon-pencil']");
    private By uploadPicButton = By.xpath("//input[@type = 'file']");
    private By setProfilePicButton = By.xpath(".//*[contains(@class, 'btn btn-primary btn-block')]");

    public LoginPage typeUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithValidCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

    public Boolean getLoginVerificationLocator() {
        return driver.findElement(searchRepoBox).isDisplayed();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void changeAvatar(String picture) throws InterruptedException {
        driver.findElement(profileImage).click();
        driver.findElement(yourProfileLink).click();
        driver.findElement(editProfileButton).click();
        driver.findElement(uploadPicButton).sendKeys(picture);

        Thread.sleep(20000);
        driver.findElement(setProfilePicButton).click();
    }
}
