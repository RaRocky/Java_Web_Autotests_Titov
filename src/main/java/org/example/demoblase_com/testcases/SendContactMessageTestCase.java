package org.example.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта с функционалом тест-кейса №5. Отправление сообщения в разделе Contact.
public class SendContactMessageTestCase extends AbstractTestCase {


    // Конструктор.
    public SendContactMessageTestCase(Browser browser, String testCaseName) {
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

    // Предусловие №2. Добавление cookie с авторизованным пользователем.
    @Override
    public void precondition2() {
        addCookie("./src/main/java/org/example/demoblase_com/cookies/Authorization_Cookie.data");
    }

    // Ожмдание выполнения предусловия №2.
    @Override
    public void waitOfPrecondition2() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
    }

    // Шаг №1. Нажатие на кнопку 'Contact' главного меню сайта.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickContact();
    }

    // Ожидание выполнения шага №1.
    @Override
    public void waitOfStep1() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "exampleModalLabel");
    }

    // Шаг №2. Отправка сообщения.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getContactForm().sendContactMessage("bobsmith@gmail.com", "Bob Smith", "My message.");
    }

    // Ожидание выполнение шага №2.
    @Override
    public void waitOfStep2() {
        explicitWaitOfAlertIsPresent();
    }

    // Шаг №3. Подтверждение действия на странице.
    @Override
    public void step3() {
        getBrowser().getWebDriver().switchTo().alert().accept();
    }
}
