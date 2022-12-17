package org.example.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;

// Класс объекта с функционалом тест-кейса №1. Клик по главному логотипу сайта.
public class PressLogoTestCase extends AbstractTestCase {

    // Конструктор.
    public PressLogoTestCase(Browser browser) {
        super(browser, "Клик по главному логотипу сайта");
    }


    // Предусловие. Открывается страница сайта, отличная от главной.
    @Override
    public void precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/prod.html?idp_=5");
    }

    // Ожидание выполнения предусловия.
    @Override
    public void waitOfPrecondition1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/prod.html?idp_=5");
    }

    // Шаг №1. Клик по главному логотипу сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getLogo().clickLogo();
    }

    // Ожидание выполнения Шага №1.
    @Override
    public void waitOfStep1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html");
    }
}
