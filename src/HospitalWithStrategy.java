public class HospitalWithStrategy {
    private Hospital hospital;
    private RiskCalculationStrategy riskStrategy;

    public HospitalWithStrategy(String hospitalName, RiskCalculationStrategy strategy) {
        this.hospital = new Hospital(hospitalName);
        this.riskStrategy = strategy;
    }

    public void setRiskStrategy(RiskCalculationStrategy strategy) {
        this.riskStrategy = strategy;
    }

    public void admitPatient(String patientName, double temperatureC, int age) {
        int riskScore = riskStrategy.calculateRisk(temperatureC, age);
        System.out.println("[" + hospital.getHospitalName() + "] Admitting: " + patientName
                + " (Risk: " + riskScore + ")");
        hospital.admitPatient(patientName, riskScore);  // Triggers notifyObservers
    }

    public void addObserver(AdmissionObserver observer) {
        hospital.addObserver(observer);
    }
}