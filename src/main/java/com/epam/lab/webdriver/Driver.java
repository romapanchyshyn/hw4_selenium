package com.epam.lab.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Driver {
    private static WebDriver webDriver;

    private Driver() {
    }


    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(10, SECONDS);
        }
        return webDriver;
    }

    public static void close() {
        if (webDriver != null)
            webDriver.quit();
    }


}
