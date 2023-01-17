package org.example.websites.calculat_ru;

import org.example.servises.abstractions.AbstractPage;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;
import org.example.servises.webdriver.Locator;
import org.example.servises.webdriver.TypeOfLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс объекта страницы рассчета площади треугольника по трем сторонам сайта calculat.ru.
public class SquareOfTriangleByThreeSidesPage extends AbstractPage {

    // Поле ввода длины стороны А.
    // Локатор.
    private final String SIDE_A_LOCATOR = "a";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = SIDE_A_LOCATOR)
    WebElement sideAField;
    // Характеристики локатора.
    Locator sideAFieldLocator = new Locator("Поле ввода длины стороны А", TypeOfLocator.ID, SIDE_A_LOCATOR);

    // Поле ввода длины стороны В.
    // Локатор.
    private final String SIDE_B_LOCATOR = "b";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = SIDE_B_LOCATOR)
    WebElement sideBField;
    // Характеристики локатора.
    Locator sideBFieldLocator = new Locator("Поле ввода длины стороны В", TypeOfLocator.ID, SIDE_B_LOCATOR);

    // Поле ввода длины стороны С.
    // Локатор.
    private final String SIDE_C_LOCATOR = "c";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = SIDE_C_LOCATOR)
    WebElement sideCField;
    // Характеристики локатора.
    Locator sideCFieldLocator = new Locator("Поле ввода длины стороны С", TypeOfLocator.ID, SIDE_C_LOCATOR);

    // Кнопка 'Посчитать'.
    // Локатор.
    private final String COUNT_BUTTON_LOCATOR = "cbutton";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(id = COUNT_BUTTON_LOCATOR)
    WebElement countButton;
    // Характеристики локатора.
    Locator countButtonLocator = new Locator("Кнопка 'Посчитать'", TypeOfLocator.ID, COUNT_BUTTON_LOCATOR);

    // Результат расчета площади треугольника.
    // Локатор.
    private final String SQUARE_RESULT_LOCATOR = "#res_div > p:nth-child(3) > strong";
    // Поиск при помощи паттерна PageFactory.
    @FindBy(css = SQUARE_RESULT_LOCATOR)
    WebElement squareResult;
    // Характеристики локатора.
    Locator squareResultLocator =
            new Locator("Результат расчета площади треугольника", TypeOfLocator.CSS, SQUARE_RESULT_LOCATOR);

    // Конструктор.
    public SquareOfTriangleByThreeSidesPage(Browser browser) {
        super(browser);
    }

    // Методы класса.
    // Клик по полю ввода длины стороны А.
    public SquareOfTriangleByThreeSidesPage clickSideAField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(sideAField, sideAFieldLocator);
        return this;
    }

    // Заполнение поля ввода длины стороны А.
    public SquareOfTriangleByThreeSidesPage enterSideAField(String sideA)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(sideAField, sideAFieldLocator, sideA);
        return this;
    }

    // Клик по полю ввода длины стороны В.
    public SquareOfTriangleByThreeSidesPage clickSideBField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(sideBField, sideBFieldLocator);
        return this;
    }

    // Заполнение поля ввода длины стороны В.
    public SquareOfTriangleByThreeSidesPage enterSideBField(String sideB)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(sideBField, sideBFieldLocator, sideB);
        return this;
    }

    // Клик по полю ввода длины стороны С.
    public SquareOfTriangleByThreeSidesPage clickSideCField()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(sideCField, sideCFieldLocator);
        return this;
    }

    // Заполнение поля ввода длины стороны С.
    public SquareOfTriangleByThreeSidesPage enterSideCField(String sideC)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        enterText(sideCField, sideCFieldLocator, sideC);
        return this;
    }

    // Клик по кнопке 'Посчитать'.
    public SquareOfTriangleByThreeSidesPage clickCountButton()
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickElement(countButton, countButtonLocator);
        return this;
    }

    // Получение результата расчета площади треугольника.
    public String getResultOfSquare(String sideA, String sideB, String sideC)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        clickSideAField()
                .enterSideAField(sideA)
                .clickSideBField()
                .enterSideBField(sideB)
                .clickSideCField()
                .enterSideCField(sideC)
                .clickCountButton();
        return getElementText(squareResult, squareResultLocator);
    }
}
