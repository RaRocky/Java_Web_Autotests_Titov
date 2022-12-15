package org.example.servises.abstractions;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;

// Класс абстрактного тест кейса. Содержит общие методы для всех тест кейсов.
public class AbstractTestCase {

    // Объект класса Browser для управления браузером при помощи Selenium Web Driver.
    private final Browser browser;


    // Конструктор.
    public AbstractTestCase(Browser browser) {
        this.browser = browser;
    }


    // Геттер объекта класса Browser.
    public Browser getBrowser() {
        return browser;
    }

    // Метод, выполняющий все шаги тест-кейса.
    public void doTestCase() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        precondition();
        waitOfPrecondition();
        step1();
        waitOfStep1();
        step2();
        waitOfStep2();
        step3();
        waitOfStep3();
        step4();
        waitOfStep4();
        step5();
        waitOfStep5();
        step6();
        waitOfStep6();
    }

    // Предусловие.
    public void precondition() {

    }

    // Ожидание выполнения предусловия.
    public void waitOfPrecondition() {

    }

    // Шаг №1.
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №1.
    public void waitOfStep1() {

    }

    // Шаг №2.
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №2.
    public void waitOfStep2() {

    }

    // Шаг №3.
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №3.
    public void waitOfStep3() {

    }

    // Шаг №4.
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №4.
    public void waitOfStep4() {

    }

    // Шаг №5.
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №5.
    public void waitOfStep5() {

    }

    // Шаг №6.
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №6.
    public void waitOfStep6() {

    }
}
