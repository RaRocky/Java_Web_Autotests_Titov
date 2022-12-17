package org.example.servises.abstractions;

import org.example.demoblase_com.pages.*;
import org.example.servises.Settings;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.TypeOfLocator;
import org.example.servises.webdriver.cookie.MyCookie;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс абстрактного тест кейса. Содержит общие методы для всех тест кейсов.
public class AbstractTestCase {

    // Объект настроек проекта
    private Settings settings;
    // Заголовок тест-кейса.
    private String testCaseName;
    // Объект класса Browser для управления браузером при помощи Selenium Web Driver.
    private final Browser browser;
    // Объект JavascriptExecutor для управления страницей сайта при помощи JS скриптов.
    private JavascriptExecutor javascriptExecutor;
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
    }


    // Методы класса.
    // Метод, выполняющий все шаги тест-кейса.
    public void doTestCase() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        precondition1();
        pause();
        waitOfPrecondition1();
        precondition2();
        pause();
        waitOfPrecondition2();
        step1();
        pause();
        waitOfStep1();
        step2();
        pause();
        waitOfStep2();
        step3();
        pause();
        waitOfStep3();
        step4();
        pause();
        waitOfStep4();
        step5();
        pause();
        waitOfStep5();
        step6();
        pause();
        waitOfStep6();
        step7();
        pause();
        waitOfStep7();
        testPassedSuccessfully();
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

    // Пауза.
    public void pause() {
        try {
            Thread.sleep(settings.getPAUSE());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Уведомление об успешном прохождении тест-кейса.
    public void testPassedSuccessfully() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Тест-кейс '" + getTestCaseName() + "' успешно завершен.");
        System.out.println("-----------------------------------------------------------------------------------------");
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
        switch (typeOfLocator)  {
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

    // Этапы выполнения тест-кейса.
    // Предусловие №1.
    public void precondition1() {

    }

    // Ожидание выполнения предусловия №1.
    public void waitOfPrecondition1() {

    }

    // Предусловие №2.
    public void precondition2() {

    }

    // Ожидание выполнения предусловия №2.
    public void waitOfPrecondition2() {

    }

    // Шаг №1.
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №1.
    public void waitOfStep1() {

    }

    // Шаг №2.
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №2.
    public void waitOfStep2() {

    }

    // Шаг №3.
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №3.
    public void waitOfStep3() {

    }

    // Шаг №4.
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №4.
    public void waitOfStep4() {

    }

    // Шаг №5.
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №5.
    public void waitOfStep5() {

    }

    // Шаг №6.
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №6.
    public void waitOfStep6() {

    }

    // Шаг №7.
    public void step7() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №7.
    public void waitOfStep7() {

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
}
