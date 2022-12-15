package org.example.demoblase_com.pages;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.abstractions.AbstractPage;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.BrowserName;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс формы авторизации пользователя.
public class AuthorizationForm extends AbstractPage {

    // Поле ввода имени пользователя.
    // Локатор поля ввода имени пользователя.
    private final String USERNAME_LOCATOR = "loginusername";

    // Поиск поля ввода имени пользователя при помощи паттерна PageFactory.
    @FindBy(id = USERNAME_LOCATOR)
    WebElement userName;

    // Характеристики поля ввода имени пользователя.
    Locator userNameLocator = new Locator("Поле ввода имени пользователя", "id", USERNAME_LOCATOR);


    // Поле ввода пароля.
    // Локатор поля ввода пароля.
    private final String PASSWORD_LOCATOR = "loginpassword";

    // Поиск поля ввода пароля при помощи паттерна PageFactory.
    @FindBy(id = PASSWORD_LOCATOR)
    WebElement password;

    // Характеристики поля ввода пароля.
    Locator passwordLocator = new Locator("Поле ввода пароля", "id", PASSWORD_LOCATOR);


    // Кнопка 'Log in'.
    // Локатор кнопки 'Log in'.
    private final String LOGIN_LOCATOR = "#logInModal .btn-primary";

    // Поиск кнопки 'Log in' при помощи паттерна PageFactory.
    @FindBy(css = LOGIN_LOCATOR)
    WebElement logIn;

    // Характеристики кнопки "Log in".
    Locator logInLocator = new Locator("Кнопка 'Log in' формы авторизации", "css", LOGIN_LOCATOR);


    // Конструктор.
    public AuthorizationForm(Browser browser) {
        super(browser);
    }


    // Клик по полю ввода имени пользователя.
    public AuthorizationForm clickUserNameField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(userNameLocator)) userName.click();
        return this;
    }

    // Ввод имени пользователя.
    public AuthorizationForm enterUserName(String nameOfUser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(userNameLocator)) enterText(userName, "Bob Smith");
        return this;
    }

    // Клик по полю ввода пароля.
    public AuthorizationForm clickPasswordField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(passwordLocator)) password.click();
        return this;
    }

    // Ввод пароля.
    public AuthorizationForm enterPassword(String passwd)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(passwordLocator)) enterText(password, "Enter000");
        return this;
    }

    // Клик по кнопке 'Log in'.
    public AuthorizationForm clickLogIn()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(logInLocator)) logIn.click();
        return this;
    }

    // Пауза.
    public AuthorizationForm pause(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
