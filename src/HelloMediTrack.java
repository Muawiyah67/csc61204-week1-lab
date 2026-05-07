//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
public class HelloMediTrack{
    public static void main(String[] args) {

        // Sprint 0 verification
        System.out.println("MediTrack Patient System - v0.1");
        System.out.println("Developer: [YOUR FULL NAME]");
        System.out.println("Student ID: [YOUR STUDENT ID]");
        System.out.println("Status: Environment configured successfully.");
        System.out.println();

        // Patient record demo
        PatientRecord record = new PatientRecord(45, 37.2, true, 'O', "Maria Santos");
        record.printRecord();
        System.out.println();

        // Admission checker demo
        System.out.println(AdmissionChecker.checkUrgency(38.9));
        AdmissionChecker.checkQueue(5);
        AdmissionChecker.wardCountdown(3);
        System.out.println();

        // PatientUtils demo
        System.out.println("Risk Level:      " + PatientUtils.assessRisk(38.9));
        System.out.println("Average Reading: " + PatientUtils.averageReading(37.1, 38.9, 37.5));
        System.out.println("Is Elderly:      " + PatientUtils.isElderly(70));
        System.out.println();

        // Roster
        PatientRoster roster = new PatientRoster();
        roster.printAllSummaries();

        Patient hottest = roster.findHottestPatient();
        System.out.println("Highest temperature: " + hottest.name + " (" + hottest.temperatureC + "°C)");
        System.out.println("HIGH risk patients: " + roster.countHighRisk());
    }
}