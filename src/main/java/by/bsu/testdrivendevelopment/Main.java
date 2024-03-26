package by.bsu.testdrivendevelopment;

import by.bsu.testdrivendevelopment.metrics.HalsteadMetricsAnalyzer;
import by.bsu.testdrivendevelopment.metrics.HalsteadMetricsCalculator;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = String.format(
                    "%s/%s",
                    Arrays.stream(System.getProperty("java.class.path")
                            .split(":"))
                            .filter(property -> property.contains("classes"))
                            .findFirst()
                            .orElseThrow(),
                    "by/bsu/testdrivendevelopment/solver/NonlinearEquationSolver.class");
            HalsteadMetricsAnalyzer analyzer = new HalsteadMetricsAnalyzer();
            analyzer.analyzeFile(filePath);

            System.out.println("Уникальные операторы: " + analyzer.getUniqueOperators());
            System.out.println("Уникальные операнды: " + analyzer.getUniqueOperands());
            System.out.println("Общее количество операторов: " + analyzer.getTotalOperators());
            System.out.println("Общее количество операндов: " + analyzer.getTotalOperands());


            System.out.println("\n");

            HalsteadMetricsCalculator calculator = new HalsteadMetricsCalculator(analyzer);

            System.out.println("Словарь программы: " + calculator.getVocabulary());
            System.out.println("Длина программы: " + calculator.getLength());
            System.out.println("Объем программы: " + calculator.getVolume());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}