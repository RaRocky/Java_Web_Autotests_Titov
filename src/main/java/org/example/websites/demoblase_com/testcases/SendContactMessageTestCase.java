package org.example.websites.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта с функционалом тест-кейса №5. Отправление сообщения в разделе Contact.
public class SendContactMessageTestCase extends AbstractTestCase {

    // Адрес электронной почты.
    private final String email;
    // Имя пользователя.
    private final String name;
    // Сообщение.
    private final String message;


    // Конструктор.
    public SendContactMessageTestCase(Browser browser, String email, String name, String message) {
        super(browser, "Отправление сообщения в разделе Contact");
        this.email = email;
        this.name = name;
        this.message = message;
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


    // Предусловие №2. Добавление cookie с авторизованным пользователем.
    @Override
    public AbstractTestCase precondition2() {
        addCookie(getSettings().getDEMOBLASE_COOKIE_PATH());
        return super.precondition2();
    }

    // Ожмдание выполнения предусловия №2.
    @Override
    public AbstractTestCase waitOfPrecondition2() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
        return super.waitOfPrecondition2();
    }


    // Шаг №1. Нажатие на кнопку 'Contact' главного меню сайта.
    @Override
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickContact();
        return super.step1();
    }

    // Ожидание выполнения шага №1.
    @Override
    public AbstractTestCase waitOfStep1() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "exampleModalLabel");
        return super.waitOfStep1();
    }


    // Шаг №2. Отправка сообщения.
    @Override
    public AbstractTestCase step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getContactForm().sendContactMessage(email, name, message);
        return super.step2();
    }

    // Ожидание выполнение шага №2.
    @Override
    public AbstractTestCase waitOfStep2() {
        explicitWaitOfAlertIsPresent();
        return super.waitOfStep2();
    }

    // Проверка выполнения шага №2.
    @Override
    public AbstractTestCase checkOfStep2() {
        assertOfAlertText("Thanks for the message!!");
        return super.checkOfStep2();
    }


    // Шаг №3. Подтверждение действия на странице.
    @Override
    public AbstractTestCase step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getBrowser().getWebDriver().switchTo().alert().accept();
        return super.step3();
    }
}
