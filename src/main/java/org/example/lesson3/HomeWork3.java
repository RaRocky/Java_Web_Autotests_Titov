package org.example.lesson3;

import org.example.demoblase_com.testcases.*;
import org.example.servises.DoTestCase;
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
        DoTestCase.pressLogoTestCase(browser);

        // Выполнение тест-кейса №2. Авторизация пользователя.
        DoTestCase.authorizationTestCase(browser);
        // Запись в файл cookie с авторизованным пользователем
        MyCookie cookie = new MyCookie(browser);
        cookie.writeCookieToFile("./src/main/java/org/example/demoblase_com/cookies/Authorization_Cookie.data");

        // Выполнение тест-кейса №3. Добавление товара 'ASUS Full HD' в корзину с последующим удалением.
        DoTestCase.addProductOnCartAndDeleteTestCase(browser);

        // Выполнение тест-кейса №4. Оформление заказа.
        DoTestCase.placeOrderTestCase(browser);

        // Выполнение тест-кейса №5. Отправление сообщения в разделе 'Contact'.
        DoTestCase.sendContactMessageTestCase(browser);

        // Выполнение тест-кейса №6. Проверка возможности воспроизведения видео 'About us'.
        DoTestCase.playAboutUsVideoTestCase(browser);

        // Остановка работы Selenium Web Driver. Закрытие браузера.
        browser.close();
    }


}
