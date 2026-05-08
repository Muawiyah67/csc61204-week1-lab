public class PediatricRiskStrategy implements RiskCalculationStrategy{
    @Override
    public int calculateRisk(double temperatureC, int age) {
        int score = 0;
        if (age < 12) score += 20;           // pediatric bonus
        if (temperatureC >= 38.0) score += 40;  // lower fever threshold for kids
        return score;
    }
}
