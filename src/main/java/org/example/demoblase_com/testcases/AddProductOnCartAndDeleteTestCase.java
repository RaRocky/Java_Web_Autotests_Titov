package org.example.demoblase_com.testcases;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.cookie.MyCookie;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс объекта с функционалом тест-кейса №3. Добавление товара 'ASUS Full HD' в корзину с последующим удалением.
public class AddProductOnCartAndDeleteTestCase extends AbstractTestCase {

    // Конструктор.
    public AddProductOnCartAndDeleteTestCase(Browser browser) {
        super(browser);
    }


    // Предусловие №1. Переход на главную страницу сайта.
    @Override
    public void precondition1() {
        getBrowser().goToUrl("https://www.demoblaze.com/index.html");
    }

    // Ожидание выполнения предусловия №1.
    @Override
    public void waitOfPrecondition1(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/index.html"));
    }

    // Предусловие №2. Добавление cookie с авторизованным пользователем.
    @Override
    public void precondition2() {
        MyCookie cookie = new MyCookie(getBrowser());
        cookie.addCookiesFromFile("./src/main/java/org/example/demoblase_com/cookies/Authorization_Cookie.data");
        getBrowser().getWebDriver().navigate().refresh();
    }

    // Ожидание выполнения предусловия №2.
    @Override
    public void waitOfPrecondition2(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("nameofuser")));
    }

    // Шаг№1. Переход на страницу категории 'Monitors'.
    @Override
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCategoriesMenu().clickMonitors();
    }

    // Ожидание выполнения шага №1.
    @Override
    public void waitOfStep1(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/index.html#"));
    }

    // Шаг№2. Переход на страницу товара 'ASUS Full HD'.
    @Override
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getProductsBlock().clickAsusFullHd();
    }

    // Ожидание выполнения шага №2.
    @Override
    public void waitOfStep2(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/prod.html?idp_=14"));
    }

    // Шаг№3. Нажатие на кнопку 'Add to cart'.
    @Override
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getAsusFullHdMonitorPage().clickAddToCartButton();
    }

    // Ожидание выполнения шага №3.
    @Override
    public void waitOfStep3(int explicitWaitTime) {
        new WebDriverWait(getProductsBlock().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.alertIsPresent());
    }

    // Шаг№4. Подтверждение действия на странице.
    @Override
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getBrowser().getWebDriver().switchTo().alert().accept();
    }

    // Ожидание выполнения шага №4.
    @Override
    public void waitOfStep4(int explicitWaitTime) {

    }

    // Шаг№5. Переход в раздел 'Cart' главного меню сайта.
    @Override
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getMainMenu().clickCart();
    }

    // Ожидание выполнения шага №5.
    @Override
    public void waitOfStep5(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions.urlContains(
                "https://www.demoblaze.com/cart.html"));
    }


    // Шаг №6. Нажатие на кнопку Delete. Удаление товара из корзины.
    @Override
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        getCartPage().clickDelete();
    }

    // Ожидание выполнения шага №6.
    @Override
    public void waitOfStep6(int explicitWaitTime) {
        new WebDriverWait(getBrowser().getWebDriver(), Duration.ofSeconds(explicitWaitTime)).until(ExpectedConditions
                .invisibilityOf(getBrowser().getWebDriver().findElement(By.id("tbodyid"))));
    }
}
