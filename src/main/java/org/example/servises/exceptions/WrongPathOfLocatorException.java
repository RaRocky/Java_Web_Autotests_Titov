package org.example.servises.exceptions;

import org.openqa.selenium.NoSuchElementException;

public class WrongPathOfLocatorException extends NoSuchElementException {
    public WrongPathOfLocatorException(String message) {
        super(message);
    }
}
