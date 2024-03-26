package by.bsu.testdrivendevelopment.equation;

import by.bsu.testdrivendevelopment.solver.NonlinearEquationSolver;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class NonlinearEquationSolverTest {

    @Test
    public void testFindRootUsingBisection() {
        // Лямбда-выражение для уравнения x^3 - 3x^2 + 3
        DoubleUnaryOperator equationFunction = (x) -> Math.pow(x, 3) - 3 * Math.pow(x, 2) + 3;

        // Граничные значения и точность
        double lowerBound = 0;
        double upperBound = 2;
        double tolerance = 1e-5;

        // Вычисляем корень
        double root = NonlinearEquationSolver.findRootUsingBisection(equationFunction, lowerBound, upperBound, tolerance);

        // Проверяем, что найденный корень удовлетворяет уравнению с заданной точностью
        assertEquals(1.34729, root, tolerance, String.format("Корень уравнения должен быть близок к %s", root));
    }

    @Test
    public void testFindRootUsingBisectionWithInvalidInterval() {
        // Лямбда-выражение для уравнения x^3 - 3x^2 + 3 = 0
        DoubleUnaryOperator equationFunction = (x) -> Math.pow(x, 3) - 3 * Math.pow(x, 2) + 3;

        // Некорректные граничные значения, которые не содержат корень
        double lowerBound = 4;
        double upperBound = 5;
        double tolerance = 1e-8;

        // Попытка найти корень должна привести к выбросу исключения
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> NonlinearEquationSolver.findRootUsingBisection(equationFunction, lowerBound, upperBound, tolerance),
                "Ожидалось исключение IllegalArgumentException"
        );

        assertTrue(thrown.getMessage().contains("Некорректный интервал"));
    }
}