import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {
    private Map<Integer, Double> memoizationCache = new HashMap<>();

    public double calculateFutureValue(double presentValue, double rate, int years) {
      
        if (years == 0) {
            return presentValue;
        }
        
        return calculateFutureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    public double calculateFutureValueOptimized(double presentValue, double rate, int years) {
        
        if (memoizationCache.containsKey(years)) {
            return memoizationCache.get(years);
        }

        if (years == 0) {
            return presentValue;
        }

        double previousYearValue = calculateFutureValueOptimized(presentValue, rate, years - 1);
        double currentYearValue = previousYearValue * (1 + rate);
        
        memoizationCache.put(years, currentYearValue);
        
        return currentYearValue;
    }

    public static void main(String[] args) {
        FinancialForecaster forecaster = new FinancialForecaster();
        
        double startingCapital = 10000.00; 
        double historicalGrowthRate = 0.07;
        int targetYears = 10;               

        double futureVal = forecaster.calculateFutureValue(startingCapital, historicalGrowthRate, targetYears);
        System.out.printf("Standard Recursion: Projected value after %d years is $%.2f%n", targetYears, futureVal);

        double optimizedVal = forecaster.calculateFutureValueOptimized(startingCapital, historicalGrowthRate, targetYears);
        System.out.printf("Optimized Recursion: Projected value after %d years is $%.2f%n", targetYears, optimizedVal);
    }
}