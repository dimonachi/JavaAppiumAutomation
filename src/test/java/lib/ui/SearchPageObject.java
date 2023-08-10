package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INIT_ELEMENT = "button#searchIcon",
            //поле ввода, куда уже можно ввести текст
            SEARCH_INPUT_FIELD = "form>input[type='search']",
    //теперь это закрытие
            SEARCH_RETURN_BUTTON ="div>button[class='cdx-button cdx-button--size-large cdx-button--weight-quiet cdx-button--icon-only  cancel']",
            //поле ввода на стартовой страницы
            SEARCH_INPUT = "form>input[type='search']",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//div[contains(@class,'wikidata-description')][contains(text(), '{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "ul.page-list>li.page-summary",
            SEARCH_EMPTY_RESULT_ELEMENT = "p.without-results";
    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }



    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */
    public void initSearchInput()
    {
        this.waitForElementPresent(By.cssSelector(SEARCH_INIT_ELEMENT), "Cannot find and click search init element");
        this.waitForElementAndClick(By.cssSelector(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 10);
    }

    public void waitForReturnButtonToAppear()
    {
        this.waitForElementPresent(By.cssSelector(SEARCH_RETURN_BUTTON), "Cannot find search return button", 10);

    }
    public void waitForReturnButtonToDisappear()
    {
        this.waitForElementNotPresent(By.cssSelector(SEARCH_RETURN_BUTTON), "Search return button is still present", 5);

    }
    public void clickReturnSearch()
    {
        this.waitForElementAndClick(By.cssSelector(SEARCH_RETURN_BUTTON), "Cannot find and click search return button", 10);
    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.cssSelector(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.cssSelector(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(By.cssSelector(SEARCH_RESULT_ELEMENT));

    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(By.cssSelector(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);

    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.cssSelector(SEARCH_RESULT_ELEMENT),"We supposed not to find any result");
    }

    public void waitForFindSomeArticle()
    {
        this.waitForElementLook(
                By.cssSelector(SEARCH_RESULT_ELEMENT),
                "Cannot find more than 1 article",
                10
        );
    }

    public void cleanSearchLine()
    {
        this.waitForElementAndClear(
                By.cssSelector(SEARCH_INPUT_FIELD),
                "Cannot find search field",
                10
        );

    }
}
