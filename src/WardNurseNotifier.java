public class WardNurseNotifier implements AdmissionObserver{
    private String nurseName;
    public WardNurseNotifier(String nurseName) { this.nurseName = nurseName; }
    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        System.out.println("[Nurse " + nurseName + "] Patient " + patientName
                + " admitted. Risk score: " + riskScore);
    }
}
