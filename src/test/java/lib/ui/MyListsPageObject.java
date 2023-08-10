package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyListsPageObject extends MainPageObject {

    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    private static final String
        FOLDER_BY_NAME_TPL = "//*[@text ='{FOLDER_NAME}']",
        ARTICLE_BY_TITLE_TPL = "//ul[contains(@class,'content-unstyled page-list thumbs page-summary-list mw-mf-watchlist-page-list')]//h3[contains(text(), '{TITLE}')]",
        REMOVE_FROM_SAVED_BUTTON = "//ul[contains(@class,'content-unstyled page-list thumbs page-summary-list mw-mf-watchlist-page-list')]//h3[contains(text(), '{TITLE}')]/../../a[contains(@class, 'cdx-button cdx-button--fake-button cdx-button--fake-button--enabled cdx-button--size-large cdx-button--weight-quiet cdx-button--icon-only  watch-this-article watch-this-article watched')]";


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }
    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }
    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleAppearByTitle (String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "Cannot find saved article by title " + article_title ,15);
    }

    public void waitForArticleToDisappearByTitle (String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath), "Saved article still present withe title " + article_title ,15);
    }

    public void clickOnExistTitle (String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementAndClick(By.xpath(article_xpath), "Cannot click on this title " + article_title ,15);
    }

    public void swipeByArticleToDelete(String article_title) throws InterruptedException {
        this.waitForArticleAppearByTitle(article_title);
        String remove_locator = getRemoveButtonByTitle(article_title);
        this.waitForElementAndClick(
                By.xpath(remove_locator),
                "Cannot click button to remove article from saved",
                10
        );

        Thread.sleep(2000);
        driver.navigate().refresh();
        this.waitForArticleToDisappearByTitle(article_title);
    }

}
