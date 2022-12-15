package org.example.servises.abstractions;

import org.example.demoblase_com.pages.*;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;

// Класс абстрактного тест кейса. Содержит общие методы для всех тест кейсов.
public class AbstractTestCase {

    // Время явного ожидания выполнения предусловия или шага в секундах.
    private final int EXPLICIT_WAIT_TIME = 5;
    // Объект класса Browser для управления браузером при помощи Selenium Web Driver.
    private final Browser browser;
    // Объект страницы товара 'ASUS FULL HD'.
    private AsusFullHdMonitorPage asusFullHdMonitorPage;
    // Объект формы авторизации пользователя.
    private AuthorizationForm authorizationForm;
    // Объект страницы корзины товаров.
    private CartPage cartPage;
    // Объект меню категорий товаров.
    private CategoriesMenu categoriesMenu;
    // Объект главного логотипа сайта.
    private Logo logo;
    // Объект главного меню сайта.
    private MainMenu mainMenu;
    // Объект блока товаров.
    private ProductsBlock productsBlock;


    // Конструктор.
    public AbstractTestCase(Browser browser) {
        this.browser = browser;
        setAsusFullHdMonitorPage(browser);
        setAuthorizationForm(browser);
        setCartPage(browser);
        setCategoriesMenu(browser);
        setLogo(browser);
        setMainMenu(browser);
        setProductsBlock(browser);
    }


    // Геттеры.
    // Геттер объекта класса Browser.
    public Browser getBrowser() {
        return browser;
    }

    // Геттер времени явного ожидания.
    public int getEXPLICIT_WAIT_TIME() {
        return EXPLICIT_WAIT_TIME;
    }

    // Геттер объекта страницы товара 'ASUS FULL HD'
    public AsusFullHdMonitorPage getAsusFullHdMonitorPage() {
        return asusFullHdMonitorPage;
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

    // Геттер объекта главного логотипа сайта.
    public Logo getLogo() {
        return logo;
    }

    // Геттер объекта главного меню сайта.
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    // Геттер объекта блока товаров.
    public ProductsBlock getProductsBlock() {
        return productsBlock;
    }


    // Сеттеры.
    // Сеттер объекта страницы страницы товара 'ASUS FULL HD'
    public void setAsusFullHdMonitorPage(Browser browser) {
        this.asusFullHdMonitorPage = new AsusFullHdMonitorPage(browser);
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

    // Сеттер главного логотипа сайта.
    public void setLogo(Browser browser) {
        this.logo = new Logo(browser);
    }

    // Сеттер объекта главного меню сайта.
    public void setMainMenu(Browser browser) {
        this.mainMenu =new MainMenu(browser);
    }

    // Сеттер объекта блока товаров.
    public void setProductsBlock(Browser browser) {
        this.productsBlock = new ProductsBlock(browser);
    }

    // Методы класса.
    // Метод, выполняющий все шаги тест-кейса.
    public void doTestCase(int explicitWaitTime) throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        precondition1();
        waitOfPrecondition1(explicitWaitTime);
        precondition2();
        waitOfPrecondition2(explicitWaitTime);
        step1();
        waitOfStep1(explicitWaitTime);
        step2();
        waitOfStep2(explicitWaitTime);
        step3();
        waitOfStep3(explicitWaitTime);
        step4();
        waitOfStep4(explicitWaitTime);
        step5();
        waitOfStep5(explicitWaitTime);
        step6();
        waitOfStep6(explicitWaitTime);
    }

    // Предусловие №1.
    public void precondition1() {

    }

    // Ожидание выполнения предусловия №1.
    public void waitOfPrecondition1(int explicitWaitTime) {

    }

    // Предусловие №2.
    public void precondition2() {

    }

    // Ожидание выполнения предусловия №2.
    public void waitOfPrecondition2(int explicitWaitTime) {

    }

    // Шаг №1.
    public void step1() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №1.
    public void waitOfStep1(int explicitWaitTime) {

    }

    // Шаг №2.
    public void step2() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №2.
    public void waitOfStep2(int explicitWaitTime) {

    }

    // Шаг №3.
    public void step3() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №3.
    public void waitOfStep3(int explicitWaitTime) {

    }

    // Шаг №4.
    public void step4() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №4.
    public void waitOfStep4(int explicitWaitTime) {

    }

    // Шаг №5.
    public void step5() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №5.
    public void waitOfStep5(int explicitWaitTime) {

    }

    // Шаг №6.
    public void step6() throws WrongTypeOfLocatorException, WrongPathOfLocatorException {

    }

    // Ожидание выполнения шага №6.
    public void waitOfStep6(int explicitWaitTime) {

    }
}
