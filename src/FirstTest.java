import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_2_API_26");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\hp\\Desktop\\JavaAppiumAutomation\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*@Test
    public void firstTest() {

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find 'Skip'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementPresent(
                By.xpath("//*[@text = 'Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
    }

    @Test
    public void testCancelSearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find 'Skip'",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                10
        );
        waitForElementAndClick(
                By.id("Navigate up"),
                "Cannot find '<-' to return",
                5
        );
        waitForElementNotPresent(
                By.id("Navigate up"),
                "'<-' to return",
                5
        );
    }

    @Test
    public void testCompareArticleTitle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find 'Skip'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Object-oriented programming language']"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        WebElement title_element = waitForElementPresent(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[1]"),
                "Cannot find 'Search Wikipedia' input",
                20
        );
        String article_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title!",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    public void testSwipeArticle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find 'Skip'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Appium",
                "Cannot find search input",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Automation for Apps']"),
                "Cannot find 'Appium' input",
                5
        );
        WebElement title_element = waitForElementPresent(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[1]"),
                "Cannot find 'Search Wikipedia' input",
                20
        );
        swipeUpToFindElement(
                By.xpath("//*[@text='View article in browser']"),
                "Cannot find the end of article",
                20
        );

    }*/

    @Test
    public void saveTwoArticleToMyList(){

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find 'Skip'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Object-oriented programming language']"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementPresent(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[1]"),
                "Cannot find 'Search Wikipedia' input",
                20
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find 'Save' button",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find 'Save' button",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Add to another reading list']"),
                "Cannot find 'Add to another reading list'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Create new']"),
                "Cannot find 'Create new'",
                5
        );

        String name_of_folder = "Test1";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );
        waitForElementAndClick(
                By.id("android:id/button1"),
                "Cannot find 'OK' button",
                5
        );
        waitForElementAndClick(
                By.id("Navigate up"),
                "Cannot find '<-' button",
                5
        );


        //Добавление второй статьи
        waitForElementAndClick(
                By.xpath("//*[@text = 'Island in Indonesia']"),
                "Cannot find 'Island in Indonesia'",
                5
        );
        waitForElementPresent(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[1]"),
                "Cannot find name of article",
                20
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find 'Save' button",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find 'Save' button",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Add to another reading list']"),
                "Cannot find 'Add to another reading list'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text ='"+ name_of_folder+ "']"),
                "Cannot find 'Island in Indonesia'",
                5
        );
        //Возвращение на главную страницу
        waitForElementAndClick(
                By.id("Navigate up"),
                "Cannot find '<-' button",
                5
        );
        waitForElementAndClick(
                By.id("Navigate up"),
                "Cannot find '<-' button",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot find 'Saved'",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text ='"+ name_of_folder+ "']"),
                "Cannot find 'Learning programming' list",
                5
        );
        //удаление статьи
        swipeElementToLeft(
                By.xpath("//*[@text = 'Java (programming language)']"),
                "Cannot find article"
        );

        //Проверка, что вторая статья осталась
        waitForElementPresent(
                By.xpath("//*[@text = 'Island in Indonesia']"),
                "Cannot find Island article",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Island in Indonesia']"),
                "Cannot open Island article",
                5
        );
        //Проверка, что открылась верная статья
        waitForElementPresent(
                By.xpath("//*[@text = 'Island in Indonesia']"),
                "Cannot find Island article",
                5
        );

    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message,
                                                 long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds){
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
            element.clear();
            return element;
        }

    protected void swipeUp(int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int)(size.height * 0.8);
        int end_y = (int)(size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    protected void swipeUpQuick(){
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipes){

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

    protected void swipeElementToLeft(By by, String error_message){
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }
}

