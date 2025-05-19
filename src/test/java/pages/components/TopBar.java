package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;

public class TopBar extends BasePage {

    private By userIcon = By.xpath("//li[@data-cy='userMenu']");


    public boolean isUserIconVisible() {
        return isElementVisible(userIcon);
    }
}
