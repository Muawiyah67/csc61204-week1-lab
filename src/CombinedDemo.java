public class CombinedDemo {
    public static void main(String[] args) {
        // Use ConservativeRiskStrategy with 3 observers
        HospitalWithStrategy hospital = new HospitalWithStrategy(
                "MediTrack Central",
                new ConservativeRiskStrategy()
        );

        hospital.addObserver(new DoctorNotifier("Dr. Lim"));
        hospital.addObserver(new BillingNotifier());
        hospital.addObserver(new AuditNotifier());

        // Admit with temp and age
        hospital.admitPatient("Maria Santos", 38.7, 62);
    }
}