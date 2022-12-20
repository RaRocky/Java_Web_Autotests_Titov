package org.example.lesson4.exceptions;

// Исключение, уведомляющее о том, что длина одной из сторон треугольника имеет отрицательное значение.
public class LengthIsNegativeException extends Exception{

    // Конструктор.
    public LengthIsNegativeException(String message) {
        super(message);
    }
}
