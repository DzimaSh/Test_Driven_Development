# Система Учета Критических Ошибок в Компьютерной Сети Предприятия

## Описание

Данный проект направлен на разработку информационной системы для учета критических ошибок в компьютерной сети предприятия. Система предназначена для мониторинга сетевых устройств, обнаружения и регистрации ошибок, анализа причин возникновения ошибок и разработки мер по их предотвращению.

## Функциональность

- **Регистрация ошибок:** Возможность ввода данных об ошибках, включая тип, время возникновения и устройство.
- **Классификация ошибок:** Автоматическая классификация ошибок по уровню критичности.
- **Анализ последствий:** Оценка потенциального влияния ошибок на работу сети.
- **Уведомления:** Автоматическая отправка уведомлений ответственным лицам.

## Системные Требования

Система должна быть совместима с существующей ИТ-инфраструктурой предприятия и обеспечивать высокую доступность и безопасность данных.

## Спецификация Данных

- **Входная форма:** Поля для регистрации данных об ошибке (тип, время возникновения, устройство и т.д.).
- **Выходная форма:** Отчеты о критических ошибках для анализа и принятия решений.

## Разработка

Проект разрабатывается с использованием языка программирования `Java` и следует стандарту `IEEE 830-1998` для спецификации требований к программному обеспечению.

### Примеры Кода на Java

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

## Тестирование
Для тестирования функциональности используется библиотека JUnit Jupiter. Тесты направлены на проверку корректности работы методов поиска корней уравнений и обработки исключительных ситуаций.

### Пример Тестового Класса
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

## Контакты
Для получения дополнительной информации или предложений по сотрудничеству, пожалуйста, свяжитесь с нами по электронной почте [dzmitry.shushkevich@gmail.com](mailto:dzmitry.shushkevich@gmail.com).
