package org.example.servises.abstractions;

import org.example.servises.MyUtils;
import org.example.servises.Settings;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    /*// Шаблон.
    // Локатор.
    private final String _LOCATOR =;
    // Поиск при помощи паттерна PageFactory.
    @FindBy()
    WebElement ;
    // Характеристики локатора.
    Locator  = new Locator(, ,);*/


// Класс абстрактной страницы сайта. Содержит основные методы взаимодействия с веб-элементами сайта.
public class AbstractPage {

    static Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    // Объект класса WebDriver.
    private final WebDriver webDriver;

    // Объект настроек проекта.
    private Settings settings;


    // Конструктор.
    public AbstractPage(Browser browser) {
        this.settings = new Settings();
        this.webDriver = browser.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }


    // Методы класса.
    // Проверка локатора на наличе в DOM-структуре и уникальность.
    public boolean checkLocator(Locator locator)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        String message;

        // Целочисленная переменная для подсчета количества элементов в DOM-структуре, имеющих заданный локатор.
        int countOfElements;

        // Подсчет количества элементов осуществляется при помощи метода webDriver.findElements().size().
        // Выбор варианта поиска элементов, в зависимости от типа локатора.
        switch (locator.getType()) {
            case ID:
                countOfElements = webDriver.findElements(By.id(locator.getPath())).size();
                break;

            case CSS:
                countOfElements = webDriver.findElements(By.cssSelector(locator.getPath())).size();
                break;

            case XPATH:
                countOfElements = webDriver.findElements(By.xpath(locator.getPath())).size();
                break;

            default:
                message = "Неверно указан тип локатора для элемента '" +
                        locator.getName() + "'. Возможные варианты: 'ID', 'CSS', 'XPATH'.";
                logger.error(message);
                throw new WrongTypeOfLocatorException(message);
        }

        // Если количество элементов в результате поиска оказалось равно нулю, значит, элемента с заданным локатором
        // нет в DOM-структуре открытой страницы сайта. Либо локатор задан с ошибкой.

        if (countOfElements == 0) {
            MyUtils.makeScreenshot(getWebDriver(),
                    "FAILURE- org.example.demoblase_tests.DemoblaseTest" + System.currentTimeMillis() + ".png");
            message = "Элемент '" + locator.getName() +
                    "' не доступен на странице (смотри скриншот). Либо ошибка в написании локатора.";
            logger.error(message);
            throw new WrongPathOfLocatorException(message);
        }

        // Если поиск элементов показал, что таковых найдено больше 1, это значит, что заданный локатор не уникален.
        if (countOfElements > 1) {
            message = "Элемент '" + locator.getName() +
                    "' с локатором '" + locator.getType() + " = " + locator.getPath() +
                    "' - не уникальный. Задайте другой локатор.";
            logger.error(message);
            throw new WrongPathOfLocatorException(message);
        }

        // Положительный результат проверки локатора на наличе в DOM-структуре и уникальность.
        else {
            message = "Элемент '" + locator.getName() + "' с локатором '" + locator.getType() + " = " +
                    locator.getPath() + "' успешно найден, является уникальным.";
            logger.info(message);
            return true;
        }
    }

    // Клик по веб-элементу.
    public void clickElement(WebElement webElement, Locator locator)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(locator)) webElement.click();
    }

    // Ввод текста в поле ввода.
    public void enterText(WebElement webElement, Locator locator, String text)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        if (checkLocator(locator)) webElement.sendKeys(text);
    }

    // Получение текста веб-элемента.
    public String getElementText(WebElement webElement, Locator locator)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        if (checkLocator(locator)) return webElement.getText();
        else return null;
    }


    // Геттеры.
    // Геттер объект класса WebDriver.
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    // Геттер объекта настроек проекта.
    public Settings getSettings() {
        return settings;
    }
}
