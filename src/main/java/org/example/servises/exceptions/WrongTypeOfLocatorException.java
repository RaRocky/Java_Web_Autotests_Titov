package org.example.servises.exceptions;

// Исключение, информирующее о том, что тип заданного локатора указан неверно.
public class WrongTypeOfLocatorException extends Exception {

    // Конструктор.
    public WrongTypeOfLocatorException(String message) {
        super(message);
    }
}
