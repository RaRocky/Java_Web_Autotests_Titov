package org.example.demoblase_com.pages;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.abstractions.AbstractPage;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта формы авторизации пользователя.
public class AuthorizationForm extends AbstractPage {

    // Поле ввода имени пользователя.
    // Локатор поля ввода имени пользователя.
    private final String USERNAME_LOCATOR = "loginusername";
    // Поиск поля ввода имени пользователя при помощи паттерна PageFactory.
    @FindBy(id = USERNAME_LOCATOR)
    WebElement userName;
    // Характеристики поля ввода имени пользователя.
    Locator userNameLocator = new Locator("Поле ввода имени пользователя", TypeOfLocator.ID, USERNAME_LOCATOR);


    // Поле ввода пароля.
    // Локатор поля ввода пароля.
    private final String PASSWORD_LOCATOR = "loginpassword";
    // Поиск поля ввода пароля при помощи паттерна PageFactory.
    @FindBy(id = PASSWORD_LOCATOR)
    WebElement password;
    // Характеристики поля ввода пароля.
    Locator passwordLocator = new Locator("Поле ввода пароля", TypeOfLocator.ID, PASSWORD_LOCATOR);


    // Кнопка 'Log in'.
    // Локатор кнопки 'Log in'.
    private final String LOGIN_LOCATOR = "#logInModal .btn-primary";
    // Поиск кнопки 'Log in' при помощи паттерна PageFactory.
    @FindBy(css = LOGIN_LOCATOR)
    WebElement logInButton;
    // Характеристики кнопки "Log in".
    Locator logInButtonLocator = new Locator("Кнопка 'Log in' формы авторизации", TypeOfLocator.CSS, LOGIN_LOCATOR);


    // Конструктор.
    public AuthorizationForm(Browser browser) {
        super(browser);
    }


    // Метод, осуществляющий авторизацию пользователя.
    public void logIn (String userName, String password)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickUserNameField()
                .pause()
                .enterUserName(userName)
                .pause()
                .clickPasswordField()
                .pause()
                .enterPassword(password)
                .pause()
                .clickLogInButton();
    }

    // Клик по полю ввода имени пользователя.
    public AuthorizationForm clickUserNameField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(userName, userNameLocator);
        return this;
    }

    // Ввод имени пользователя.
    public AuthorizationForm enterUserName(String nameOfUser)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(userName, userNameLocator, "Bob Smith");
        return this;
    }

    // Клик по полю ввода пароля.
    public AuthorizationForm clickPasswordField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(password, passwordLocator);
        return this;
    }

    // Ввод пароля.
    public AuthorizationForm enterPassword(String passwd)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(password, passwordLocator, "Enter000");
        return this;
    }

    // Клик по кнопке 'Log in'.
    public AuthorizationForm clickLogInButton()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(logInButton, logInButtonLocator);
        return this;
    }

    // Пауза.
    public AuthorizationForm pause() {
        try {
            Thread.sleep(getSettings().getPAUSE());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


}
