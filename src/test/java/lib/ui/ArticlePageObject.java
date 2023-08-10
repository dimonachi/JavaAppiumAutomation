package lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObject extends MainPageObject{

    private static final String
        TITLE = "div>h1>[class='mw-page-title-main']",
        FOOTER_ELEMENT = "footer",
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "li#page-actions-watch a#ca-watch.mw-ui-icon-wikimedia-star-base20",
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "li#page-actions-watch a#ca-watch.mw-ui-icon-wikimedia-unStar-progressive",

        CLOSE_ARTICLE_BUTTON="",


        ADD_TO_MY_LIST_BUTTON = "//*[@text = 'Add to another reading list']",
        CREATE_NEW_LIST_BUTTON = "//*[@text = 'Create new']",
        MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "android:id/button1",
        RETURN_ARTICLE_BUTTON = "Navigate up",
        NAME_OF_FOLDER_TPL = "//*[@text = '{NameOfFolder}']";
    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.cssSelector(TITLE),"Cannot find article title on page", 15);

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
        return title_element.getText();
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.cssSelector(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.cssSelector(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find 'Save' button",
                5
        );
        this.waitForElementAndClick(
                By.cssSelector(OPTIONS_ADD_TO_MY_LIST_BUTTON),
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
                By.cssSelector(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find 'Save' button",
                5
        );
        this.waitForElementAndClick(
                By.cssSelector(OPTIONS_ADD_TO_MY_LIST_BUTTON),
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

    public void addArticleToMySaved(){
        this.removeArticlesFromMySavedIfItAdded();
        this.waitForElementAndClick(
                By.cssSelector(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find button to add an article",
                10
        );
    }
    public void removeArticlesFromMySavedIfItAdded(){
        if(this.isElementPresent(By.cssSelector(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON))){
            this.waitForElementAndClick(
                    By.cssSelector(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON),
                    "Cannot click button to remove",
                    10
            );
            this.waitForElementPresent(
                    By.cssSelector(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                    "Cannot find button to add an article to saved list after removing",
                    10
            );
        }
    }

    public void assertTitleOfArticlePresent()
    {
        this.assertElementPresent(
                By.cssSelector(TITLE),
                "text",
                "Cannot find title of article"
        );
    }


}
