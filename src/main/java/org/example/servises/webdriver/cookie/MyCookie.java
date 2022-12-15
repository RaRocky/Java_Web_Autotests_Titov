package org.example.servises.webdriver.cookie;

import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.BrowserName;
import org.openqa.selenium.Cookie;

import java.io.*;
import java.util.StringTokenizer;

// Класс, реализующий функционал работы с cookie.
public class MyCookie extends Browser {

    // Конструктор.
    public MyCookie(BrowserName browser) {
        super(browser);
    }


    // Метод, осуществляющий запись текущих cookie браузера в файл.
    public void writeCookieToFile(String fileName) {

        // Создание файла для записи значений Cookie.
        File file = new File(fileName);

        try {
            // Объект, осуществляющий запись данных в файл.
            FileWriter fileWriter = new FileWriter(file);
            // Объект, осуществляющий запись данных в файл с использованием буффера.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Запись значений Cookie в файл.
            for (Cookie ck : getWebDriver().manage().getCookies()) {
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
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                // Чтение параметров Cookie, разделенных ";".
                StringTokenizer token = new StringTokenizer(line, ";");

                while (token.hasMoreTokens()) {
                    String name = token.nextToken();    // имя cookie-файла.
                    String value = token.nextToken();   // значение cookie.
                    String domain = token.nextToken();  // домен, имеющий доступ к cookie.
                    String path = token.nextToken();    //  путь к директории на сервере, для которой будут доступны cookie.
                    //String date = token.nextToken();  // дата и время, до которого cookie будет доступна.
                    String isSecureStr = token.nextToken(); // параметр указывает браузеру, что cookie должны
                                                            // передаваться на сервер только по защищённому https-соединению.

                   /* // Разделение составляющих даты.
                    String[] partsOfDate = date.split("\\s");
                    int year = Integer.parseInt(partsOfDate[5]);
                    String monthStr = partsOfDate[1];
                    int dayOfMonth = Integer.parseInt(partsOfDate[2]);
                    String time = partsOfDate[3];

                    // Замена сокращенного названия месяца соответствующим числовым значением.
                    int month = 0;
                    if (monthStr.equals("Jan")) month = 1;
                    if (monthStr.equals("Feb")) month = 2;
                    if (monthStr.equals("Mar")) month = 3;
                    if (monthStr.equals("Apr")) month = 4;
                    if (monthStr.equals("May")) month = 5;
                    if (monthStr.equals("June")) month = 6;
                    if (monthStr.equals("July")) month = 7;
                    if (monthStr.equals("Aug")) month = 8;
                    if (monthStr.equals("Sep")) month = 9;
                    if (monthStr.equals("Oct")) month = 10;
                    if (monthStr.equals("Nov")) month = 11;
                    if (monthStr.equals("Dec")) month = 12;


                    // Разделение времени на часы, минуты и секунды.
                    String[] partsOfTime = time.split(":");
                    int hours = Integer.parseInt(partsOfTime[0]);
                    int minutes = Integer.parseInt(partsOfTime[1]);
                    int seconds = Integer.parseInt(partsOfTime[2]);*/

                    boolean isSecure;
                    isSecure = isSecureStr.equals("true");

                    // Создание нового объекта cookie на основании прочитанных из файла параметров.
                    Cookie cookie = new Cookie.Builder(name, value)
                            .domain(domain)
                            .path(path)
                            //.expiresOn(new Date(year, month, dayOfMonth, hours, minutes, seconds))
                            .isSecure(isSecure)
                            .build();

                    // добавление cookie в текущую сессию браузера.
                    getWebDriver().manage().addCookie(cookie);
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
