package org.example.demoblase_com.testcases;

import org.example.servises.webdriver.AbstractPage;
import org.example.servises.webdriver.Browser;

public class AbstractTestCase {
    private final Browser browser;

    public AbstractTestCase (Browser browser) {
        this.browser = browser;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void precondition () {

    }
}
