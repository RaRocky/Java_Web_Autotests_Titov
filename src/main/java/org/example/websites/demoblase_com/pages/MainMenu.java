package org.example.websites.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта главного меню сайта.
public class MainMenu extends AbstractPage {

    // Кнопка 'Contact' главного меню сайта.
    // Локатор.
    private final String CONTACT_LOCATOR = ".nav-item:nth-child(2) > .nav-link";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = CONTACT_LOCATOR)
    WebElement contact;
    // Характеристики локатора.
    Locator contactLocator =
            new Locator("Кнопка 'Contact' главного меню сайта", TypeOfLocator.CSS, CONTACT_LOCATOR);

    // Кнопка 'About us' главного меню сайта.
    // Локатор.
    private final String ABOUT_US_LOCATOR = ".nav-item:nth-child(3) > .nav-link";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = ABOUT_US_LOCATOR)
    WebElement aboutUs;
    // Характеристики локатора.
    Locator aboutUsLocator =
            new Locator("Кнопка 'About us' главного меню сайта", TypeOfLocator.CSS, ABOUT_US_LOCATOR);

    // Кнопка 'Cart' главного меню сайта.
    // Локатор.
    private final String CART_LOCATOR = "cartur";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = CART_LOCATOR)
    WebElement cart;
    // Характеристики локатора.
    Locator cartLocator = new Locator("Кнопка 'Cart' главного меню сайта", TypeOfLocator.ID, CART_LOCATOR);

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


    // Клик по кнопке 'Contact'.
    public MainMenu clickContact() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(contact, contactLocator);
        return this;
    }

    // Клик по кнопке 'About us'.
    public MainMenu clickAboutUs () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(aboutUs, aboutUsLocator);
        return this;
    }

    // Клик по кнопке 'Cart'.
    public MainMenu clickCart() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(cart, cartLocator);
        return this;
    }

    // Клик по кнопке 'Log in'.
    public MainMenu clickLogIn() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(logIn, logInLocator);
        return this;
    }
}
