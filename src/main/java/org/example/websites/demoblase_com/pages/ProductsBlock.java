package org.example.websites.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта блока товаров.
public class ProductsBlock extends AbstractPage {

    // Ссылка на страницу продукта 'ASUS Full HD' в карточке товара.
    // Локатор.
    private final String ASUS_FULL_HD_LOCATOR = ".//a[contains(text(),'ASUS Full HD')]";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(xpath = ASUS_FULL_HD_LOCATOR)
    WebElement asusFullHdMonitor;
    // Характеристики локатора.
    Locator asusFullHdMonitorLocator =
            new Locator("Ссылка на страницу товара 'ASUS Full HD'", TypeOfLocator.XPATH , ASUS_FULL_HD_LOCATOR);

    // Ссылка на страницу продукта 'Sony vaio i5' в карточке товара.
    // Локатор.
    private final String SONY_VIO_I5_LOCATOR = ".//a[contains(text(),'Sony vaio i5')]";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(xpath = ".//a[contains(text(),'Sony vaio i5')]")
    WebElement sonyVioI5Laptop;
    // Характеристики локатора.
    Locator sonyVioI5LaptopLocator =
            new Locator("Ссылка на страницу продукта 'Sony vaio i5'", TypeOfLocator.XPATH ,SONY_VIO_I5_LOCATOR);


    // Конструктор.
    public ProductsBlock(Browser browser) {
        super(browser);
    }


    // Клик по ссылке на страницу продукта 'ASUS Full HD' в карточке товара.
    public ProductsBlock clickAsusFullHd () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(asusFullHdMonitor, asusFullHdMonitorLocator);
        return this;
    }

    // Клик по ссылке на страницу продукта 'Sony vaio i5' в карточке товара.
    public ProductsBlock clickSonyVioI5 () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(sonyVioI5Laptop, sonyVioI5LaptopLocator);
        return this;
    }
}
