public class PatientReportManager {
    // Responsibility 1: Data formatting
    public String formatReport(String name, int riskScore) {
        return "Patient: " + name + " | Risk: " + riskScore;
    }

    // Responsibility 2: File saving
    public void saveToFile(String report, String filename) {
        System.out.println("Saving '" + report + "' to " + filename);
    }

    // Responsibility 3: Email sending
    public void sendByEmail(String report, String recipient) {
        System.out.println("Emailing '" + report + "' to " + recipient);
    }

    // Responsibility 4: Audit logging
    public void logAudit(String action) {
        System.out.println("[AUDIT] " + action);
    }

}
