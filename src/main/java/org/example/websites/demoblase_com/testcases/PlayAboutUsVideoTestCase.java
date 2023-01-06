package org.example.websites.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта с функционалом тест-кейса №6. Проверка возможности воспроизведения видео 'About us'.
public class PlayAboutUsVideoTestCase extends AbstractTestCase {

    // Конструктор.
    public PlayAboutUsVideoTestCase(Browser browser) {
        super(browser, "Проверка возможности воспроизведения видео 'About us'");
    }


    // Предусловие №1. Переход на главную страницу сайта.
    @Override
    public AbstractTestCase precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/index.html");
        return super.precondition1();
    }

    // Ожидание выполнения предусловия №1.
    @Override
    public AbstractTestCase waitOfPrecondition1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html");
        return super.waitOfPrecondition1();
    }

    // Проверка выполнения предусловия №1.
    @Override
    public AbstractTestCase checkOfPrecondition1() {
        assertOfUrlContains("https://www.demoblaze.com/index.html");
        return super.checkOfPrecondition1();
    }


    // Шаг №1. Нажатие кнопки 'About us' главного меню сайта.
    @Override
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickAboutUs();
        return super.step1();
    }

    // Ожидание выполнения шага №1.
    @Override
    public AbstractTestCase waitOfStep1() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "videoModalLabel");
        return super.waitOfStep1();
    }


    // Шаг №2. Нажатие на кнопку 'Play video' в окне видео-плеера.
    @Override
    public AbstractTestCase step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAboutUsWindow().clickPlayVideoButton();
        return super.step2();
    }

    // Ожидание выполнения шага №2.
    @Override
    public AbstractTestCase waitOfStep2() {
        explicitWaitOfTextContainsInElementLocated(TypeOfLocator.CSS, ".vjs-play-control", "Pause");
        return super.waitOfStep2();
    }

    // Проверка выполнения шага №2.
    @Override
    public AbstractTestCase checkOfStep2() {
        assertOfWebElementText(TypeOfLocator.CSS, ".vjs-play-control", "Pause");
        return super.checkOfStep2();
    }


    // Шаг №3. Нажатие на кнопку 'Close'.
    @Override
    public AbstractTestCase step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAboutUsWindow().clickCloseButton();
        return super.step3();
    }

    // Ожидание выполнения шага №3.
    @Override
    public AbstractTestCase waitOfStep3() {
        explicitWaitOfInvisibilityOfElementLocated(TypeOfLocator.ID, "videoModalLabel");
        return super.waitOfStep3();
    }
}
