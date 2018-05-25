package epam.com.lab.test;

import com.epam.lab.data.DataClass;
import com.epam.lab.data.DataReader;
import com.epam.lab.pageobjects.gmail.AuthorizationEmailPage;
import com.epam.lab.pageobjects.gmail.AuthorizationPasswordPage;
import com.epam.lab.pageobjects.gmail.PersonalPage;
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

public class GmailTest {
    private static final String PROPERTY_FILE_PATH = "src/main/resources/Configuration.properties";
    private static String chromeDriverPath;
    private static String driverType;
    private static String siteGmail;
    private static AuthorizationEmailPage authorizationEmailPage;
    private static AuthorizationPasswordPage authorizationPasswordPage;
    private static PersonalPage personalPage;
    private Properties properties;
    private DataClass data;
    private static final Logger LOGGER = LogManager.getLogger(GitHubTest.class);

    @BeforeClass
    public void createChromeDriver() {
        readConfig();
        data = new DataReader().readData(new File(properties.getProperty("data")));
        System.setProperty(driverType, chromeDriverPath);
        authorizationEmailPage = new AuthorizationEmailPage(Driver.getWebDriver());
        authorizationPasswordPage = new AuthorizationPasswordPage(Driver.getWebDriver());
        personalPage = new PersonalPage(Driver.getWebDriver());
    }

    @Test
    public void GmailDeleteLettersTest() {
        LOGGER.info("Gmail Delete Letters Test");
        Driver.getWebDriver().get(siteGmail);
        LOGGER.info("1) Login");
        authorizationEmailPage.setEmail(data.getLogin());
        authorizationEmailPage.clickSubmitButton();
        authorizationPasswordPage.setPassword(data.getPassword());
        authorizationPasswordPage.clickSubmitButton();
        LOGGER.info("2) Selecting 3 messages from inbox using checkboxes");
        personalPage.markLettersCheckbox(data.getLettersNumber());
        LOGGER.info("3) Clicking on 'delete' button");
        personalPage.clickDeleteButton();
        LOGGER.info("4) Clicking on the undo button");
        personalPage.clickUndoButton();
        LOGGER.info("5) Verifying that messages are not deleted");
        Assert.assertTrue(personalPage.verifyLettersNotDeleted());
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
        siteGmail = properties.getProperty("gmailurl");
    }
}
