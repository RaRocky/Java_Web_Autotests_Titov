package org.example.websites.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта тест-кейса №4. Оформление заказа.
public class PlaceOrderTestCase extends AbstractTestCase {

    // Имя пользователя.
    private final String userName;
    // Страна.
    private final String country;
    // Город.
    private final String city;
    // Номер кредитной карты.
    private final String creditCard;
    // Месяц.
    private final String month;
    // Год.
    private final String year;


    // Конструктор.
    public PlaceOrderTestCase(Browser browser, String userName, String country, String city,
                              String creditCard, String month, String year) {
        super(browser, "Оформление заказа");
        this.userName = userName;
        this.country = country;
        this.city = city;
        this.creditCard = creditCard;
        this.month = month;
        this.year = year;
    }


    // Предусловие №1. Переход на главную страницу.
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

    // Ожидание выполнения предусловия №2.
    @Override
    public AbstractTestCase waitOfPrecondition2() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
        return super.waitOfPrecondition2();
    }


    // Шаг №1. Прокручивание страницы вниз до конца.
    @Override
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        scrollPageBy(1000);
        return super.step1();
    }


    // Шаг №2. Переход на страницу товара 'Sony vaio i5'.
    @Override
    public AbstractTestCase step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductsBlock().clickSonyVioI5();
        return super.step2();
    }

    // Ожидание выполнения шага №2.
    @Override
    public AbstractTestCase waitOfStep2() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/prod.html?idp_=8");
        return super.waitOfStep2();
    }

    // Проверка выполнения шага №2.
    @Override
    public AbstractTestCase checkOfStep2() {
        assertOfUrlContains("https://www.demoblaze.com/prod.html?idp_=8");
        return super.checkOfStep2();
    }


    // Шаг №3. Нажатие на кнопку 'Add to cart'.
    @Override
    public AbstractTestCase step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductPage().clickAddToCartButton();
        return super.step3();
    }

    // Ожидание выполнения шага №3.
    @Override
    public AbstractTestCase waitOfStep3() {
        explicitWaitOfAlertIsPresent();
        return super.waitOfStep3();
    }


    // Шаг №4. Подтверждение действия на странице.
    @Override
    public AbstractTestCase step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        acceptAlert();
        return super.step4();
    }


    // Шаг №5. Переход в раздел 'Cart' главного меню сайта.
    @Override
    public AbstractTestCase step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickCart();
        return super.step5();
    }

    // Ожидание выполнения шага №5.
    @Override
    public AbstractTestCase waitOfStep5() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/cart.html");
        return super.waitOfStep5();
    }

    // Проверка выполнения шага №5.
    @Override
    public AbstractTestCase checkOfStep5() {
        assertOfUrlContains("https://www.demoblaze.com/cart.html");
        return super.checkOfStep5();
    }


    // Шаг №6. Нажатие кнопки 'Place order'.
    @Override
    public AbstractTestCase step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCartPage().clickPlaceOrderButton();
        return super.step6();
    }

    @Override
    public AbstractTestCase waitOfStep6() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "orderModalLabel");
        return super.waitOfStep6();
    }


    // Шаг №7. Отправление формы оформления заказа.
    @Override
    public AbstractTestCase step7() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getPlaceOrderForm().placeOrder(userName, country, city, creditCard, month, year);
        return super.step7();
    }

    // Ожидание выполнения шага №7.
    @Override
    public AbstractTestCase waitOfStep7() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.CSS, ".sweet-alert");
        return super.waitOfStep7();
    }
}
