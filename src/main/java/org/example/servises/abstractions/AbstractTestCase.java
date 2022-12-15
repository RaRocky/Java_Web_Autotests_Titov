package org.example.servises.abstractions;

import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;

// Класс абстрактного тест кейса. Содержит общие методы для всех тест кейсов.
public class AbstractTestCase {

    // Объект класса Browser для управления браузером при помощи Selenium Web Driver.
    private final Browser browser;
    // Время явного ожидания выполнения предусловия или шага в секундах.
    private final int EXPLICIT_WAIT_TIME = 5;


    // Конструктор.
    public AbstractTestCase(Browser browser) {
        this.browser = browser;
    }


    // Геттер объекта класса Browser.
    public Browser getBrowser() {
        return browser;
    }
    // Геттер времени явного ожидания.
    public int getEXPLICIT_WAIT_TIME() {
        return EXPLICIT_WAIT_TIME;
    }

    // Метод, выполняющий все шаги тест-кейса.
    public void doTestCase(int explicitWaitTime) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        precondition1();
        waitOfPrecondition1(explicitWaitTime);
        precondition2();
        waitOfPrecondition2(explicitWaitTime);
        step1();
        waitOfStep1(explicitWaitTime);
        step2();
        waitOfStep2(explicitWaitTime);
        step3();
        waitOfStep3(explicitWaitTime);
        step4();
        waitOfStep4(explicitWaitTime);
        step5();
        waitOfStep5(explicitWaitTime);
        step6();
        waitOfStep6(explicitWaitTime);
    }

    // Предусловие №1.
    public void precondition1() {

    }

    // Ожидание выполнения предусловия №1.
    public void waitOfPrecondition1(int explicitWaitTime) {

    }

    // Предусловие №2.
    public void precondition2() {

    }

    // Ожидание выполнения предусловия №2.
    public void waitOfPrecondition2(int explicitWaitTime) {

    }

    // Шаг №1.
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №1.
    public void waitOfStep1(int explicitWaitTime) {

    }

    // Шаг №2.
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №2.
    public void waitOfStep2(int explicitWaitTime) {

    }

    // Шаг №3.
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №3.
    public void waitOfStep3(int explicitWaitTime) {

    }

    // Шаг №4.
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №4.
    public void waitOfStep4(int explicitWaitTime) {

    }

    // Шаг №5.
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №5.
    public void waitOfStep5(int explicitWaitTime) {

    }

    // Шаг №6.
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №6.
    public void waitOfStep6(int explicitWaitTime) {

    }
}
