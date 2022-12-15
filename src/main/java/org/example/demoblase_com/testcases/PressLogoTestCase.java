package org.example.demoblase_com.testcases;

import org.example.demoblase_com.pages.Logo;
import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс объекта с функционалом тест-кейса №1. Клик по главному логотипу сайта.
public class PressLogoTestCase extends AbstractTestCase {

    // Объект главного логотипа сайта.
    Logo logo = new Logo(getBrowser());


    // Конструктор.
    public PressLogoTestCase(Browser browser) {
        super(browser);
    }


    // Предусловие. Открывается страница сайта, отличная от главной.
    @Override
    public void precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/prod.html?idp_=5");
    }

    // Ожидание выполнения предусловия.
    @Override
    public void waitOfPrecondition1(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/prod.html?idp_=5"));
    }

    // Шаг №1. Клик по главному логотипу сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        logo.clickLogo();
    }

    // Ожидание выполнения Шага №1.
    @Override
    public void waitOfStep1(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/index.html"));
    }
}
