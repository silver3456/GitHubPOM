package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text() = 'Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()= 'Sign up']")
    private WebElement signUpButton;

    @FindBy(xpath = ".//*[@id='user[login]']")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id='user[email]']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='user[password]']")
    private WebElement passwordField;

    @FindBy(xpath = "//p[contains(@class, 'form-control-note mb-0 text-center')]\" +\n" +
            "            \"/preceding::button[text() ='Sign up for GitHub']")
    private WebElement signUpFormButton;


    //private By signInButton = By.xpath("//a[text() = 'Sign in']");
    // private By signUpButton = By.xpath("//a[text()= 'Sign up']");
    //private By userNameField = By.xpath(".//*[@id='user[login]']");
    // private By emailField = By.xpath("//*[@id='user[email]']");
    //private By passwordField = By.xpath("//*[@id='user[password]']");
    //private By signUpFormButton = By.xpath("//p[contains(@class, 'form-control-note mb-0 text-center')]" +
    //        "/preceding::button[text() ='Sign up for GitHub']");

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
         signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }

}
