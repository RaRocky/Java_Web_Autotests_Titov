package org.example.servises.webdriver;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// Класс абстрактной страницы сайта. Содержит основные методы взаимодействия с веб-элементами сайта.
public class AbstractPage {

    private final WebDriver webDriver;  // Объект класса WebDriver.


    // Конструктор.
    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    // Геттер объект класса WebDriver.
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public boolean checkLocator(Locator locator) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

        int countOfElements;

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

        if (countOfElements == 0) {
            /*MyUtils.makeScreenshot(driver,
                    "FAILURE- org.example.lesson7.Lesson7Test" + System.currentTimeMillis() + ".png");*/
            throw new WrongPathOfLocatorException("Элемент '" + locator.getName() +
                    "' не доступен на странице (смотри скриншот). Либо ошибка в написании локатора.");
        }

        if (countOfElements > 1) {
            throw new WrongPathOfLocatorException("Элемент '" + locator.getName() +
                    "' с локатором '" + locator.getType() + " = " + locator.getPath() +
                    "' - не уникальный. Задайте другой локатор.");
        }

        else {
            System.out.println("Элемент '" + locator.getName() + "' с локатором '" + locator.getType() + " = " +
                    locator.getPath() + "' успешно найден, является уникальным.");
            return true;
        }
    }

    public void clickElement (WebElement webElement) {
        webElement.click();
    }
}
