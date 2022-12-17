package org.example.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс объекта с функционалом тест-кейса №2. Авторизация пользователя.
public class AuthorizationTestCase extends AbstractTestCase {

    // Конструктор.
    public AuthorizationTestCase(Browser browser) {
        super(browser, "Авторизация пользователя");
    }


    // Предусловие. Переход на главную страницу сайта.
    @Override
    public void precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/index.html");
    }

    // Ожидание выполнения предусловия.
    @Override
    public void waitOfPrecondition1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html");
    }

    // Шаг №1. Нажатие на кнопку 'Log in' главного меню сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickLogIn();
    }

    // Ожидание выполнения шага №1.
    @Override
    public void waitOfStep1() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "logInModal");
    }

    // Шаг №2. Авторизация пользователя.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().logIn("Bob Smith", "Enter000");
    }

    // Ожидание выполнения шага №2.
    @Override
    public void waitOfStep6() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
    }
}
