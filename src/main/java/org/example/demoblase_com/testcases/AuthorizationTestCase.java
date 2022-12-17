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

    // Шаг №2. Клик по полю ввода имени пользователя.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().clickUserNameField();
    }

    // Шаг №3. Ввод имени пользователя.
    @Override
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().enterUserName("Bob Smith");
    }

    // Шаг №4. Клик по полю ввода пароля.
    @Override
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().clickPasswordField();
    }

    // Шаг №5. Ввод пароля.
    @Override
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().enterPassword("Enter000");
    }

    // Шаг №6. Клик по кнопке 'Log in' в форме авторизации пользователя.
    @Override
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAuthorizationForm().clickLogIn();
    }

    // Ожидание выполнения шага №6.
    @Override
    public void waitOfStep6() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
    }
}
