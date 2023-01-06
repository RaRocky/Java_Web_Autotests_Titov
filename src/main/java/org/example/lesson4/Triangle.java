package org.example.lesson4;

import org.example.lesson4.exceptions.CanNotBeTriangleException;
import org.example.lesson4.exceptions.LengthIsNegativeException;
import org.example.lesson4.exceptions.SideEqualZeroException;
import org.junit.jupiter.api.function.Executable;

// Объект класса фигуры треугольник.
public class Triangle {
    private int sideA;  // Длина стороны А.
    private int sideB;  // Длина стороны В.
    private int sideC;  // Длина стороны С.


    // Конструктор.
    public Triangle(int sideA, int sideB, int sideC)
            throws SideEqualZeroException, LengthIsNegativeException {
        setSideA(sideA);
        setSideB(sideB);
        setSideC(sideC);
    }


    // Методы класса.
    // Метод, определяющий, может ли при заданных длинах сторон получиться треугольник.
    private boolean isCanBeTriangle(int sideA, int sideB, int sideC) throws CanNotBeTriangleException {
        if (sideA >= (sideB + sideC))
            throw new CanNotBeTriangleException("side A = " + sideA + ". " +
                    "Значение слишком велико, длина стороны A должна быть меньше " + (sideB + sideC) +
                    ", чтобы получился треугольник.");
        if (sideB >= (sideA + sideC))
            throw new CanNotBeTriangleException("side B = " + sideB + ". " +
                    "Значение слишком велико, длина стороны B должна быть меньше " + (sideA + sideC) +
                    ", чтобы получился треугольник.");
        if (sideC >= (sideA + sideB))
            throw new CanNotBeTriangleException("side C = " + sideC + ". " +
                    "Значение слишком велико, длина стороны C должна быть меньше " + (sideA + sideB) +
                    ", чтобы получился треугольник.");
        else return true;
    }

    // Метод, вычисляющий площадь треугольника по трем сторонам.
    public double countSquareByThreeSides() throws CanNotBeTriangleException {
        // Полупериметр треугольника.
        double perimeter = (double) (getSideA() + getSideB() + getSideC()) / 2;

        // Вичисление площади, если при заданных длинах сторон может получиться треугольник.
        if (isCanBeTriangle(getSideA(), getSideB(), getSideC())) {
            return Math.sqrt(perimeter * (perimeter - getSideA()) *
                    (perimeter - getSideB()) * (perimeter - getSideC()));
        } else return 0;
    }


    // Геттеры.
    // Геттер стороны А.
    public int getSideA() {
        return sideA;
    }

    // Геттер стороны В.
    public int getSideB() {
        return sideB;
    }

    // Геттер стороны С.
    public int getSideC() {
        return sideC;
    }


    // Сеттеры.
    // Сеттер стороны А.
    public void setSideA(int sideA) throws SideEqualZeroException, LengthIsNegativeException {
        if (sideA == 0) throw new SideEqualZeroException("side A = 0." +
                " Длина стороны треугольника не может быть равна 0.");
        if (sideA < 0)
            throw new LengthIsNegativeException("side A < 0. " +
                    "Длина стороны треугольника не может иметь отрицательное значение.");
        else this.sideA = sideA;
    }

    // Сеттер стороны В.
    public void setSideB(int sideB) throws SideEqualZeroException, LengthIsNegativeException {
        if (sideB == 0) throw new SideEqualZeroException("side B = 0. " +
                "Длина стороны треугольника не может быть равна 0.");
        if (sideB < 0)
            throw new LengthIsNegativeException("side B < 0. " +
                    "Длина стороны треугольника не может иметь отрицательное значение.");
        else this.sideB = sideB;
    }

    // Сетер стороны С.
    public void setSideC(int sideC) throws SideEqualZeroException, LengthIsNegativeException {
        if (sideC == 0) throw new SideEqualZeroException("side C = 0. " +
                "Длина стороны треугольника не может быть равна 0.");
        if (sideC < 0)
            throw new LengthIsNegativeException("side C < 0. " +
                    "Длина стороны треугольника не может иметь отрицательное значение.");
        else this.sideC = sideC;
    }
}
