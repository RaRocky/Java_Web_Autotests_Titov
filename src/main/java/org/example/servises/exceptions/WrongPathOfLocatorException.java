package org.example.servises.exceptions;

import org.openqa.selenium.NoSuchElementException;

// Исключение, информирующее о том, что элемент с заданным локатором отсутствует в DOM-структуре открытой
// страницы сайта, либо локатор указан с ошибкой.
public class WrongPathOfLocatorException extends NoSuchElementException {

    // Конструктор.
    public WrongPathOfLocatorException(String message) {
        super(message);
    }
}
