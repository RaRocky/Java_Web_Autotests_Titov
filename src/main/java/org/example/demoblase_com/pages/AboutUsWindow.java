package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта окна 'About us'.
public class AboutUsWindow extends AbstractPage {

    // Кнопка 'Play Video'.
    // Локатор.
    private final String PLAY_VIDEO_LOCATOR = ".vjs-big-play-button";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = PLAY_VIDEO_LOCATOR)
    WebElement playVideoButton;
    // Характеристики локатора.
    Locator playVideoButtonLocator = new Locator("Кнопка 'Play Video'", TypeOfLocator.CSS, PLAY_VIDEO_LOCATOR);

    // Кнопка 'Close'.
    // Локатор.
    private final String CLOSE_LOCATOR = "#videoModal .btn";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = CLOSE_LOCATOR)
    WebElement closeButton;
    // Характеристики локатора.
    Locator closeButtonLocator = new Locator("Кнопка 'Close'", TypeOfLocator.CSS, CLOSE_LOCATOR);


    // Конструктор.
    public AboutUsWindow(Browser browser) {
        super(browser);
    }


    // Клик по кнопке 'Play Video'.
    public AboutUsWindow clickPlayVideoButton() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(playVideoButton, playVideoButtonLocator);
        return this;
    }

    // Клик по кнопке 'Close'.
    public AboutUsWindow clickCloseButton () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(closeButton, closeButtonLocator);
        return this;
    }
}
