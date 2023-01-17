package org.example.abstractions;

import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.BrowserName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class AbstractTest {

    private static Browser browser;

    @BeforeAll
    public static void setBrowser() {
        browser = new Browser(BrowserName.CHROME);
    }

    @AfterEach
    public void deleteCookie() {
        browser.getWebDriver().manage().deleteAllCookies();
    }

    @AfterAll
    public static void closeBrowser() {
        browser.close();
    }

    public static Browser getBrowser() {
        return browser;
    }
}
