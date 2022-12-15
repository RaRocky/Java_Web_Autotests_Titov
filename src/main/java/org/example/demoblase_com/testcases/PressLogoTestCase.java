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
    Logo logo = new Logo(getBrowser().getWebDriver());


    // Конструктор.
    public PressLogoTestCase(Browser browser) {
        super(browser);
    }


    // Предусловие.
    @Override
    public void precondition() {
        getBrowser().goToUrl("https://www.demoblaze.com/prod.html?idp_=5");
    }

    // Ожидание выполнения предусловия.
    @Override
    public void waitOfPrecondition() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/prod.html?idp_=5"));
    }

    // Шаг №1. Клик по главному логотипу сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        logo.clickLogo();
    }

    // Ожидание выполнения Шага №1.
    @Override
    public void waitOfStep1() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/index.html"));
    }
}
