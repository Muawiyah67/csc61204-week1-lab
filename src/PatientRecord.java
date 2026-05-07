public class PatientRecord {
    int     patientAge;
    double  bodyTempC;
    boolean isAdmitted;
    char    bloodType;
    String  patientName;

    public PatientRecord(int patientAge, double bodyTempC, boolean isAdmitted, char bloodType, String patientName) {
        this.patientAge  = patientAge;
        this.bodyTempC   = bodyTempC;
        this.isAdmitted  = isAdmitted;
        this.bloodType   = bloodType;
        this.patientName = patientName;
    }

    public void printRecord() {
        System.out.println("=== Patient Record ===");
        System.out.println("Name:        " + patientName);
        System.out.println("Age:         " + patientAge);
        System.out.println("Temperature: " + bodyTempC + "°C");
        System.out.println("Blood Type:  " + bloodType);
        System.out.println("Admitted:    " + isAdmitted);
    }
}
