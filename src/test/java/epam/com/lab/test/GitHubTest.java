package epam.com.lab.test;

import com.epam.lab.data.DataClass;
import com.epam.lab.data.DataReader;
import com.epam.lab.pageobjects.github.AuthorizationPage;
import com.epam.lab.pageobjects.github.MainPage;
import com.epam.lab.pageobjects.github.NavigationBar;
import com.epam.lab.pageobjects.github.SearchResultPage;
import com.epam.lab.webdriver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class GitHubTest {
    private static final String PROPERTY_FILE_PATH = "src/main/resources/Configuration.properties";
    private static final String PRINT_RESULTS = "Printing results";
    private static String chromeDriverPath;
    private static String driverType;
    private static String siteGitHub;
    //github
    private static AuthorizationPage authorizationPage;
    private static MainPage mainPage;
    private static NavigationBar navigationBar;
    private static SearchResultPage searchResultPage;
    private Properties properties;
    private DataClass data;

    private static final Logger LOGGER = LogManager.getLogger(GitHubTest.class);


    @BeforeClass
    public void createChromeDriver() {
        readConfig();
        data = new DataReader().readData(new File(properties.getProperty("data")));
        System.setProperty(driverType, chromeDriverPath);
        //github
        authorizationPage = new AuthorizationPage();
        mainPage = new MainPage();
        navigationBar = new NavigationBar();
        searchResultPage = new SearchResultPage();


    }

    @Test
    public void GithubSearchTest() {
        LOGGER.info("Github Search Test");
        LOGGER.info("0) Opening {}", siteGitHub);
        Driver.getWebDriver().get(siteGitHub);
        mainPage.doSmthWithUserName();
        mainPage.printAllLabels();
        mainPage.openMenu();
        LOGGER.info("1) Clicking sign in to GitHub");
        mainPage.clickOnLogInField();
        LOGGER.info("2) Typing login and password and clicking sign in");
        authorizationPage.setLogin(data.getLogingit());
        authorizationPage.setPassword(data.getPasswordgit());
        authorizationPage.clickSubmmitButton();
        LOGGER.info("3) Verifying that test has successfully signed in");
        Assert.assertEquals(Driver.getWebDriver().getCurrentUrl(), siteGitHub,
                "Unsuccessful authorization");
        LOGGER.info("4) In search input type '{}'", data.getQuery1());
        navigationBar.setSerchQuery(data.getQuery1());
        LOGGER.info("5) {}", PRINT_RESULTS);
        searchResultPage.printResults(LOGGER);
        LOGGER.info("6) Verifying that all search results has tag selenium");
        Assert.assertTrue(searchResultPage.isTagInAllResults(data.getTag()));
        LOGGER.info("7) Changing sorting to other dropdown value");
        searchResultPage.openSortingBar();
        searchResultPage.chooseSortingOption(2);
        LOGGER.info("8) {}", PRINT_RESULTS);
        searchResultPage.printResults(LOGGER);
        LOGGER.info("9) Changing text in search bar");
        navigationBar.setSerchQuery(data.getQuery2());
        LOGGER.info("10) {}", PRINT_RESULTS);
        searchResultPage.printResults(LOGGER);
    }

    @AfterSuite
    public void closeDriver() {
        Driver.close();
    }

    private void readConfig() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        chromeDriverPath = properties.getProperty("chromeDriverPath");
        driverType = properties.getProperty("driverType");
        siteGitHub = properties.getProperty("githuburl");
    }
}
