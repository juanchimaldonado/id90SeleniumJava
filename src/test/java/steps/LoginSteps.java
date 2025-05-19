package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.BasePage;
import org.testng.Assert;
import pages.components.TopBar;
import utils.ConfigReader;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        new BasePage().navigateTo(ConfigReader.get("base.url") + "login");
    }

    @When("I enter a valid company")
    public void insertValidCompany() {
        String companyName = ConfigReader.get("company.name");
        loginPage.insertCompany(companyName);
    }

    @When("I enter a valid user email")
    public void insertValidUserEmail() {
        String userEmail = ConfigReader.get("user.email");
        loginPage.insertEmail(userEmail);
    }

    @When("I enter a valid password")
    public void insertValidPassword() {
        String password = ConfigReader.get("password");
        loginPage.insertPassword(password);
    }

    @When("I enter the email {string}")
    public void insertEmail(String email) {
        loginPage.insertEmail(email);
    }

    @When("I enter the password {string}")
    public void insertPassword(String password) {
        loginPage.insertPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the User Icon in the top bar")
    public void iShouldSeeTheUserIcon() {
        TopBar topBar = new TopBar();
        Assert.assertTrue(topBar.isUserIconVisible(), "User icon is not visible");
    }

    @Then("I should see an invalid credentials alert")
    public void validateCredentialsAlertVisible() {
        Assert.assertTrue(loginPage.isCredentialsAlertDisplayed(),
                "The alert for invalid credentials is not visible");
    }

    @Then("The alert text should be {string}")
    public void validateCredentialsAlertText(String expectedText) {
        String actualText = loginPage.getCredentialsAlertText();
        Assert.assertEquals(actualText, expectedText, "Alert text does not match");
    }

    @Then("I should see the required company alert")
    public void validateCompanyAlertVisible() {
        Assert.assertTrue(loginPage.isCompanyRequiredMessageDisplayed(),
                "The alert for Company required is not visible"
                );
    }

    @Then("I should see the required email alert")
    public void validateEmailAlertVisible() {
        Assert.assertTrue(loginPage.isEmailRequiredMessageDisplayed(),
                "The alert for Email required is not visible"
                );
    }

    @Then("I should see the required password alert")
    public void validatePasswordAlertVisible() {
        Assert.assertTrue(loginPage.isPasswordRequiredMessageDisplayed(),
                "The alert for Password required is not visible"
                );
    }

}

