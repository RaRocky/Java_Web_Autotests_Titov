package org.example.lesson4.exceptions;

// Исключение, уведомляющее о том, что длина одной из сторон равна нулю.
public class SideEqualZeroException extends Exception{

    // Конструктор.
    public SideEqualZeroException(String message) {
        super(message);
    }
}
