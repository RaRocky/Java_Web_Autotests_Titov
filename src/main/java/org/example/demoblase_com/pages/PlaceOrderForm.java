package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderForm extends AbstractPage {

    // Поле ввода имени пользователя.
    // Локатор.
    private final String NAME_FIELD_LOCATOR = "name";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = NAME_FIELD_LOCATOR)
    WebElement nameField;
    // Характеристики локатора.
    Locator nameFieldLocator =
            new Locator("Поле ввода имени пользователя", TypeOfLocator.ID, NAME_FIELD_LOCATOR);

    // Поле ввода страны.
    // Локатор.
    private final String COUNTRY_LOCATOR = "country";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = COUNTRY_LOCATOR)
    WebElement countryField;
    // Характеристики локатора.
    Locator countryFieldLocator = new Locator("Поле ввода страны", TypeOfLocator.ID, COUNTRY_LOCATOR);

    // Поле ввода города
    // Локатор.
    private final String CITY_LOCATOR = "city";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = CITY_LOCATOR)
    WebElement cityField;
    // Характеристики локатора.
    Locator cityFieldLocator = new Locator("Поле ввода города", TypeOfLocator.ID, CITY_LOCATOR);

    // Поле вввода номера кредитной карты.
    // Локатор.
    private final String CREDIT_CARD_LOCATOR = "card";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = CREDIT_CARD_LOCATOR)
    WebElement creditCardField;
    // Характеристики локатора.
    Locator creditCardLocator =
            new Locator("Поле вввода номера кредитной карты", TypeOfLocator.ID, CREDIT_CARD_LOCATOR);

    // Поле ввода месяца.
    // Локатор.
    private final String MONTH_LOCATOR = "month";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = MONTH_LOCATOR)
    WebElement monthField;
    // Характеристики локатора.
    Locator monthFieldLocator = new Locator("Поле ввода месяца", TypeOfLocator.ID, MONTH_LOCATOR);

    // Поле ввода года.
    // Локатор.
    private final String YEAR_LOCATOR = "year";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = YEAR_LOCATOR)
    WebElement yearField;
    // Характеристики локатора.
    Locator yearFildLocator = new Locator("Поле ввода года", TypeOfLocator.ID, YEAR_LOCATOR);

    // Кнопка 'Purchase'.
    // Локатор.
    private final String PURCHASE_LOCATOR = "#orderModal .btn-primary";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = PURCHASE_LOCATOR)
    WebElement purchaseButton;
    // Характеристики локатора.
    Locator purchaseButtonLocator = new Locator("Кнопка 'Purchase'", TypeOfLocator.CSS, PURCHASE_LOCATOR);


    // Конструктор.
    public PlaceOrderForm(Browser browser) {
        super(browser);
    }


    // Метод, реализующий отправку вормы оформления заказа.
    public void placeOrder(String name, String country, String city, String creditCard, String month, String year)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickNameField()
                .pause()
                .enterNameField(name)
                .pause()
                .clickCountryField()
                .pause()
                .enterCountryField(country)
                .pause()
                .clickCityField()
                .pause()
                .enterCityField(city)
                .pause()
                .clickCreditCard()
                .pause()
                .enterCreditCardField(creditCard)
                .pause()
                .clickMonthField()
                .pause()
                .enterMonthField(month)
                .pause()
                .clickYearField()
                .pause()
                .enterYearField(year)
                .pause()
                .clickPurchaseButton();
    }

    // Клик по полю ввода имени пользователя.
    public PlaceOrderForm clickNameField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(nameField, nameFieldLocator);
        return this;
    }

    // Ввод имени пользователя.
    public PlaceOrderForm enterNameField(String name) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(nameField, nameFieldLocator, name);
        return this;
    }

    // Клик по полю ввода страны.
    public PlaceOrderForm clickCountryField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(countryField, countryFieldLocator);
        return this;
    }

    // Ввод страны.
    public PlaceOrderForm enterCountryField(String country) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(countryField, countryFieldLocator, country);
        return this;
    }

    // Клик по полю ввода горада.
    public PlaceOrderForm clickCityField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(cityField, cityFieldLocator);
        return this;
    }

    // Ввод города.
    public PlaceOrderForm enterCityField(String city) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(cityField, cityFieldLocator, city);
        return this;
    }

    // Клик по полю ввода кредитной карты.
    public PlaceOrderForm clickCreditCard() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(creditCardField, creditCardLocator);
        return this;
    }

    // Ввод номера кредитной карты.
    public PlaceOrderForm enterCreditCardField(String creditCard)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(creditCardField, creditCardLocator, creditCard);
        return this;
    }

    // Клик по полю ввода месяца.
    public PlaceOrderForm clickMonthField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(monthField, monthFieldLocator);
        return this;
    }

    // Ввод месяца.
    public PlaceOrderForm enterMonthField(String month) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(monthField, monthFieldLocator, month);
        return this;
    }

    // Клик по полю ввода года.
    public PlaceOrderForm clickYearField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(yearField, yearFildLocator);
        return this;
    }

    // Ввод года.
    public PlaceOrderForm enterYearField(String year) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(yearField, yearFildLocator, year);
        return this;
    }

    // Клик по кнопке 'Purchase'.
    public PlaceOrderForm clickPurchaseButton() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(purchaseButton, purchaseButtonLocator);
        return this;
    }

    // Пауза.
    public PlaceOrderForm pause() {
        try {
            Thread.sleep(getSettings().getPAUSE());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
