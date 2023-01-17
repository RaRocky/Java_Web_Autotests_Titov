package org.example.websites.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта с функционалом тест-кейса №2. Авторизация пользователя.
public class AuthorizationTestCase extends AbstractTestCase {

    // Имя пользователя.
    private final String userName;
    // Пароль.
    private final String password;
    // Текст всплывающего уведомления.
    private final String alertText;


    // Конструкторы.
    // Конструктор для позитивного теста авторизации.
    public AuthorizationTestCase(Browser browser, String userName, String password) {
        super(browser, "Авторизация пользователя");
        this.userName = userName;
        this.password = password;
        this.alertText = null;
    }

    // Конструктор для негативного теста авторизации.
    public AuthorizationTestCase(Browser browser, String userName, String password, String alertText) {
        super(browser, "Авторизация пользователя");
        this.userName = userName;
        this.password = password;
        this.alertText = alertText;
    }


    // Предусловие. Переход на главную страницу сайта.
    @Override
    public AbstractTestCase precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/index.html");
        return super.precondition1();
    }

    // Ожидание выполнения предусловия.
    @Override
    public AbstractTestCase waitOfPrecondition1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html");
        return super.waitOfPrecondition1();
    }

    // Проверка выполнения предусловия.
    @Override
    public AbstractTestCase checkOfPrecondition1() {
        assertOfUrlContains("https://www.demoblaze.com/index.html");
        return super.checkOfPrecondition1();
    }


    // Шаг №1. Нажатие на кнопку 'Log in' главного меню сайта.
    @Override
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickLogIn();
        return super.step1();
    }

    // Ожидание выполнения шага №1.
    @Override
    public AbstractTestCase waitOfStep1() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "logInModal");
        return super.waitOfStep1();
    }


    // Шаг №2. Авторизация пользователя.
    @Override
    public AbstractTestCase step2()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().logIn(userName, password);
        return super.step2();
    }

    // Ожидание выполнения шага №2.
    @Override
    public AbstractTestCase waitOfStep2() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
        return super.waitOfStep2();
    }

    // Проверка выполнения шага №2.
    @Override
    public AbstractTestCase checkOfStep2() {
        assertOfWebElementText(TypeOfLocator.ID, "nameofuser", "Welcome Bob Smith");
        return super.checkOfStep2();
    }
}
