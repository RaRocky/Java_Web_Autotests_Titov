package org.example.servises.abstractions;

import io.qameta.allure.Step;
import org.example.servises.Settings;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;
import org.example.servises.webdriver.cookie.MyCookie;
import org.example.websites.calculat_ru.SquareOfTriangleByThreeSidesPage;
import org.example.websites.demoblase_com.pages.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

// Класс абстрактного тест кейса. Содержит общие методы для всех тест кейсов.
public class AbstractTestCase {

    static Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    // Объект настроек проекта
    private Settings settings;
    // Заголовок тест-кейса.
    private final String testCaseName;
    // Объект класса Browser для управления браузером при помощи Selenium Web Driver.
    private final Browser browser;
    // Объект JavascriptExecutor для управления страницей сайта при помощи JS скриптов.
    private final JavascriptExecutor javascriptExecutor;
    // Объект окна 'About Us'.
    private AboutUsWindow aboutUsWindow;
    // Объект формы авторизации пользователя.
    private AuthorizationForm authorizationForm;
    // Объект страницы корзины товаров.
    private CartPage cartPage;
    // Объект меню категорий товаров.
    private CategoriesMenu categoriesMenu;
    // Объект формы отправки сообщения в разделе 'Contact'.
    private ContactForm contactForm;
    // Объект главного логотипа сайта.
    private Logo logo;
    // Объект главного меню сайта.
    private MainMenu mainMenu;
    // Объект формы отправления заказа.
    private PlaceOrderForm placeOrderForm;
    // Объект страницы товара.
    private ProductPage asusFullHdMonitorPage;
    // Объект блока товаров.
    private ProductsBlock productsBlock;
    // Объект страницы рассчета площади треугольника сайта calculat.ru
    private SquareOfTriangleByThreeSidesPage squareOfTriangleByThreeSidesPage;


    // Конструктор.
    public AbstractTestCase(Browser browser, String testCaseName) {
        setSettings();
        this.testCaseName = testCaseName;
        this.browser = browser;
        this.javascriptExecutor = (JavascriptExecutor) browser.getWebDriver();
        setAboutUsWindow(browser);
        setAuthorizationForm(browser);
        setCartPage(browser);
        setCategoriesMenu(browser);
        setContactForm(browser);
        setLogo(browser);
        setMainMenu(browser);
        setPlaceOrderForm(browser);
        setProductPage(browser);
        setProductsBlock(browser);
        setSquareOfTriangleByThreeSidesPage(browser);
    }


    // Методы класса.
    // Уведомление о начале выполнения тест-кейса.
    public AbstractTestCase startTestCase() {
        logger.info("================================================================================================");
        logger.info("Тест-кейс: " + getTestCaseName() + ".");
        logger.info("------------------------------------------------------------------------------------------------");
        return this;
    }

    // Метод, выполняющий все шаги тест-кейса.
    public void doTestCase() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        startTestCase()
                .precondition1()
                .waitOfPrecondition1()
                .checkOfPrecondition1()
                .pause()

                .precondition2()
                .waitOfPrecondition2()
                .checkOfPrecondition2()
                .pause()

                .step1()
                .waitOfStep1()
                .checkOfStep1()
                .pause()

                .step2()
                .waitOfStep2()
                .checkOfStep2()
                .pause()


                .step3()
                .waitOfStep3()
                .checkOfStep3()
                .pause()

                .step4()
                .waitOfStep4()
                .checkOfStep4()
                .pause()

                .step5()
                .waitOfStep5()
                .checkOfStep5()
                .pause()

                .step6()
                .waitOfStep6()
                .checkOfStep6()
                .pause()

                .step7()
                .waitOfStep7()
                .checkOfStep7()
                .pause()

                .testPassedSuccessfully();
    }

    // Уведомление об успешном прохождении тест-кейса.
    public void testPassedSuccessfully() {
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Тест-кейс '" + getTestCaseName() + "' успешно завершен.");
        logger.info("================================================================================================");
    }

    // Прокручивание страницы на необходимое количество пикселей.
    public void scrollPageBy(long pixels) {
        getJavascriptExecutor().executeScript("window.scrollBy(0," + pixels + ")");
    }

    // Подтверждение действия на странице.
    public void acceptAlert() {
        getBrowser().getWebDriver().switchTo().alert().accept();
    }

    // Добавление Cookie.
    public void addCookie(String filePath) {
        MyCookie cookie = new MyCookie(getBrowser());
        cookie.addCookiesFromFile(filePath);
        getBrowser().getWebDriver().navigate().refresh();
    }


    // Явные ожидания.
    // Метод, реализующий явное ожидание до загрузки страницы, содержащей заданный URL.
    public void explicitWaitOfUrlContains(String urlExpected) {
        new WebDriverWait(getBrowser().getWebDriver(),
                Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions.urlContains(
                urlExpected));
    }

    // Метод, реализующий явное ожидание до того, как указанный веб-элемент станет видимым.
    public void explicitWaitOfVisibilityOfElementLocated(TypeOfLocator typeOfLocator, String pathOfLocator) {
        switch (typeOfLocator) {
            case ID:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions
                        .visibilityOfElementLocated(By.id(pathOfLocator)));
                break;

            case CSS:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(pathOfLocator)));
                break;

            case XPATH:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(pathOfLocator)));
                break;

            default:
                break;
        }
    }

    // Метод, реализующий явное ожидание до того, как указанный веб-элемент станет невидимым.
    public void explicitWaitOfInvisibilityOfElementLocated(TypeOfLocator typeOfLocator, String pathOfLocator) {
        switch (typeOfLocator) {
            case ID:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions
                        .invisibilityOf(getBrowser().getWebDriver().findElement(By.id(pathOfLocator))));
                break;

            case CSS:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions
                        .invisibilityOf(getBrowser().getWebDriver().findElement(By.cssSelector(pathOfLocator))));
                break;

            case XPATH:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions
                        .invisibilityOf(getBrowser().getWebDriver().findElement(By.xpath(pathOfLocator))));
                break;

            default:
                break;
        }
    }

    // Метод, реализующий явное ожидание появления в DOM-структуре элемента, содержащего указанный текст.
    public void explicitWaitOfTextContainsInElementLocated(TypeOfLocator typeOfLocator, String pathOfLocator, String text) {
        switch (typeOfLocator) {
            case ID:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME()))
                        .until(ExpectedConditions
                                .textToBePresentInElement(getBrowser()
                                        .getWebDriver().findElement(By.id(pathOfLocator)), text));
                break;

            case CSS:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME()))
                        .until(ExpectedConditions
                                .textToBePresentInElement(getBrowser()
                                        .getWebDriver().findElement(By.cssSelector(pathOfLocator)), text));
                break;

            case XPATH:
                new WebDriverWait(getBrowser().getWebDriver(),
                        Duration.ofSeconds(getEXPLICIT_WAIT_TIME()))
                        .until(ExpectedConditions
                                .textToBePresentInElement(getBrowser()
                                        .getWebDriver().findElement(By.xpath(pathOfLocator)), text));
                break;

            default:
                break;
        }
    }

    // Метод, реализующий явное ожидание до того, как на странице появится алерт.
    public void explicitWaitOfAlertIsPresent() {
        new WebDriverWait(getProductsBlock().getWebDriver(),
                Duration.ofSeconds(getEXPLICIT_WAIT_TIME())).until(ExpectedConditions.alertIsPresent());
    }


    // Ассерты.
    // Ассерт, проверяющий переход на страницу с указанным URL.
    public void assertOfUrlContains(String url) {
        Assertions.assertEquals(url, getBrowser().getWebDriver().getCurrentUrl(),
                "Не удалось перейти на страницу с URL: " + url);
    }

    // Ассерт, проверяющий текст вчплывающего уведомления.
    public void assertOfAlertText(String alertText) {
        Assertions.assertEquals(alertText, getBrowser().getWebDriver().switchTo().alert().getText());
    }

    // Ассерт, проверяющий текст веб-элемента.
    public void assertOfWebElementText(TypeOfLocator typeOfLocator, String pathOfLocator, String webElementText) {
        switch (typeOfLocator) {
            case ID:
                Assertions.assertEquals(webElementText, getBrowser()
                        .getWebDriver()
                        .findElement(By.id(pathOfLocator))
                        .getText());
                break;

            case CSS:
                Assertions.assertEquals(webElementText, getBrowser()
                        .getWebDriver()
                        .findElement(By.cssSelector(pathOfLocator))
                        .getText());
                break;

            case XPATH:
                Assertions.assertEquals(webElementText, getBrowser()
                        .getWebDriver()
                        .findElement(By.xpath(pathOfLocator))
                        .getText());
                break;
            default:
                break;
        }
    }


    // Этапы выполнения тест-кейса.
    // Пауза.
    public AbstractTestCase pause() {
        try {
            Thread.sleep(settings.getPAUSE());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


    // Предусловие №1.
    public AbstractTestCase precondition1() {
        return this;
    }

    // Ожидание выполнения предусловия №1.
    public AbstractTestCase waitOfPrecondition1() {
        return this;
    }

    // Проверка выполнения предусловия №1.
    public AbstractTestCase checkOfPrecondition1() {
        return this;
    }


    // Предусловие №2.
    public AbstractTestCase precondition2() {
        return this;
    }

    // Ожидание выполнения предусловия №2.
    public AbstractTestCase waitOfPrecondition2() {
        return this;
    }

    // Проверка выполнения предусловия №2.
    public AbstractTestCase checkOfPrecondition2() {
        return this;
    }


    // Шаг №1.
    public AbstractTestCase step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №1.
    public AbstractTestCase waitOfStep1() {
        return this;
    }

    // Проверка выполнения шага №2.
    public AbstractTestCase checkOfStep1() {
        return this;
    }


    // Шаг №2.
    public AbstractTestCase step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №2.
    public AbstractTestCase waitOfStep2() {
        return this;
    }

    // Проверка выполнения шага №2.
    public AbstractTestCase checkOfStep2() {
        return this;
    }


    // Шаг №3.
    public AbstractTestCase step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №3.
    public AbstractTestCase waitOfStep3() {
        return this;
    }

    // Проверка выполнения шага №3.
    public AbstractTestCase checkOfStep3() {
        return this;
    }


    // Шаг №4.
    public AbstractTestCase step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №4.
    public AbstractTestCase waitOfStep4() {
        return this;
    }

    // Проверка выполнения шага №4.
    public AbstractTestCase checkOfStep4() {
        return this;
    }


    // Шаг №5.
    public AbstractTestCase step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №5.
    public AbstractTestCase waitOfStep5() {
        return this;
    }

    // Проверка выполнения шага №5.
    public AbstractTestCase checkOfStep5() {
        return this;
    }


    // Шаг №6.
    public AbstractTestCase step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №6.
    public AbstractTestCase waitOfStep6() {
        return this;
    }

    // Проверка выполнения шага №6.
    public AbstractTestCase checkOfStep6() {
        return this;
    }


    // Шаг №7.
    public AbstractTestCase step7() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        return this;
    }

    // Ожидание выполнения шага №7.
    public AbstractTestCase waitOfStep7() {
        return this;
    }

    // Проверка выполнения шага №7.
    public AbstractTestCase checkOfStep7() {
        return this;
    }


    // Геттеры.
    // Геттер объекта настроек проекта.
    public Settings getSettings() {
        return settings;
    }

    // Геттер времени явного ожидания.
    public int getEXPLICIT_WAIT_TIME() {
        return settings.getEXPLICIT_WAIT_TIME();
    }

    // Геттер заголовка тесткейса.
    public String getTestCaseName() {
        return testCaseName;
    }

    // Геттер объекта класса Browser.
    public Browser getBrowser() {
        return browser;
    }

    // Геттер объекта JavascriptExecutor.
    public JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor;
    }

    // Геттер объекта окна 'About us'.
    public AboutUsWindow getAboutUsWindow() {
        return aboutUsWindow;
    }

    // Геттер объекта формы авторизации пользователя.
    public AuthorizationForm getAuthorizationForm() {
        return authorizationForm;
    }

    // Геттер страницы корзины товаров.
    public CartPage getCartPage() {
        return cartPage;
    }

    // Геттер объекта меню категорий товаров.
    public CategoriesMenu getCategoriesMenu() {
        return categoriesMenu;
    }

    // Геттер объекта отправки формы сообщения в разделе 'Contact'.
    public ContactForm getContactForm() {
        return contactForm;
    }

    // Геттер объекта главного логотипа сайта.
    public Logo getLogo() {
        return logo;
    }

    // Геттер объекта главного меню сайта.
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    // Геттер объекта формы оформления заказа.
    public PlaceOrderForm getPlaceOrderForm() {
        return placeOrderForm;
    }

    // Геттер объекта страницы товара.
    public ProductPage getProductPage() {
        return asusFullHdMonitorPage;
    }

    // Геттер объекта блока товаров.
    public ProductsBlock getProductsBlock() {
        return productsBlock;
    }

    // Геттер объекта страницы рассчета площади треугольника по трем сторонам сайта calculat.ru.
    public SquareOfTriangleByThreeSidesPage getSquareOfTriangleByThreeSidesPage() {
        return squareOfTriangleByThreeSidesPage;
    }


    // Сеттеры.
    // Сеттер объекта настроек проекта.
    public void setSettings() {
        this.settings = new Settings();
    }

    // Сеттер объекта окна 'About us'.
    public void setAboutUsWindow(Browser browser) {
        this.aboutUsWindow = new AboutUsWindow(browser);
    }

    // Сеттер объекта формы авторизации пользователя.
    public void setAuthorizationForm(Browser browser) {
        this.authorizationForm = new AuthorizationForm(browser);
    }

    // Сеттер объекта страницы корзины товаров.
    public void setCartPage(Browser browser) {
        this.cartPage = new CartPage(browser);
    }

    // Сеттер объекта меню категорий товаров.
    public void setCategoriesMenu(Browser browser) {
        this.categoriesMenu = new CategoriesMenu(browser);
    }

    // Сеттер объекта отправки формы сообщения в разделе 'Contact'.
    public void setContactForm(Browser browser) {
        this.contactForm = new ContactForm(browser);
    }

    // Сеттер главного логотипа сайта.
    public void setLogo(Browser browser) {
        this.logo = new Logo(browser);
    }

    // Сеттер объекта главного меню сайта.
    public void setMainMenu(Browser browser) {
        this.mainMenu = new MainMenu(browser);
    }

    // Сеттер объекта формы оформления заказа.
    public void setPlaceOrderForm(Browser browser) {
        this.placeOrderForm = new PlaceOrderForm(browser);
    }

    // Сеттер объекта страницы страницы товара.
    public void setProductPage(Browser browser) {
        this.asusFullHdMonitorPage = new ProductPage(browser);
    }

    // Сеттер объекта блока товаров.
    public void setProductsBlock(Browser browser) {
        this.productsBlock = new ProductsBlock(browser);
    }

    // Сеттер объекта страницы рассчета площади треугольника по трем сторонам сайта calculat.ru.
    public void setSquareOfTriangleByThreeSidesPage(Browser browser) {
        this.squareOfTriangleByThreeSidesPage = new SquareOfTriangleByThreeSidesPage(browser);
    }
}
