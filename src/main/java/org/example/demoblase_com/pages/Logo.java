package org.example.demoblase_com.pages;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.AbstractPage;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Главный логотип сайта.
public class Logo extends AbstractPage {

    // Главный логотип сайта.
    // Локатор главного логотипа сайта.
    private final String LOGO_LOCATOR = "nava";

    // Поиск главного логотипа сайта при помощи паттерна PageFactory.
    @FindBy(id = LOGO_LOCATOR)
    WebElement logo;

    // Характеристики главного логотипа сайта.
    Locator logoLocator = new Locator("Главный логотип сайта", "id", LOGO_LOCATOR);

    // Конструктор.
    public Logo(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickLogo() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(logoLocator)) clickElement(logo);
    }
}
