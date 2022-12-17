package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта страницы корзины товаров.
public class CartPage extends AbstractPage {

    // Кнопка 'Delete' в столбце удаления товара в таблице корзины товаров.
    // Локатор.
    private final String DELETE_LOCATOR = "td > a";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = DELETE_LOCATOR)
    WebElement delete;
    // Характеристики локатора.
    Locator deleteLocator = new Locator("Кнопка 'Delete' в столбце удаления товара в таблице корзины товаров",
            TypeOfLocator.CSS, DELETE_LOCATOR);

    // Кнопка 'Place order'.
    // Локатор.
    private final String PLACE_ORDER_LOCATOR = ".btn-success";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = PLACE_ORDER_LOCATOR)
    WebElement placeOrderButton;
    // Характеристики локатора.
    Locator placeOrderButtonLocator = new Locator("Кнопка 'Place order'", TypeOfLocator.CSS, PLACE_ORDER_LOCATOR);


    // Конструктор.
    public CartPage(Browser browser) {
        super(browser);
    }


    // Клик по кнопке "Delete".
    public CartPage clickDelete() throws WrongTypeOfLocatorException {
        clickElement(delete, deleteLocator);
        return this;
    }

    // Клик по кнопке 'Place order'.
    public CartPage clickPlaceOrderButton () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(placeOrderButton, placeOrderButtonLocator);
        return this;
    }
}
