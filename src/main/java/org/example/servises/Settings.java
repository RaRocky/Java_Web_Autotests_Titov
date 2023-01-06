package org.example.servises;

// Класс, содержащий параметры для настройки проекта.
public class Settings {
    // Время паузы между действиями в миллмсекундах.
    private final long PAUSE = 100;
    // Время явного ожидания выполнения предусловия или шага в секундах.
    private final int EXPLICIT_WAIT_TIME = 5;
    // Путь к файлу с Cookie сайта demoblase.com.
    private final String DEMOBLASE_COOKIE_PATH =
            "./src/main/java/org/example/websites/demoblase_com/cookies/Authorization_Cookie.data";


    // Геттеры.
    // Геттер времени паузы между действиями в миллмсекундах.
    public long getPAUSE() {
        return PAUSE;
    }

    // Геттер времени явного ожидания выполнения предусловия или шага в секундах.
    public int getEXPLICIT_WAIT_TIME() {
        return EXPLICIT_WAIT_TIME;
    }

    // Геттер пути к файлу с Cookie сайта demoblase.com.
    public String getDEMOBLASE_COOKIE_PATH() {
        return DEMOBLASE_COOKIE_PATH;
    }
}
