package by.bsu.testdrivendevelopment.metrics;

public class HalsteadMetricsCalculator {

    private final int uniqueOperators;
    private final int uniqueOperands;
    private final int totalOperators;
    private final int totalOperands;

    public HalsteadMetricsCalculator(int uniqueOperators, int uniqueOperands, int totalOperators, int totalOperands) {
        this.uniqueOperators = uniqueOperators;
        this.uniqueOperands = uniqueOperands;
        this.totalOperators = totalOperators;
        this.totalOperands = totalOperands;
    }

    public HalsteadMetricsCalculator(HalsteadMetricsAnalyzer analyzer) {
        this.uniqueOperators = analyzer.getUniqueOperators();
        this.uniqueOperands = analyzer.getUniqueOperands();
        this.totalOperators = analyzer.getTotalOperators();
        this.totalOperands = analyzer.getTotalOperands();
    }

    public int getVocabulary() {
        return uniqueOperators + uniqueOperands;
    }

    public int getLength() {
        return totalOperators + totalOperands;
    }

    public double getVolume() {
        return (totalOperators + totalOperands) * (Math.log(getVocabulary()) / Math.log(2));
    }
}