package org.example.servises.abstractions;

import org.example.demoblase_com.pages.AsusFullHdMonitorPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

    /*// Шаблон.
    // Локатор.
    private final String = _LOCATOR;
    // Поиск при помощи паттерна PageFactory.
    @FindBy()
    WebElement ;
    // Характеристики локатора.
    Locator  = new Locator(, ,);*/


// Класс абстрактной страницы сайта. Содержит основные методы взаимодействия с веб-элементами сайта.
public class AbstractPage {

    // Время паузы между действиями в миллмсекундах.
    private final long PAUSE = 500;

    // Объект класса WebDriver.
    private final WebDriver webDriver;




    // Конструктор.
    public AbstractPage(Browser browser) {
        this.webDriver = browser.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }


    // Геттер объект класса WebDriver.
    public WebDriver getWebDriver() {
        return this.webDriver;
    }


    // Проверка локатора на наличе в DOM-структуре и уникальность.
    public boolean checkLocator(Locator locator)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        // Целочисленная переменная для подсчета количества элементов в DOM-структуре, имеющих заданный локатор.
        int countOfElements;

        // Подсчет количества элементов осуществляется при помощи метода webDriver.findElements().size().
        // Выбор варианта поиска элементов, в зависимости от типа локатора.
        switch (locator.getType()) {
            case "id":
                countOfElements = webDriver.findElements(By.id(locator.getPath())).size();
                break;

            case "css":
                countOfElements = webDriver.findElements(By.cssSelector(locator.getPath())).size();
                break;

            case "xpath":
                countOfElements = webDriver.findElements(By.xpath(locator.getPath())).size();
                break;

            default:
                throw new WrongTypeOfLocatorException("Неверно указан тип локатора для элемента '" +
                        locator.getName() + "'. Возможные варианты: 'id', 'css', 'xpath'.");
        }

        // Если количество элементов в результате поиска оказалось равно нулю, значит, элемента с заданным локатором
        // нет в DOM-структуре открытой страницы сайта. Либо локатор задан с ошибкой.
        if (countOfElements == 0) {
            /*MyUtils.makeScreenshot(driver,
                    "FAILURE- org.example.lesson7.Lesson7Test" + System.currentTimeMillis() + ".png");*/
            throw new WrongPathOfLocatorException("Элемент '" + locator.getName() +
                    "' не доступен на странице (смотри скриншот). Либо ошибка в написании локатора.");
        }

        // Если поиск элементов показал, что таковых найдено больше 1, это значит, что заданный локатор не уникален.
        if (countOfElements > 1) {
            throw new WrongPathOfLocatorException("Элемент '" + locator.getName() +
                    "' с локатором '" + locator.getType() + " = " + locator.getPath() +
                    "' - не уникальный. Задайте другой локатор.");
        }

        // Положительный результат проверки локатора на наличе в DOM-структуре и уникальность.
        else {
            System.out.println("Элемент '" + locator.getName() + "' с локатором '" + locator.getType() + " = " +
                    locator.getPath() + "' успешно найден, является уникальным.");
            return true;
        }
    }

    // Пауза.
    public void pause() {
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Клик по веб-элементу.
    public void clickElement(WebElement webElement, Locator locator)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        pause();
        if (checkLocator(locator)) webElement.click();
    }

    // Ввод текста в поле ввода.
    public void enterText(WebElement webElement, Locator locator, String text)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        pause();
        if (checkLocator(locator)) webElement.sendKeys(text);
    }


}
