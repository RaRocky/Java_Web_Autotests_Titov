package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsusFullHdMonitorPage extends AbstractPage {

    // Кнопка 'Add to cart'.
    // Локатор.
    private final String ADD_TO_CART_LOCATOR = ".btn-success";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = ADD_TO_CART_LOCATOR)
    WebElement addToCartButton;
    // Характеристики локатора.
    Locator addToCartLocator = new Locator("Кнопка 'Add to cart'", "css", ADD_TO_CART_LOCATOR);

    // Конструктор.
    public AsusFullHdMonitorPage(Browser browser) {
        super(browser);
    }


    // Клик по кнопке 'Add to cart'.
    public AsusFullHdMonitorPage clickAddToCartButton ()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(addToCartButton, addToCartLocator);
        return this;
    }
}
