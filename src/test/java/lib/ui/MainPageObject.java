package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public void assertElementPresent (By by, String attribute, String error_message)
    {
        WebElement element = driver.findElement(by);
        if (!element.isDisplayed()){
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
        element.getAttribute(attribute);
    }



    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message,
                                                 long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe){
        if (driver instanceof AppiumDriver){
            TouchAction action = new TouchAction((AppiumDriver)driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width/2;
            int start_y = (int)(size.height * 0.8);
            int end_y = (int)(size.height * 0.2);

            action
                    .press(point(x, start_y))
                    .waitAction(waitOptions(ofSeconds(timeOfSwipe)))
                    .moveTo(point(x, end_y))
                    .release()
                    .perform();
        }else{
            System.out.println("Method swipeUp does nothing for platforms");
        }
        }


    public void swipeUpQuick(){
        swipeUp(200);
    }

    public void scrollWebPageUp(){
        JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
        JSExecutor.executeScript("window.scrollBy(0,250)");
    }

    public void scrollWebPageTillElementNotVisible(By by, String error_message, int max_swipes){
        int already_swiped = 0;

        WebElement element = this.waitForElementPresent(by, error_message);

        while (this.driver.findElements(by).size() == 0){
            scrollWebPageUp();
            ++already_swiped;
            if (already_swiped > max_swipes){
                Assert.assertTrue(error_message, element.isDisplayed());
            }


        }

    }
    public void swipeUpToFindElement(By by, String error_message, int max_swipes){

        int already_swiped = 0;
        while (driver.findElements(by).size() == 0){

            if (already_swiped > max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeElementToLeft(By by, String error_message){
        if (driver instanceof AppiumDriver){
            WebElement element = waitForElementPresent(
                    by,
                    error_message,
                    10);
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y)/2;

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action
                    .press(point(right_x, middle_y))
                    .waitAction(waitOptions(ofSeconds(10)))
                    .moveTo(point(left_x, middle_y))
                    .release()
                    .perform();
        }else{
            System.out.println("Method swipeElementToLeft does nothing for platforms");
        }
        }

    public int getAmountOfElements(By by){

        List elements = driver.findElements(by);
        return elements.size();
    }

    public boolean isElementPresent(By by){
        return getAmountOfElements(by) > 0;
    }

    public void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_element = getAmountOfElements(by);
        if (amount_of_element > 0){
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }
    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds){

        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    public void waitForElementLook(By by, String error_message,long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(by,1)
        );
    }

    public void tryClickElementWithFewAttempts(By by, String error_message, int amount_of_attempts){
        int current_attempts = 0;
        boolean need_more_attempts = true;

        while(need_more_attempts){
            try{
                this.waitForElementAndClick(by,error_message,1);
                need_more_attempts = false;
            }catch (Exception e){
                if (current_attempts >amount_of_attempts){
                    this.waitForElementAndClick(by,error_message,1);
                }
            }
            ++ current_attempts;
        }
    }


}
