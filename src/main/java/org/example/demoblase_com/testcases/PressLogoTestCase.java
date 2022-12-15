package org.example.demoblase_com.testcases;

import org.example.demoblase_com.pages.Logo;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PressLogoTestCase extends AbstractTestCase {

    Logo logo = new Logo(getBrowser().getWebDriver());

    public PressLogoTestCase(Browser browser) {
        super(browser);
    }

    public void doPressLogoTestCase () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        precondition();
        waitOfPrecondition();
        step1();
        waitOfStep1();
    }

    @Override
    public void precondition() {
        getBrowser().goToUrl("https://www.demoblaze.com/prod.html?idp_=5");
    }

    public void waitOfPrecondition() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/prod.html?idp_=5"));
    }

    public void step1() throws WrongTypeOfLocatorException {
        logo.clickLogo();
    }

    public void waitOfStep1() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/index.html"));
    }
}
