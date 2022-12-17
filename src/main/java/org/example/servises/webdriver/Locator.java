package org.example.servises.webdriver;

import org.openqa.selenium.WebElement;

// Класс описывает основные характеристики веб-элемента, необходимые для взаимодействия с ним.
public class Locator {

    private final String name;  // Имя веб-элемента.
    private final TypeOfLocator type;  // Тип локатора для поиска веб-элемента. ("id", "css", "xpath").
    private final String path;  // Локатор веб-элемента.


    // Конструктор.
    public Locator(String name, TypeOfLocator type, String path) {
        this.name = name;
        this.type = type;
        this.path = path;
    }


    // Геттер имени веб-элемента.
    public String getName() {
        return name;
    }

    // Геттер типа локатора веб-элемента.
    public TypeOfLocator getType() {
        return type;
    }

    // Геттер локатора веб-элемента.
    public String getPath() {
        return path;
    }
}
