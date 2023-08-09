package lib.ui;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
        TITLE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[1]",
        FOOTER_ELEMENT = "//*[@text='View article in browser']",
        SAVE_BUTTON = "org.wikipedia:id/page_save",
        ADD_TO_MY_LIST_BUTTON = "//*[@text = 'Add to another reading list']",
        CREATE_NEW_LIST_BUTTON = "//*[@text = 'Create new']",
        MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "android:id/button1",
        RETURN_ARTICLE_BUTTON = "Navigate up",
        NAME_OF_FOLDER_TPL = "//*[@text = '{NameOfFolder}']";
    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.xpath(TITLE),"Cannot find article title on page", 15);

    }

    /* TEMPLATES METHODS */
    private static String getNameOfFolder(String name_of_folder)
    {
        return NAME_OF_FOLDER_TPL.replace("{NameOfFolder}", name_of_folder);
    }
    /* TEMPLATES METHODS */
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find 'Save' button",
                5
        );
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find 'Save' button",
                5
        );
        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find 'Add to another reading list'",
                5
        );
        this.waitForElementAndClick(
                By.xpath(CREATE_NEW_LIST_BUTTON),
                "Cannot find 'Create new'",
                5
        );

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot clean input element",
                5
        );
        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );
        this.waitForElementAndClick(
                By.id(MY_LIST_OK_BUTTON),
                "Cannot find 'OK' button",
                5
        );
    }

    public void returnFromArticle()
    {
        this.waitForElementAndClick(
                By.id(RETURN_ARTICLE_BUTTON),
                "Cannot find '<-' button",
                5
        );
    }
    public void addArticleToMyExistList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find 'Save' button",
                5
        );
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find 'Save' button",
                5
        );
        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find 'Add to another reading list'",
                5
        );

        String name_of_folder_xpath = getNameOfFolder(name_of_folder);
        this.waitForElementAndClick(By.xpath(name_of_folder_xpath), "Cannot find and click this name of folder " + name_of_folder, 10);

    }

    public void assertTitleOfArticlePresent()
    {
        this.assertElementPresent(
                By.xpath(TITLE),
                "text",
                "Cannot find title of article"
        );
    }
}
