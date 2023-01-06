package org.example.lesson4;

import org.example.abstractions.AbstractTest;
import org.example.lesson4.exceptions.CanNotBeTriangleException;
import org.example.lesson4.exceptions.LengthIsNegativeException;
import org.example.lesson4.exceptions.SideEqualZeroException;
import org.example.servises.exceptions.WrongPathOfLocatorException;
import org.example.servises.exceptions.WrongTypeOfLocatorException;
import org.example.websites.calculat_ru.SquareOfTriangleByThreeSidesTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TriangleTest extends AbstractTest {

    private final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @CsvSource({"3, 3, 3", "3, 2, 3", "30, 40, 50"})
    @DisplayName("Тест №1. Вычисление площади треугольника по трем сторонам. Позитивный тест.")
    public void positiveTest(int sideA, int sideB, int sideC) throws SideEqualZeroException,
            LengthIsNegativeException, CanNotBeTriangleException, WrongTypeOfLocatorException,
            WrongPathOfLocatorException {

        // Объект класса MathContext для округления чисел до определенного знака после запятой.
        MathContext context = new MathContext(5, RoundingMode.HALF_UP);

        logger.info("Тест №1. Вычисление площади треугольника по трем сторонам. Позитивный тест.");
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("side A = " + sideA + ", side B = " + sideB + ", side C = " + sideC + ".");

        // Ожидаемый результат.
        // Создание объекта тест-кейса "Расчет площади треугольника по трем сторонам".
        SquareOfTriangleByThreeSidesTestCase squareOfTriangleByThreeSidesTestCase =
                new SquareOfTriangleByThreeSidesTestCase(getBrowser(),
                        "Расчет площади треугольника по трем сторонам");

        // Округленное значение площади треугольника, полученное при помощи калькулятора на сайте calculat.ru.
        BigDecimal expected =
                new BigDecimal(Double.parseDouble(squareOfTriangleByThreeSidesTestCase
                        .getTriangleSquare(String.valueOf(sideA), String.valueOf(sideB), String.valueOf(sideC))),
                        context);

        logger.info("Ожидаемый результат --> " + expected);

        // Фактический результат.
        // Создание объекта треугольника с заданными длинами сторон.
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        // Округленное значение площади треугольника, полученное при помощи метода класса
        // Triangle countSquareByThreeSides().
        BigDecimal square = new BigDecimal(triangle.countSquareByThreeSides(), context);

        logger.info("Фактический результат --> " + square);

        // Проверка равенства ожидаемого и фактического результатов расчетов.
        Assertions.assertEquals(expected, square);

        logger.info("Ожидаемый результат совпадает с фактическим.");
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Тест успешно завершен.");
        logger.info("================================================================================================");
    }


    @ParameterizedTest
    @CsvSource({"0, 3, 3", "3, 0, 3", "3, 3, 0"})
    @DisplayName("Тест №2. Вычисление площади треугольника. Длина хотя бы одной из сторон равна 0.")
    public void sideEqualZeroTest(int sideA, int sideB, int sideC) {

        logger.info("Тест №2. Вычисление площади треугольника. Длина хотя бы одной из сторон равна 0.");
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("side A = " + sideA + ", side B = " + sideB + ", side C = " + sideC + ".");

        // Ожидание SideEqualZeroException в момент создания объекта треугольника.
        Throwable exception =
                Assertions.assertThrows(SideEqualZeroException.class, () -> new Triangle(sideA, sideB, sideC));

        logger.info(exception.getMessage());
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Тест успешно завершен.");
        logger.info("================================================================================================");
    }


    @ParameterizedTest
    @CsvSource({"-3, 3, 3", "3, -2, 3", "30, 40, -50"})
    @DisplayName("Тест №3. Вычисление площади треугольника. " +
            "Длина хотя бы одной из сторон имеет отрицательное значение.")
    public void lengthIsNegativeTest(int sideA, int sideB, int sideC) {

        logger.info("Тест №3. Вычисление площади треугольника. " +
                "Длина хотя бы одной из сторон имеет отрицательное значение.");
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("side A = " + sideA + ", side B = " + sideB + ", side C = " + sideC + ".");

        // Ожидание LengthIsNegativeException в момент создания объекта треугольника.
        Throwable exception =
                Assertions.assertThrows(LengthIsNegativeException.class, () -> new Triangle(sideA, sideB, sideC));

        logger.info(exception.getMessage());
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Тест успешно завершен.");
        logger.info("================================================================================================");
    }


    @ParameterizedTest
    @CsvSource({"8, 3, 3", "2, 5, 3", "30, 40, 100"})
    @DisplayName("Тест №4. Вычисление площади треугольника. " +
            "Длина одной из сторон слишком велика, чтобы получился треугольник.")
    public void canNotBeTriangleTest(int sideA, int sideB, int sideC)
            throws SideEqualZeroException, LengthIsNegativeException {
        logger.info("Тест №4. Вычисление площади треугольника. " +
                "Длина одной из сторон слишком велика, чтобы получился треугольник.");
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("side A = " + sideA + ", side B = " + sideB + ", side C = " + sideC + ".");

        // Создание объекта треугольника.
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        // Ожидание CanNotBeTriangleException в момент вычисления площади треугольника по трем сторонам.
        Throwable exception =
                Assertions.assertThrows(CanNotBeTriangleException.class, triangle::countSquareByThreeSides);

        logger.info(exception.getMessage());
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Тест успешно завершен.");
        logger.info("================================================================================================");
    }
}
