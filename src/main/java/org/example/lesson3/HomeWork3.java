package org.example.lesson3;

import org.example.demoblase_com.testcases.*;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.BrowserName;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.cookie.MyCookie;

import java.io.IOException;

// Домашнее задание к уроку №3.
public class HomeWork3 {
    public static void main(String[] args)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException, IOException {

        // Создание объекта класса Browser для управления браузером при помощи Selenium Web Driver.
        Browser browser = new Browser(BrowserName.CHROME); // Тип браузера настраивается опционально.

        // Выполнение тест-кейса №1. Клик по главному логотипу сайта.
        pressLogoTestCase(browser);

        // Выполнение тест-кейса №2. Авторизация пользователя.
        authorizationTestCase(browser);
        // Запись в файл cookie с авторизованным пользователем
        MyCookie cookie = new MyCookie(browser);
        cookie.writeCookieToFile("./src/main/java/org/example/demoblase_com/cookies/Authorization_Cookie.data");

        // Выполнение тест-кейса №3. Добавление товара 'ASUS Full HD' в корзину с последующим удалением.
        addProductOnCartAndDeleteTestCase(browser);

        // Выполнение тест-кейса №4. Оформление заказа.
        placeOrderTestCase(browser);

        // Выполнение тест-кейса №5. Отправление сообщения в разделе 'Contact'.
        sendContactMessageTestCase(browser);

        // Выполнение тест-кейса №6. Проверка возможности воспроизведения видео 'About us'.
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
        AuthorizationTestCase testCase = new AuthorizationTestCase(browser);
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
        PlaceOrderTestCase placeOrderTestCase = new PlaceOrderTestCase(browser, "Оформление заказа");
        placeOrderTestCase.doTestCase();
    }

    // Метод, выполняющий тест-кейс №5. Отправление сообщения в разделе 'Contact'.
    public static void sendContactMessageTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        SendContactMessageTestCase sendContactMessageTestCase =
                new SendContactMessageTestCase(browser, "Отправление сообщения в разделе Contact");
        sendContactMessageTestCase.doTestCase();
    }

    // Метод, выполняющий тест-кейс №6. Проверка возможности воспроизведения видео 'About us'.
    public static void playAboutUsVideoTestCase(Browser browser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        PlayAboutUsVideoTestCase playAboutUsVideoTestCase = new PlayAboutUsVideoTestCase(browser,
                "Проверка возможности воспроизведения видео 'About us'.");
        playAboutUsVideoTestCase.doTestCase();
    }
}
