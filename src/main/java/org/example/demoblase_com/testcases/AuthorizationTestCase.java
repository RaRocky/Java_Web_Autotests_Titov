package org.example.demoblase_com.testcases;

import org.example.demoblase_com.pages.AuthorizationForm;
import org.example.demoblase_com.pages.MainMenu;
import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс объекта с функционалом тест-кейса №2. Авторизация пользователя.
public class AuthorizationTestCase extends AbstractTestCase {

    // Объект главного меню сайта.
    MainMenu mainMenu = new MainMenu(getBrowser().getWebDriver());
    // Объект формы авторизации пользователя.
    AuthorizationForm authorizationForm = new AuthorizationForm(getBrowser().getWebDriver());


    // Конструктор.
    public AuthorizationTestCase(Browser browser) {
        super(browser);
    }


    // Предусловие.
    @Override
    public void precondition() {
        getBrowser().goToUrl("https://www.demoblaze.com/index.html");
    }

    // Ожидание выполнения предусловия.
    @Override
    public void waitOfPrecondition() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/index.html"));
    }

    // Шаг №1. Нажатие на кнопку 'Log in' главного меню сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        mainMenu.clickLogIn();
    }

    // Ожидание выполнения шага №1.
    @Override
    public void waitOfStep1() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("logInModal")));
    }

    // Шаг №2. Клик по полю ввода имени пользователя.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        authorizationForm.clickUserNameField();
    }

    // Шаг №3. Ввод имени пользователя.
    @Override
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        authorizationForm.enterUserName("Bob Smith");
    }

    // Шаг №4. Клик по полю ввода пароля.
    @Override
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        authorizationForm.clickPasswordField();
    }

    // Шаг №5. Ввод пароля.
    @Override
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        authorizationForm.enterPassword("Enter000");
    }

    // Шаг №6. Клик по кнопке 'Log in' в форме авторизации пользователя.
    @Override
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        authorizationForm.clickLogIn();
    }

    // Ожидание выполнения шага №6.
    @Override
    public void waitOfStep6() {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("nameofuser")));
    }
}
