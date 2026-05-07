public class PatientUtils {

    public static String assessRisk(double tempC) {
        if (tempC >= 39.5) return "HIGH";
        if (tempC >= 37.5) return "MODERATE";
        return "LOW";
    }

    public static double averageReading(double r1, double r2, double r3) {
        return (r1 + r2 + r3) / 3.0;
    }

    public static boolean isElderly(int age) {
        return age >= 65;
    }
}