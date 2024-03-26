package by.bsu.testdrivendevelopment.solver;

import java.util.function.DoubleUnaryOperator;

public class NonlinearEquationSolver {
    public static double findRootUsingBisection(DoubleUnaryOperator equationFunction, double lowerBound, double upperBound, double tolerance) throws IllegalArgumentException {
        if (equationFunction.applyAsDouble(lowerBound) * equationFunction.applyAsDouble(upperBound) >= 0) {
            throw new IllegalArgumentException("Некорректный интервал [lowerBound;upperBound]. Корень может отсутствовать или их может быть несколько.");
        }

        double midpoint = 0.0;
        while ((upperBound - lowerBound) >= tolerance) {
            // Находим середину интервала
            midpoint = (lowerBound + upperBound) / 2;

            // Проверяем, если нашли корень
            if (equationFunction.applyAsDouble(midpoint) == 0.0)
                break;

                // Решаем, какую часть интервала нужно отбросить
            else if (equationFunction.applyAsDouble(midpoint) * equationFunction.applyAsDouble(lowerBound) < 0)
                upperBound = midpoint;
            else
                lowerBound = midpoint;
        }
        return midpoint;
    }
}
