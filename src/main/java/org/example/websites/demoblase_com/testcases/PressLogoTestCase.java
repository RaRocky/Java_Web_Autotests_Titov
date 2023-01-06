package org.example.websites.demoblase_com.testcases;

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
    public AbstractTestCase precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/prod.html?idp_=5");
        return super.precondition1();
    }

    // Ожидание выполнения предусловия.
    @Override
    public AbstractTestCase waitOfPrecondition1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/prod.html?idp_=5");
        return super.waitOfPrecondition1();
    }

    // Проверка выполнения предусловия.
    @Override
    public AbstractTestCase checkOfPrecondition1() {
        assertOfUrlContains("https://www.demoblaze.com/prod.html?idp_=5");
        return super.checkOfPrecondition1();
    }


    // Шаг №1. Клик по главному логотипу сайта.
    @Override
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getLogo().clickLogo();
        return super.step1();
    }

    // Ожидание выполнения Шага №1.
    @Override
    public AbstractTestCase waitOfStep1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html");
        return super.waitOfStep1();
    }

    // Проверка выполнения шага №1.
    @Override
    public AbstractTestCase checkOfStep1() {
        assertOfUrlContains("https://www.demoblaze.com/index.html");
        return super.checkOfStep1();
    }
}
