package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    // Кнопка 'Delete' в столбце удаления товара в таблице корзины товаров.
    // Локатор.
    private final String DELETE_LOCATOR = "td > a";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = DELETE_LOCATOR)
    WebElement delete;
    // Характеристики локатора.
    Locator deleteLocator = new Locator("Кнопка 'Delete' в столбце удаления товара в таблице корзины товаров",
            "css" ,DELETE_LOCATOR);


    // Конструктор.
    public CartPage(Browser browser) {
        super(browser);
    }

    // Клик по кнопке "Delete".
    public CartPage clickDelete () throws WrongTypeOfLocatorException {
        clickElement(delete, deleteLocator);
        return this;
    }
}
