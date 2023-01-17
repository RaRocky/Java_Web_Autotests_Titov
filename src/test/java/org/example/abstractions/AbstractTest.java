package org.example.abstractions;

import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.BrowserName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

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

    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getBrowser().getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });

            }

        }

    }

    @AfterAll
    public static void closeBrowser() {
        browser.close();
    }

    public static Browser getBrowser() {
        return browser;
    }
}
