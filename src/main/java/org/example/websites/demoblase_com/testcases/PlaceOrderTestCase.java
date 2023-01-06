package org.example.websites.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта тест-кейса №4. Оформление заказа.
public class PlaceOrderTestCase extends AbstractTestCase {

    // Конструктор.
    public PlaceOrderTestCase(Browser browser, String testCaseName) {
        super(browser, testCaseName);
    }


    // Предусловие №1. Переход на главную страницу.
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

    // Ожидание выполнения предусловия №2.
    @Override
    public void waitOfPrecondition2() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
    }

    // Шаг №1. Прокручивание страницы вниз до конца.
    @Override
    public void step1() {
        scrollPageBy(1000);
    }

    // Шаг №2. Переход на страницу товара 'Sony vaio i5'.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductsBlock().clickSonyVioI5();
    }

    // Ожидание выполнения шага №2.
    @Override
    public void waitOfStep2() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/prod.html?idp_=8");
    }

    // Шаг №3. Нажатие на кнопку 'Add to cart'.
    @Override
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductPage().clickAddToCartButton();
    }

    // Ожидание выполнения шага №3.
    @Override
    public void waitOfStep3() {
        explicitWaitOfAlertIsPresent();
    }

    // Шаг №4. Подтверждение действия на странице.
    @Override
    public void step4() {
        acceptAlert();
    }

    // Шаг №5. Переход в раздел 'Cart' главного меню сайта.
    @Override
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickCart();
    }

    // Ожидание выполнения шага №5.
    @Override
    public void waitOfStep5() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/cart.html");
    }

    // Шаг №6. Нажатие кнопки 'Place order'.
    @Override
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCartPage().clickPlaceOrderButton();
    }

    @Override
    public void waitOfStep6() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "orderModalLabel");
    }

    // Шаг №7. Отправление формы оформления заказа.
    @Override
    public void step7() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getPlaceOrderForm().placeOrder("Bob Smith", "USA", "New York",
                "0000 0000 0000 0000", "December", "2022");
    }

    // Ожидание выполнения шага №7.
    @Override
    public void waitOfStep7() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.CSS, ".sweet-alert");
    }
}
