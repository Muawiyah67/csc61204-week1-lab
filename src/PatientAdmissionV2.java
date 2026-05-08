public class PatientAdmissionV2 {
    private RiskCalculationStrategy strategy;

    // Strategy injected via constructor (Dependency Injection)
    public PatientAdmissionV2(RiskCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    // Allow swapping strategy at runtime
    public void setStrategy(RiskCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateRiskScore(double temperatureC, int age) {
        return strategy.calculateRisk(temperatureC, age);
    }
}