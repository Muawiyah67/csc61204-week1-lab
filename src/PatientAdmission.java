public class PatientAdmission {

    /**
     * Calculates a risk score (0-100) from temperature and age.
     * Higher score = higher risk.
     */
    public int calculateRiskScore(double temperatureC, int age) {
        if (temperatureC < 30.0 || temperatureC > 45.0) {
            throw new IllegalArgumentException(
                    "Temperature out of valid range: " + temperatureC);
        }

        int score = 0;

        // Temperature scoring (was deleted — add it back!)
        if (temperatureC >= 39.5) score += 50;
        else if (temperatureC >= 37.5) score += 25;

        // Age scoring
        if (age >= 65) score += 30;
        else if (age >= 50) score += 15;

        return score;
    }
    /**
     * Returns admission priority: "URGENT", "MODERATE", or "ROUTINE"
     */
    public String getAdmissionPriority(int riskScore) {
        if (riskScore >= 70) return "URGENT";
        if (riskScore >= 30) return "MODERATE";
        return "ROUTINE";
    }

    /**
     * Checks whether a patient name is valid (non-null, non-empty, <= 100 chars).
     */
    public boolean isValidPatientName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 100;
    }
}