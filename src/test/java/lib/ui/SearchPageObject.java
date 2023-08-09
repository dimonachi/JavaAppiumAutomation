package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SKIP_START_PAGE = "//*[contains(@text, 'Skip')]",
            SEARCH_INIT_ELEMENT = "org.wikipedia:id/search_container",
            //поле ввода, куда уже можно ввести текст
            SEARCH_INPUT_FIELD = "org.wikipedia:id/search_src_text",
            SEARCH_RETURN_BUTTON ="Navigate up",
            //поле ввода на стартовой страницы
            SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text = '{SUBSTRING}']",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results']";
    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void skipStartPage()
    {
        this.waitForElementAndClick(By.xpath(SKIP_START_PAGE), "Cannot find 'Skip'", 5);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */
    public void initSearchInput()
    {
        this.waitForElementPresent(By.id(SEARCH_INIT_ELEMENT), "Cannot find and click search init element");
        this.waitForElementAndClick(By.id(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
    }

    public void waitForReturnButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_RETURN_BUTTON), "Cannot find search return button", 5);

    }
    public void waitForReturnButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_RETURN_BUTTON), "Search return button is still present", 5);

    }
    public void clickReturnSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_RETURN_BUTTON), "Cannot find and click search return button", 5);
    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
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
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));

    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);

    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT),"We supposed not to find any result");
    }

    public void waitForFindSomeArticle()
    {
        this.waitForElementLook(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find more than 1 article",
                10
        );
    }

    public void cleanSearchLine()
    {
        this.waitForElementAndClear(
                By.id(SEARCH_INPUT_FIELD),
                "Cannot find search field",
                10
        );

    }
}
