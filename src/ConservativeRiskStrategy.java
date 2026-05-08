public class ConservativeRiskStrategy implements RiskCalculationStrategy {
    @Override
    public int calculateRisk(double temperatureC, int age) {
        int score = 0;
        if (temperatureC >= 38.5) score += 50;  // lower threshold
        else if (temperatureC >= 37.0) score += 25;
        if (age >= 60) score += 30;  // lower age threshold
        return score;
    }
}