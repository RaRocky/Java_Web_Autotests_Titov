package org.example.abstractions;

import org.apache.commons.io.FileUtils;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.BrowserName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class AbstractTest {

    private static Browser browser;

    @BeforeAll
    public static void setBrowser() throws IOException {
        browser = new Browser(BrowserName.CHROME);

        /*File screenshots = new File("./target/screenshots");
        if (!screenshots.exists()) Files.createDirectory(Path.of("./target/screenshots"));
        FileUtils.cleanDirectory(screenshots);*/
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
