package org.example.lesson3;

import org.example.demoblase_com.testcases.PressLogoTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.BrowserName;
import org.example.servises.webdriver.Browser;

public class HomeWork3 {
    public static void main(String[] args)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        Browser browser = new Browser(BrowserName.CHROME);
        pressLogoTestCase(browser);
        browser.close();

    }

    public static void pressLogoTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        PressLogoTestCase testCase = new PressLogoTestCase(browser);
        testCase.doPressLogoTestCase();
    }
}
