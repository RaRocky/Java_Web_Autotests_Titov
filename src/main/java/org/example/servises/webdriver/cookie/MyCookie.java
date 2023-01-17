package org.example.servises.webdriver.cookie;

import org.example.servises.webdriver.Browser;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;

// Класс, реализующий функционал работы с cookie.
public class MyCookie {

    // Объект класса Web Driver.
    private final WebDriver webDriver;


    // Конструктор.
    public MyCookie(Browser browser) {
        this.webDriver = browser.getWebDriver();
    }


    // Метод, осуществляющий запись текущих cookie браузера в файл.
    public void writeCookieToFile(String fileName) throws IOException {

        // Создание файла для записи значений Cookie.
        File file = new File(fileName);

        if (!file.exists()) file.createNewFile();

        try {
            // Объект, осуществляющий запись данных в файл.
            FileWriter fileWriter = new FileWriter(file);
            // Объект, осуществляющий запись данных в файл с использованием буффера.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Запись значений Cookie в файл.
            for (Cookie ck : webDriver.manage().getCookies()) {
                bufferedWriter.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() +
                        ";" + ck.getExpiry() + ";" + ck.isSecure()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Метод, осуществляющий чтение из файла и добавление cookie в текущую сессию браузера.
    public void addCookiesFromFile(String fileName) {

        try {
            // Определение файла для чтения Cookie.
            File file = new File(fileName);
            // Объект, осуществляющий чтение данных из файла.
            FileReader fileReader = new FileReader(file);
            // Объект, осуществляющий чтение данных из файла с использованием буффера.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Чтение файла построчно при помощи BufferedReader.
            String reader;
            while ((reader = bufferedReader.readLine()) != null) {
                String[] values = reader.split(";");    // Массив строковых значений, разделенных ";".
                String name = values[0];        // имя cookie-файла.
                String value = values[1];      // значение cookie.
                String domain = values[2];     // домен, имеющий доступ к cookie.
                String path = values[3];        // путь к директории на сервере, для которой будут доступны cookie.
                String isSecureStr = values[4]; // параметр указывает браузеру, что cookie должны
                // передаваться на сервер только по защищённому https-соединению.

                boolean isSecure;
                isSecure = isSecureStr.equals("true");  // Приведение из строкового значения в boolean.

                // Создание нового объекта cookie на основании прочитанных из файла параметров.
                Cookie cookie = new Cookie.Builder(name, value)
                        .domain(domain)
                        .path(path)
                        .isSecure(isSecure)
                        .build();

                // добавление cookie в текущую сессию браузера.
                webDriver.manage().addCookie(cookie);
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
    }
}
