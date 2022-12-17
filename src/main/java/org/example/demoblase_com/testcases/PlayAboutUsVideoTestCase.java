package org.example.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта с функционалом тест-кейса №6. Проверка возможности воспроизведения видео 'About us'.
public class PlayAboutUsVideoTestCase extends AbstractTestCase {

    // Конструктор.
    public PlayAboutUsVideoTestCase(Browser browser, String testCaseName) {
        super(browser, testCaseName);
    }

    // Предусловие №1. Переход на главную страницу сайта.
    @Override
    public void precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/index.html");
    }

    // Ожидание выполнения предусловия №1.
    @Override
    public void waitOfPrecondition1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html");
    }

    // Шаг №1. Нажатие кнопки 'About us' главного меню сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickAboutUs();
    }

    // Ожидание выполнения шага №1.
    @Override
    public void waitOfStep1() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "videoModalLabel");
    }

    // Шаг №2. Нажатие на кнопку 'Play video' в окне видео-плеера.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAboutUsWindow().clickPlayVideoButton();
    }

    // Ожидание выполнения шага №2.
    @Override
    public void waitOfStep2() {
        explicitWaitOfTextContainsInElementLocated(TypeOfLocator.CSS, ".vjs-play-control", "Pause");
    }

    // Шаг №3. Нажатие на кнопку 'Close'.
    @Override
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAboutUsWindow().clickCloseButton();
    }

    // Ожидание выполнения шага №3.
    @Override
    public void waitOfStep3() {
        explicitWaitOfInvisibilityOfElementLocated(TypeOfLocator.ID, "videoModalLabel");
    }
}
