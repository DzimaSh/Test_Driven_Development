package by.bsu.testdrivendevelopment.metrics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HalsteadMetricsAnalyzer {

    private final Set<String> uniqueOperators = new HashSet<>();
    private final Set<String> uniqueOperands = new HashSet<>();
    private int totalOperators = 0;
    private int totalOperands = 0;

    // Добавьте все операторы, которые вы хотите учитывать
    private final String[] operators = {"+", "-", "*", "/", "=", "==", "!=", "<", ">", "<=", ">=", "&&", "||", "!", "++", "--"};

    public void analyzeFile(String filePath) throws IOException {
        String code = new String(Files.readAllBytes(Paths.get(filePath)));
        analyzeCode(code);
    }

    private void analyzeCode(String code) {
        // Разбиваем код на токены
        String[] tokens = code.split("\\s+|(?=\\W)|(?<=\\W)");

        for (String token : tokens) {
            if (isOperator(token)) {
                uniqueOperators.add(token);
                totalOperators++;
            } else if (isOperand(token)) {
                uniqueOperands.add(token);
                totalOperands++;
            }
        }
    }

    private boolean isOperator(String token) {
        for (String op : operators) {
            if (token.equals(op)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOperand(String token) {
        // Простая проверка на операнд (можно улучшить)
        Pattern pattern = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }

    public int getUniqueOperators() {
        return uniqueOperators.size();
    }

    public int getUniqueOperands() {
        return uniqueOperands.size();
    }

    public int getTotalOperators() {
        return totalOperators;
    }

    public int getTotalOperands() {
        return totalOperands;
    }
}
