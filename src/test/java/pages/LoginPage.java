package pages;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{

    // Locators
    private By companyInputField = By.xpath("//input[@id='airline']");
    private By companyOptions = By.xpath("//button[@role='option']");
    private By emailInputField = By.id("airline-email-3");
    private By passwordInputField = By.id("airline-password-3");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By credentialsAlert = By.xpath("//ngb-alert[@role='alert']");
    private By companyRequiredMessage = By.xpath("//div[contains(text(),'Company is required')]");
    private By emailRequiredMessage = By.xpath("//div[contains(text(),'Email or Employee Number is required')]");
    private By passwordRequiredMessage = By.xpath("//div[normalize-space()='Password is required']");

    // Methods
    public void insertCompany(String company) {
        write(companyInputField, company);
        findElementInList(companyOptions, company).click();
    }

    public void insertEmail(String email) {
        write(emailInputField, email);
    }

    public void insertPassword(String password) {
        write(passwordInputField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public Boolean isCredentialsAlertDisplayed() {
        return isElementVisible(credentialsAlert);
    }

    public String getCredentialsAlertText(){
        return getElementText(credentialsAlert);
    }

    public Boolean isCompanyRequiredMessageDisplayed() {
        return isElementVisible(companyRequiredMessage);
    }

    public Boolean isEmailRequiredMessageDisplayed() {
        return isElementVisible(emailRequiredMessage);
    }

    public Boolean isPasswordRequiredMessageDisplayed() {
        return isElementVisible(passwordRequiredMessage);
    }

}
