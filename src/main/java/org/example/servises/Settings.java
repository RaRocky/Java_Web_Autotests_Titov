package org.example.servises;

public class Settings {
    // Время паузы между действиями в миллмсекундах.
    private final long PAUSE = 100;
    // Время явного ожидания выполнения предусловия или шага в секундах.
    private final int EXPLICIT_WAIT_TIME = 5;


    // Геттеры.
    // Геттер времени паузы между действиями в миллмсекундах.
    public long getPAUSE() {
        return PAUSE;
    }

    // Геттер времени явного ожидания выполнения предусловия или шага в секундах.
    public int getEXPLICIT_WAIT_TIME() {
        return EXPLICIT_WAIT_TIME;
    }
}
