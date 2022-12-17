package org.example.demoblase_com.pages;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта формы отправки сообщения 'Contact'.
public class ContactForm extends AbstractPage {

    // Поле ввода 'Contact Email'.
    // Локатор.
    private final String CONTACT_EMAIL_LOCATOR = "recipient-email";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = CONTACT_EMAIL_LOCATOR)
    WebElement contactEmailField;
    // Характеристики локатора.
    Locator contactEmailFieldLocator =
            new Locator("Поле ввода 'Contact Email'", TypeOfLocator.ID, CONTACT_EMAIL_LOCATOR);

    // Поле ввода 'Contact Name'.
    // Локатор.
    private final String CONTACT_NAME_LOCATOR = "recipient-name";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = CONTACT_NAME_LOCATOR)
    WebElement contactNameField;
    // Характеристики локатора.
    Locator contactNameFieldLocator =
            new Locator("Поле ввода 'Contact Name'", TypeOfLocator.ID, CONTACT_NAME_LOCATOR);

    // Поле ввода 'Message'.
    // Локатор.
    private final String MESSAGE_LOCATOR = "message-text";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = MESSAGE_LOCATOR)
    WebElement messageField;
    // Характеристики локатора.
    Locator messageFieldLocator = new Locator("Поле ввода 'Message'", TypeOfLocator.ID, MESSAGE_LOCATOR);

    // Кнопка 'Send message'.
    // Локатор.
    private final String SEND_MESSAGE_LOCATOR = "#exampleModal .btn-primary";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = SEND_MESSAGE_LOCATOR)
    WebElement sendMessageButton;
    // Характеристики локатора.
    Locator sendMessageButtonLocator =
            new Locator("Кнопка 'Send message'", TypeOfLocator.CSS, SEND_MESSAGE_LOCATOR);


    // Конструктор.
    public ContactForm(Browser browser) {
        super(browser);
    }


    // Метод, осуществляющий отправку сообщения в разделе 'Contact'.
    public void sendContactMessage (String email, String name, String message)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickContactEmailField()
                .pause()
                .enterContactEmailField(email)
                .pause()
                .clickContactNameField()
                .pause()
                .enterContactNameField(name)
                .pause()
                .clickMessageField()
                .pause()
                .enterMessageField(message)
                .pause()
                .clickSendMessageButton();
    }

    // Клик по полю ввода 'Contact Email'.
    public ContactForm clickContactEmailField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(contactEmailField, contactEmailFieldLocator);
        return this;
    }

    // Заполнение поля ввода 'Contact Email'.
    public ContactForm enterContactEmailField(String email)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(contactEmailField, contactEmailFieldLocator, email);
        return this;
    }

    // Клик по полю ввода 'Contact Name'.
    public ContactForm clickContactNameField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(contactNameField, contactEmailFieldLocator);
        return this;
    }

    // Заполнение поля ввода 'Contact Name'.
    public ContactForm enterContactNameField(String name)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(contactNameField, contactEmailFieldLocator, name);
        return this;
    }

    // Клик по полю ввода 'Message'
    public ContactForm clickMessageField() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(messageField, messageFieldLocator);
        return this;
    }

    // Заполнение поля ввода 'Message'.
    public ContactForm enterMessageField(String message)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(messageField, messageFieldLocator, message);
        return this;
    }

    // Клик по кнопке 'Send message'.
    public ContactForm clickSendMessageButton () throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(sendMessageButton, sendMessageButtonLocator);
        return this;
    }

    // Пауза.
    public ContactForm pause() {
        try {
            Thread.sleep(getSettings().getPAUSE());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
