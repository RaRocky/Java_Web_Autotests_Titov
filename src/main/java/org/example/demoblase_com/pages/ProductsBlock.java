package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsBlock extends AbstractPage {

    // Ссылка на страницу продукта 'ASUS Full HD' в карточке товара.
    // Локатор.
    private final String ASUS_FULL_HD_LOCATOR = ".//a[contains(text(),'ASUS Full HD')]";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(xpath = ASUS_FULL_HD_LOCATOR)
    WebElement asusFullHdMonitor;
    // Характеристики локатора.
    Locator asusFullHdMonitorLocator =
            new Locator("Ссылка на страницу товара 'ASUS Full HD'", "xpath" , ASUS_FULL_HD_LOCATOR);


    // Конструктор.
    public ProductsBlock(Browser browser) {
        super(browser);
    }


    // Клик по ссылке на страницу продукта 'ASUS Full HD' в карточке товара.
    public ProductsBlock clickAsusFullHd () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(asusFullHdMonitor, asusFullHdMonitorLocator);
        return this;
    }
}
