package org.example.websites.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;

// Класс объекта с функционалом тест-кейса №3. Добавление товара 'ASUS Full HD' в корзину с последующим удалением.
public class AddProductOnCartAndDeleteTestCase extends AbstractTestCase {

    // Конструктор.
    public AddProductOnCartAndDeleteTestCase(Browser browser) {
        super(browser, "Добавление товара 'ASUS Full HD' в корзину с последующим удалением");
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

    // Ожидание выполнения предусловия №2.
    @Override
    public void waitOfPrecondition2() {
        explicitWaitOfVisibilityOfElementLocated(TypeOfLocator.ID, "nameofuser");
    }

    // Шаг№1. Переход на страницу категории 'Monitors'.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCategoriesMenu().clickMonitors();
    }

    // Ожидание выполнения шага №1.
    @Override
    public void waitOfStep1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html#");
    }

    // Шаг№2. Переход на страницу товара 'ASUS Full HD'.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductsBlock().clickAsusFullHd();
    }

    // Ожидание выполнения шага №2.
    @Override
    public void waitOfStep2() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/prod.html?idp_=14");
    }

    // Шаг№3. Нажатие на кнопку 'Add to cart'.
    @Override
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductPage().clickAddToCartButton();
    }

    // Ожидание выполнения шага №3.
    @Override
    public void waitOfStep3() {
        explicitWaitOfAlertIsPresent();
    }

    // Шаг№4. Подтверждение действия на странице.
    @Override
    public void step4() {
        acceptAlert();
    }

    // Шаг№5. Переход в раздел 'Cart' главного меню сайта.
    @Override
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickCart();
    }

    // Ожидание выполнения шага №5.
    @Override
    public void waitOfStep5() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/cart.html");
    }

    // Шаг №6. Нажатие на кнопку Delete. Удаление товара из корзины.
    @Override
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCartPage().clickDelete();
    }

    // Ожидание выполнения шага №6.
    @Override
    public void waitOfStep6() {
        explicitWaitOfInvisibilityOfElementLocated(TypeOfLocator.ID, "tbodyid");
    }
}
