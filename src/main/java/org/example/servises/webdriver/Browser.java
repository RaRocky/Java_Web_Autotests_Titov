package org.example.servises.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

// Класс управления браузером при помощи Selenium Web Driver.
public class Browser {

    private WebDriver webDriver;    // Объект класса WebDriver.


    // Конструктор.
    public Browser(BrowserName browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--incognito");
                //optionsChrome.addArguments("--headless");

                webDriver = new ChromeDriver(optionsChrome);
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFireFox = new FirefoxOptions();
                //optionsFireFox.addArguments("--incognito");
                //options1.addArguments("--headless");

                webDriver = new FirefoxDriver(optionsFireFox);
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            default:
                System.out.println("Укажите, какой браузер должен использовать Selenium Web Driver.");
                break;
        }
    }

    // Геттер для обекта класса Web Driver.
    public WebDriver getWebDriver() {
        return webDriver;
    }

    // Переход на страницу сайта по ссылке.
    public void goToUrl(String url) {
        webDriver.navigate().to(url);
    }

    // Закрыть браузер. Завершить работу Web Driver.
    public void close() {
        webDriver.quit();
    }
}