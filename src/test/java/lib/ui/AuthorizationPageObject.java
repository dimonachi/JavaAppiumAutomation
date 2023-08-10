package lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{

    private static final String
        LOGIN_BUTTON = "//div[contains(@class,'drawer drawer-container__drawer position-fixed visible')]//span[text()='Log in']",
        LOGIN_INPUT ="input[name='wpName']",
        PASSWORD_INPUT="input[name='wpPassword']",
        SUBMIT_BUTTON="button#wpLoginAttempt";

    public AuthorizationPageObject (RemoteWebDriver driver){
        super(driver);
    }

    public void clickAuthButton(){
        this.waitForElementPresent(By.xpath(LOGIN_BUTTON), "Cannot find login button", 10);
        this.waitForElementAndClick(By.xpath(LOGIN_BUTTON), "Cannot find and click login button", 10);
    }

    public void enterLoginData(String login, String password){
        this.waitForElementAndSendKeys(By.cssSelector(LOGIN_INPUT),login,"Cannot find and put a login in login input",10);
        this.waitForElementAndSendKeys(By.cssSelector(PASSWORD_INPUT),password,"Cannot find and put a pass in pass input",10);
    }

    public void submitForm(){
        this.waitForElementAndClick(By.cssSelector(SUBMIT_BUTTON),"Cannot find and click submit auth button",10);
    }

}
