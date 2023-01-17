package org.example.websites.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта страницы товара.
public class ProductPage extends AbstractPage {

    // Кнопка 'Add to cart'.
    // Локатор.
    private final String ADD_TO_CART_LOCATOR = ".btn-success";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = ADD_TO_CART_LOCATOR)
    WebElement addToCartButton;
    // Характеристики локатора.
    Locator addToCartLocator = new Locator("Кнопка 'Add to cart'", TypeOfLocator.CSS, ADD_TO_CART_LOCATOR);

    // Конструктор.
    public ProductPage(Browser browser) {
        super(browser);
    }


    // Клик по кнопке 'Add to cart'.
    public ProductPage clickAddToCartButton()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(addToCartButton, addToCartLocator);
        return this;
    }
}
