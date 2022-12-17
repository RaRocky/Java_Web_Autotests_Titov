package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс главного меню сайта.
public class MainMenu extends AbstractPage {

    // Кнопка 'Cart' главного меню сайта.
    // Локатор.
    private final String CART = "cartur";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = CART)
    WebElement cart;
    // Характеристики локатора.
    Locator cartLocator = new Locator( "Кнопка 'Cart' главного меню сайта", TypeOfLocator.ID , CART);

    // Кнопка 'Log in' главного меню сайта.
    // Локатор кнопки 'Log in'.
    private final String LOGIN_LOCATOR = "login2";
    // Поиск кнопки 'Log in' при помощи паттерна PageFactory.
    @FindBy(id = LOGIN_LOCATOR)
    WebElement logIn;
    // Характеристики кнопки "Log in".
    Locator logInLocator = new Locator("Кнопка 'Log in' главного меню сайта", TypeOfLocator.ID, LOGIN_LOCATOR);


    // Конструктор.
    public MainMenu(Browser browser) {
        super(browser);
    }


    // Клик по кнопке 'Cart'.
    public MainMenu clickCart () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(cart, cartLocator);
        return this;
    }

    // Клик по кнопке 'Log in'.
    public MainMenu clickLogIn() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(logIn, logInLocator);
        return this;
    }
}
