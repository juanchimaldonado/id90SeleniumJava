package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findAll(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void clickElement(By locator){
        find(locator).click();
    }

    public void write(By locator, String keysToSend){
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(By locator, String value){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(By locator, Integer index){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(By locator){
        Select dropdown = new Select(find(locator));
        
        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(By locator) {
        Select dropdown = new Select(find(locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
 
        return values;

    }

    public boolean isElementVisible(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void pressEnterKey() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public WebElement findElementInList(By locator, String value) {
        List<WebElement> elements = findAll(locator);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(value)) {
                return element;
            }
        }
        throw new NoSuchElementException("No element found with text: " + value);
    }

    public String getElementText(By locator) {
        return find(locator).getText();
    }

}
