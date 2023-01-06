package org.example.demoblase_tests;

import org.example.abstractions.AbstractTest;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.websites.demoblase_com.testcases.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Класс, содержащий тесты функционала сайта demoblase.com.
public class DemoblaseTest extends AbstractTest {


    @Test
    @DisplayName("Добавление товара 'ASUS Full HD' в корзину с последующим удалением")
    public void addProductOnCartAndDeleteTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        AddProductOnCartAndDeleteTestCase addProductOnCartAndDeleteTestCase =
                new AddProductOnCartAndDeleteTestCase(getBrowser());

        addProductOnCartAndDeleteTestCase.doTestCase();
    }

    @Test
    @DisplayName("Авторизация пользователя. Позитивный тест.")
    public void authorizationPositiveTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        AuthorizationTestCase authorizationTestCase =
                new AuthorizationTestCase(getBrowser(), "Bob Smith", "Enter000");

        authorizationTestCase.doTestCase();
    }

    @Test
    @DisplayName("Оформление заказа. Все поля заполнены.")
    public void placeOrderAllFieldTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        PlaceOrderTestCase placeOrderTestCase = new PlaceOrderTestCase(getBrowser(), "Bob Smith", "USA",
                "New York", "0000 0000 0000 0000", "December", "2022");

        placeOrderTestCase.doTestCase();
    }

    @Test
    @DisplayName("Проверка возможности воспроизведения видео 'About us'")
    public void playAboutUsVideoTest ()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        PlayAboutUsVideoTestCase playAboutUsVideoTestCase = new PlayAboutUsVideoTestCase(getBrowser());

        playAboutUsVideoTestCase.doTestCase();
    }

    @Test
    @DisplayName("Клик по главному логотипу сайта")
    public void pressLogoTest ()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        PressLogoTestCase pressLogoTestCase = new PressLogoTestCase(getBrowser());

        pressLogoTestCase.doTestCase();
    }

    @Test
    @DisplayName("Отправление сообщения в разделе 'Contact'. Все поля заполнены.")
    public void sendContactMessageAllFieldsTest ()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        SendContactMessageTestCase sendContactMessageTestCase = new SendContactMessageTestCase(getBrowser(),
                "bobsmith@gmail.com", "Bob Smith", "My message.");

        sendContactMessageTestCase.doTestCase();
    }
}


