public class AdmissionChecker {

    public static String checkUrgency(double bodyTempC) {
        if (bodyTempC >= 39.5) {
            return "URGENT: High fever — immediate admission required.";
        } else if (bodyTempC >= 37.5) {
            return "MODERATE: Elevated temperature — monitor closely.";
        } else {
            return "NORMAL: Temperature within safe range.";
        }
    }

    public static void checkQueue(int numberOfPatients) {
        System.out.println("\nChecking daily patient queue:");
        for (int i = 1; i <= numberOfPatients; i++) {
            System.out.println("  Processing patient #" + i);
        }
    }

    public static void wardCountdown(int hoursLeft) {
        System.out.println("\nWard closes in:");
        while (hoursLeft > 0) {
            System.out.println("  " + hoursLeft + " hour(s)");
            hoursLeft--;
        }
        System.out.println("  Ward closed.");
    }
}
