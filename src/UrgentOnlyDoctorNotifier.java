public class UrgentOnlyDoctorNotifier implements AdmissionObserver {

    private String doctorName;

    public UrgentOnlyDoctorNotifier(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        // ✅ The if statement goes INSIDE the method
        if (riskScore >= 70) {
            System.out.println("[Doctor " + doctorName + "] Patient " + patientName
                    + " admitted. Risk score: " + riskScore);
        }
    }
}