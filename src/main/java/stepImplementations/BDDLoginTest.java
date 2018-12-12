package stepImplementations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class BDDLoginTest {

    WebDriver driver;

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        System.out.println("User is on the login page");

    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("User enteres username and password");

    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        System.out.println("User gets confirmation");

    }
}
