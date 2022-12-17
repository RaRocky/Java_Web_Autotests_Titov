package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта меню категорий товаров.
public class CategoriesMenu extends AbstractPage {

    // Кнопка 'Monitors' меню категорий товаров.
    // Локатор кнопки 'Monitors' меню категорий товаров.
    private final String MONITORS_LOCATOR = "(//a[@id='itemc'])[3]";
    // Поиск кнопки 'Monitors' меню категорий товаров при помощи паттерна PageFactory.
    @FindBy(xpath = MONITORS_LOCATOR)
    WebElement monitors;
    // Характеристики кнопки 'Monitors' меню категорий товаров.
    Locator monitorsLocator =
            new Locator("Кнопка 'Monitors' меню категорий товаров", TypeOfLocator.XPATH, MONITORS_LOCATOR);


    // Конструктор.
    public CategoriesMenu(Browser browser) {
        super(browser);
    }


    // Клик по кнопке 'Monitors' меню категорий товаров.
    public CategoriesMenu clickMonitors () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(monitors, monitorsLocator);
        return this;
    }
}
