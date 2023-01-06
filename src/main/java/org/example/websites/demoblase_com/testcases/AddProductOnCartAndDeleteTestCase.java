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


    // Шаг№1. Переход на страницу категории 'Monitors'.
    @Override
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCategoriesMenu().clickMonitors();
        return super.step1();
    }

    // Ожидание выполнения шага №1.
    @Override
    public AbstractTestCase waitOfStep1() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/index.html#");
        return super.waitOfStep1();
    }

    // Проверка выполнения шага №1.
    @Override
    public AbstractTestCase checkOfStep1() {
        assertOfUrlContains("https://www.demoblaze.com/index.html#");
        return super.checkOfStep1();
    }


    // Шаг№2. Переход на страницу товара 'ASUS Full HD'.
    @Override
    public AbstractTestCase step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductsBlock().clickAsusFullHd();
        return super.step2();
    }

    // Ожидание выполнения шага №2.
    @Override
    public AbstractTestCase waitOfStep2() {
        explicitWaitOfUrlContains("https://www.demoblaze.com/prod.html?idp_=14");
        return super.waitOfStep2();
    }

    // Проверка выполнения шага №2.
    @Override
    public AbstractTestCase checkOfStep2() {
        assertOfUrlContains("https://www.demoblaze.com/prod.html?idp_=14");
        return super.checkOfStep2();
    }


    // Шаг№3. Нажатие на кнопку 'Add to cart'.
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

    // Проверка выполнения шага №3.
    @Override
    public AbstractTestCase checkOfStep3() {
        assertOfAlertText("Product added.");
        return super.checkOfStep3();
    }


    // Шаг№4. Подтверждение действия на странице.
    @Override
    public AbstractTestCase step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        acceptAlert();
        return super.step4();
    }


    // Шаг№5. Переход в раздел 'Cart' главного меню сайта.
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


    // Шаг №6. Нажатие на кнопку Delete. Удаление товара из корзины.
    @Override
    public AbstractTestCase step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCartPage().clickDelete();
        return super.step6();
    }

    // Ожидание выполнения шага №6.
    @Override
    public AbstractTestCase waitOfStep6() {
        explicitWaitOfInvisibilityOfElementLocated(TypeOfLocator.CSS, "#tbodyid > tr");
        return super.waitOfStep6();
    }
}
