package org.example.lesson4.exceptions;

// Исключение, уведомляющее о том, что фигура с заданными длинами сторон не может быть треугольником.
public class CanNotBeTriangleException extends Exception {

    // Конструктор.
    public CanNotBeTriangleException(String message) {
        super(message);
    }
}
