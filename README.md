# Нелинейное уравнение

### Описание

Реализовать класс _"Нелинейное уравнение"_ и найти его корни методом бисекции.

### Разработка

Проект разрабатывается с использованием языка программирования `Java` и следует стандарту `IEEE 830-1998` для спецификации требований к программному обеспечению.
В качестве класса _"Нелинейное уравнение"_ использовалась лямбда функиця `DoubleUnaryOperator`

#### Примеры Кода на Java

```java
// Класс для решения нелинейного уравнения методом бисекции
public class NonlinearEquationSolver {
    public static double findRootUsingBisection(DoubleUnaryOperator equationFunction, double lowerBound, double upperBound, double tolerance) {
        if (equationFunction.applyAsDouble(lowerBound) * equationFunction.applyAsDouble(upperBound) >= 0) {
            throw new IllegalArgumentException("Некорректный интервал [lowerBound;upperBound].");
        }

        double midpoint;
        while ((upperBound - lowerBound) >= tolerance) {
            midpoint = (lowerBound + upperBound) / 2;
            if (equationFunction.applyAsDouble(midpoint) == 0.0) break;
            else if (equationFunction.applyAsDouble(midpoint) * equationFunction.applyAsDouble(lowerBound) < 0) upperBound = midpoint;
            else lowerBound = midpoint;
        }
        return (lowerBound + upperBound) / 2;
    }
}
```

### Тестирование
Для тестирования функциональности используется библиотека JUnit Jupiter. Тесты направлены на проверку корректности работы методов поиска корней уравнений и обработки исключительных ситуаций.

#### Пример Тестового Класса
```java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.DoubleUnaryOperator;

public class NonlinearEquationSolverTest {

    @Test
    public void testFindRootUsingBisection() {
        DoubleUnaryOperator equationFunction = (x) -> Math.pow(x, 3) - 3 * Math.pow(x, 2) + 3;

        double lowerBound = 0;
        double upperBound = 2;
        double tolerance = 1e-5;

        double root = NonlinearEquationSolver.findRootUsingBisection(equationFunction, lowerBound, upperBound, tolerance);

        assertEquals(1.34729, root, tolerance, String.format("Корень уравнения должен быть близок к %s", root));
    }
}
```

## Метрики Холстеда

Метрики Холстеда — это набор метрик, используемых для оценки сложности программного обеспечения. Они основаны на подсчете операторов и операндов в коде и предоставляют меру количественной оценки сложности программы.

Вот результаты анализа метрик Холстеда с помщью класса `HalsteadMetricsAnalyzer` для класса `NonlinearEquationSolver`:

```text
Уникальные операторы: 6
Уникальные операнды: 44
Общее количество операторов: 42
Общее количество операндов: 74
```

Эти значения могут быть использованы для расчета следующих метрик:

- **Словарь программы (n):** Сумма уникальных операторов и уникальных операндов.
- **Длина программы (N):** Сумма общего количества операторов и операндов.
- **Объем программы (V):**

$$ V = N \times \log_2(n) $$

где:
- \( V \) — объем программы,
- \( N \) — длина программы (общее количество операторов и операндов),
- \( n \) — словарь программы (сумма уникальных операторов и уникальных операндов).

Используя предоставленные данные, можно рассчитать следующее с помщью класса `HalsteadMetricsCalculator`:

```text
Словарь программы: 50
Длина программы: 116
Объем программы: 654.687318013868
```

Эти метрики помогают понять сложность программы и могут быть использованы для оценки усилий, необходимых для поддержки и развития программного продукта.

## Контакты
Для получения дополнительной информации или предложений по сотрудничеству, пожалуйста, свяжитесь с нами по электронной почте [dzmitry.shushkevich@gmail.com](mailto:dzmitry.shushkevich@gmail.com).
