package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс главного меню сайта.
public class MainMenu extends AbstractPage {

    // Кнопка 'Log in'.
    // Локатор кнопки 'Log in'.
    private final String LOGIN_LOCATOR = "login2";

    // Поиск кнопки 'Log in' при помощи паттерна PageFactory.
    @FindBy(id = LOGIN_LOCATOR)
    WebElement logIn;

    // Характеристики кнопки "Log in".
    Locator logInLocator = new Locator("Кнопка 'Log in' главного меню сайта", "id", LOGIN_LOCATOR);


    // Конструктор.
    public MainMenu(WebDriver webDriver) {
        super(webDriver);
    }


    // Клик по кнопке 'Log in'.
    public MainMenu clickLogIn() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(logInLocator)) logIn.click();
        return this;
    }
}
