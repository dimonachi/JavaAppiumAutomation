package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject {

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    private static final String
        MY_LISTS_LINK = "a.menu__item--watchlist",
        OPEN_NAVIGATION="label#mw-mf-main-menu-button";


    public void openNavigation(){
        this.waitForElementAndClick(
                By.cssSelector(OPEN_NAVIGATION),
                "Cannot find and click open navigation button",
                5
        );
    }
    public void clickMyList()
    {
        this.tryClickElementWithFewAttempts(
                By.cssSelector(MY_LISTS_LINK),
                "Cannot find my list",
                5
        );

    }

}
