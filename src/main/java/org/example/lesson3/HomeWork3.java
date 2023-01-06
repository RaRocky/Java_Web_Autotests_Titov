package org.example.lesson3;

import org.example.servises.Settings;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.BrowserName;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.cookie.MyCookie;
import org.example.websites.demoblase_com.testcases.*;

import java.io.IOException;

// Домашнее задание к уроку №3.
public class HomeWork3 {

    // Метод main, запускающий методы класса HomeWork3.
    public static void main(String[] args)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException, IOException {

        // Создание объекта класса Browser для управления браузером при помощи Selenium Web Driver.
        Browser browser = new Browser(BrowserName.CHROME); // Тип браузера настраивается опционально.

        // Выполнение тест-кейса №1. Клик по главному логотипу сайта.
        deleteCookies(browser);
        pressLogoTestCase(browser);

        // Выполнение тест-кейса №2. Авторизация пользователя.
        deleteCookies(browser);
        authorizationTestCase(browser);
        // Запись в файл cookie с авторизованным пользователем
        MyCookie cookie = new MyCookie(browser);
        Settings settings = new Settings();
        cookie.writeCookieToFile(settings.getDEMOBLASE_COOKIE_PATH());

        // Выполнение тест-кейса №3. Добавление товара 'ASUS Full HD' в корзину с последующим удалением.
        deleteCookies(browser);
        addProductOnCartAndDeleteTestCase(browser);

        // Выполнение тест-кейса №4. Оформление заказа.
        deleteCookies(browser);
        placeOrderTestCase(browser);

        // Выполнение тест-кейса №5. Отправление сообщения в разделе 'Contact'.
        deleteCookies(browser);
        sendContactMessageTestCase(browser);

        // Выполнение тест-кейса №6. Проверка возможности воспроизведения видео 'About us'.
        deleteCookies(browser);
        playAboutUsVideoTestCase(browser);

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
        AuthorizationTestCase testCase = new AuthorizationTestCase(browser, "Bob Smith", "Enter000");
        testCase.doTestCase();

    }

    // Метод, выполняющий тест-кейс №3. Добавление товара 'ASUS Full HD' в корзину с последующим удалением.
    public static void addProductOnCartAndDeleteTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        AddProductOnCartAndDeleteTestCase testCase = new AddProductOnCartAndDeleteTestCase(browser);
        testCase.doTestCase();
    }

    // Метод, выполняющий тест-кейс №4. Оформление заказа.
    public static void placeOrderTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        PlaceOrderTestCase placeOrderTestCase = new PlaceOrderTestCase(browser, "Bob Smith", "USA",
                "New York", "0000 0000 0000 0000", "December", "2022");
        placeOrderTestCase.doTestCase();
    }

    // Метод, выполняющий тест-кейс №5. Отправление сообщения в разделе 'Contact'.
    public static void sendContactMessageTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        SendContactMessageTestCase sendContactMessageTestCase =
                new SendContactMessageTestCase(browser, "bobsmith@gmail.com",
                        "Bob Smith", "My message.");
        sendContactMessageTestCase.doTestCase();
    }

    // Метод, выполняющий тест-кейс №6. Проверка возможности воспроизведения видео 'About us'.
    public static void playAboutUsVideoTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        PlayAboutUsVideoTestCase playAboutUsVideoTestCase = new PlayAboutUsVideoTestCase(browser);
        playAboutUsVideoTestCase.doTestCase();
    }


    // Метод, удаляющий все Cookie.
    public static void deleteCookies(Browser browser) {
        browser.getWebDriver().manage().deleteAllCookies();
    }
}
