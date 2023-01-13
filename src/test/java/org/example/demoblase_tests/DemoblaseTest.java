package org.example.demoblase_tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.example.abstractions.AbstractTest;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.websites.demoblase_com.pages.Logo;
import org.example.websites.demoblase_com.testcases.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Класс, содержащий тесты функционала сайта demoblase.com.
@Story("Тестирование функционала сайта demoblase.com.")
public class DemoblaseTest extends AbstractTest {

    @Test
    @DisplayName("Добавление товара 'ASUS Full HD' в корзину с последующим удалением")
    @Description("Тест проверяет механизм добавления товара 'ASUS Full HD' в корзину и последующее его удаление.")
    @Issue("https://docs.google.com/spreadsheets/d/1vIhcJpdcFD872lV3wiq0ApzRabKcImu18myEs4oaPzM/edit#gid=810296389")
    @Severity(SeverityLevel.CRITICAL)
    public void addProductOnCartAndDeleteTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        AddProductOnCartAndDeleteTestCase addProductOnCartAndDeleteTestCase =
                new AddProductOnCartAndDeleteTestCase(getBrowser());

        addProductOnCartAndDeleteTestCase.doTestCase();
    }

    @Test
    @DisplayName("Авторизация пользователя. Позитивный тест.")
    @Description("Тест проверяет механизм авторизации пользователя, когда поля ввода логина и пароля заполнены, " +
            "и введены корректрые данные.")
    @Issue("https://docs.google.com/spreadsheets/d/1vIhcJpdcFD872lV3wiq0ApzRabKcImu18myEs4oaPzM/edit#gid=312983893")
    @Severity(SeverityLevel.BLOCKER)
    public void authorizationPositiveTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        AuthorizationTestCase authorizationTestCase =
                new AuthorizationTestCase(getBrowser(), "Bob Smith", "Enter000");

        authorizationTestCase.doTestCase();
    }

    @Test
    @DisplayName("Оформление заказа. Все поля заполнены.")
    @Description("Тест проверяет работу формы отправления заказа, когда все поля ввода заполнены.")
    @Issue("https://docs.google.com/spreadsheets/d/1vIhcJpdcFD872lV3wiq0ApzRabKcImu18myEs4oaPzM/edit#gid=591853859")
    @Severity(SeverityLevel.CRITICAL)
    public void placeOrderAllFieldTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        PlaceOrderTestCase placeOrderTestCase = new PlaceOrderTestCase(getBrowser(), "Bob Smith", "USA",
                "New York", "0000 0000 0000 0000", "December", "2022");

        placeOrderTestCase.doTestCase();
    }

    @Test
    @DisplayName("Проверка возможности воспроизведения видео 'About us'")
    @Description("Тест проверяет, начинается ли воспроизведение видео в окне 'About us'.")
    @Issue("https://docs.google.com/spreadsheets/d/1vIhcJpdcFD872lV3wiq0ApzRabKcImu18myEs4oaPzM/edit#gid=1404817174")
    @Severity(SeverityLevel.TRIVIAL)
    public void playAboutUsVideoTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        PlayAboutUsVideoTestCase playAboutUsVideoTestCase = new PlayAboutUsVideoTestCase(getBrowser());

        playAboutUsVideoTestCase.doTestCase();
    }

    @Test
    @DisplayName("Клик по главному логотипу сайта")
    @Description("Тест проверяет, что при нажатии на главный логотип сайта осуществляется переход на главную страницу.")
    @Issue("https://docs.google.com/spreadsheets/d/1vIhcJpdcFD872lV3wiq0ApzRabKcImu18myEs4oaPzM/edit#gid=0")
    @Severity(SeverityLevel.TRIVIAL)
    public void pressLogoTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        PressLogoTestCase pressLogoTestCase = new PressLogoTestCase(getBrowser());

        pressLogoTestCase.doTestCase();
    }

    @Test
    @DisplayName("Создание скриншота.")
    @Description("Создается скриншот страницы, если элемент по указанному локатору не найден.")
    public void makeScreenShot() throws WrongPathOfLocatorException {
        getBrowser().goToUrl("https://www.demoblaze.com/prod.html?idp_=5");
        Logo logo = new Logo(getBrowser());

            Assertions.assertThrows(WrongPathOfLocatorException.class,
                    logo::clickWrongLogo);
    }

    @Test
    @DisplayName("Отправление сообщения в разделе 'Contact'. Все поля заполнены.")
    @Description("Тест проверяет работу формы отправления сообщения 'Contact', когда все поля ввода заполнены.")
    @Issue("https://docs.google.com/spreadsheets/d/1vIhcJpdcFD872lV3wiq0ApzRabKcImu18myEs4oaPzM/edit#gid=2038527858")
    @Severity(SeverityLevel.NORMAL)
    public void sendContactMessageAllFieldsTest()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        SendContactMessageTestCase sendContactMessageTestCase = new SendContactMessageTestCase(getBrowser(),
                "bobsmith@gmail.com", "Bob Smith", "My message.");

        sendContactMessageTestCase.doTestCase();
    }

   /* @Step("Демо шаг")
    public void demoStep () {
        System.out.println("Демо шаг.");
    }*/
}


