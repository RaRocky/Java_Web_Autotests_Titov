package org.example.lesson3;

import org.example.demoblase_com.testcases.AuthorizationTestCase;
import org.example.demoblase_com.testcases.PressLogoTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.BrowserName;
import org.example.servises.webdriver.Browser;

// Домашнее задание к уроку №3.
public class HomeWork3 {
    public static void main(String[] args)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        // Создание объекта класса Browser для управления браузером при помощи Selenium Web Driver.
        Browser browser = new Browser(BrowserName.CHROME); // Тип браузера настраивается опционально.

        // Выполнение тест-кейса №1. Клик по главному логотипу сайта.
        pressLogoTestCase(browser);

        // Выполнение тест-кейса №2. Авторизация пользователя.
        authorizationTestCase(browser);

        // Остановка работы Selenium Web Driver. Закрытие браузера.
        browser.close();

    }

    // Метод, выполняющий тест-кейс №1. Клик по главному логотипу сайта.
    public static void pressLogoTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        PressLogoTestCase testCase = new PressLogoTestCase(browser);
        testCase.doTestCase();
    }

    // Метод, выполняющий тест-кейс №2. Авторизация пользователя.
    public static void authorizationTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        AuthorizationTestCase testCase = new AuthorizationTestCase(browser);
        testCase.doTestCase();

    }
}
