package org.example.websites.calculat_ru;

import org.example.servises.abstractions.AbstractTestCase;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.servises.webdriver.Browser;

// Класс объекта, реализующий тест-кейс по вычислению площади треугольника по трем сторонам, используя сайт calculat.ru.
public class SquareOfTriangleByThreeSidesTestCase extends AbstractTestCase {


    // Конструктор.
    public SquareOfTriangleByThreeSidesTestCase(Browser browser, String testCaseName) {
        super(browser, testCaseName);
    }


    // Предусловие №1. Переход на страницу рассчета площади треугольника по трем сторонам.
    @Override
    public AbstractTestCase precondition1() {
        getBrowser().goToUrl("https://calculat.ru/ploshhad-treugolnika-po-trem-storonam-po-formule-gerona");
        return super.precondition1();
    }

    // Ожидание выполнения предусловия №1.
    @Override
    public AbstractTestCase waitOfPrecondition1() {
        explicitWaitOfUrlContains(
                "https://calculat.ru/ploshhad-treugolnika-po-trem-storonam-po-formule-gerona");
        return super.waitOfPrecondition1();
    }


    // Метод, реализующий получение значения площади треугольника с сайта calculat.ru.
    public String getTriangleSquare (String sideA, String sideB, String sideC)
            throws WrongTypeOfLocatorException, WrongPathOfLocatorException {
        doTestCase();
        return getSquareOfTriangleByThreeSidesPage().getResultOfSquare(sideA, sideB, sideC);
    }
}
