
    // Observer 2: Notifies the billing department
public class BillingNotifier implements AdmissionObserver {
   @Override
   public void onPatientAdmitted(String patientName, int riskScore) {
    System.out.println("[Billing] Opening account for: " + patientName);
   }
}
