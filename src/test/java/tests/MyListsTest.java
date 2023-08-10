package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class MyListsTest extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String
        login = "JavaWebTest",
        password = "JavaWebTest1";
    @Test
    public void testSaveFirstArticleToMyList() throws InterruptedException {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMySaved();



        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);;
        Auth.clickAuthButton();
        Auth.enterLoginData(login, password);
        Auth.submitForm();

        ArticlePageObject.waitForTitleElement();
        assertEquals(
                "We are not the same page after login",
                article_title,
                ArticlePageObject.getArticleTitle()
        );
        ArticlePageObject.addArticleToMySaved();


        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);

        MyListsPageObject.swipeByArticleToDelete(article_title);

    }

    //ex 5 refactor
    @Test
    public void testSaveTwoArticleToMyList() throws InterruptedException {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMySaved();

        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);;
        Auth.clickAuthButton();
        Auth.enterLoginData(login, password);
        Auth.submitForm();

        ArticlePageObject.waitForTitleElement();
        assertEquals(
                "We are not the same page after login",
                article_title,
                ArticlePageObject.getArticleTitle()
        );
        ArticlePageObject.addArticleToMySaved();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Island in Indonesia");


        ArticlePageObject.waitForTitleElement();
        String article_title2 = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMySaved();

        NavigationUI NavigationUI = new NavigationUI(driver);

        NavigationUI.openNavigation();
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);

        MyListsPageObject.swipeByArticleToDelete(article_title);
        MyListsPageObject.clickOnExistTitle("Java");



    }


}
