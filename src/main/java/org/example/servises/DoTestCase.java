package org.example.servises;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.websites.demoblase_com.testcases.*;

// Класс, содержащий методы реализации тест-кейсов.
public class DoTestCase {

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
                "Проверка возможности воспроизведения видео 'About us'");
        playAboutUsVideoTestCase.doTestCase();
    }
}
