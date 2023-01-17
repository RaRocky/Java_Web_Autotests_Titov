package org.example.websites.demoblase_com.pages;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.abstractions.AbstractPage;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта главного логотип сайта.
public class Logo extends AbstractPage {

    // Главный логотип сайта.
    // Локатор главного логотипа сайта.
    private final String LOGO_LOCATOR = "nava";
    // Поиск главного логотипа сайта при помощи паттерна PageFactory.
    @FindBy(id = LOGO_LOCATOR)
    WebElement logo;
    // Характеристики главного логотипа сайта.
    Locator logoLocator = new Locator("Главный логотип сайта", TypeOfLocator.ID, LOGO_LOCATOR);

    // Главный логотип сайта с ложным локатором.
    // Локатор главного логотипа сайта с ложным локатором.
    private final String WRONG_LOGO_LOCATOR = "nova";
    // Поиск главного логотипа сайта при помощи паттерна PageFactory.
    @FindBy(id = WRONG_LOGO_LOCATOR)
    WebElement wrongLogo;
    // Характеристики главного логотипа сайта.
    Locator wrongLogoLocator = new Locator("Главный логотип сайта с ложным локатором",
            TypeOfLocator.ID, WRONG_LOGO_LOCATOR);


    // Конструктор.
    public Logo(Browser browser) {
        super(browser);
    }


    // Клик по главному логотипу сайта.
    public void clickLogo() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(logo, logoLocator);
    }

    // Клик по главному логотипу сайта с ложным локатором.
    public void clickWrongLogo() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(wrongLogo, wrongLogoLocator);
    }
}
