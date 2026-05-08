public class StrategyDemo {
    public static void main(String[] args) {
        double temp = 38.7;
        int age = 62;

        // Standard strategy
        PatientAdmissionV2 standard = new PatientAdmissionV2(new StandardRiskStrategy());
        System.out.println("Standard risk: " + standard.calculateRiskScore(temp, age));

        // Conservative strategy
        PatientAdmissionV2 conservative = new PatientAdmissionV2(new ConservativeRiskStrategy());
        System.out.println("Conservative risk: " + conservative.calculateRiskScore(temp, age));

        // Swap strategy at runtime
        standard.setStrategy(new ConservativeRiskStrategy());
        System.out.println("After swap: " + standard.calculateRiskScore(temp, age));
    }
}