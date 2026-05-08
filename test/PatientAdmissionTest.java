import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PatientAdmissionTest {

    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    // --- calculateRiskScore tests ---

    @Test
    void calculateRiskScore_highTempElderlyPatient_returnsHighScore() {
        int score = admission.calculateRiskScore(40.0, 70);
        assertEquals(80, score);  // 50 + 30 = 80
    }

    @Test
    void calculateRiskScore_normalTempYoungPatient_returnsZero() {
        int score = admission.calculateRiskScore(36.5, 25);
        assertEquals(0, score);   // 0 + 0 = 0
    }

    @Test
    void calculateRiskScore_elevatedTempMiddleAge_returnsMediumScore() {
        int score = admission.calculateRiskScore(38.0, 55);
        assertEquals(40, score);  // 25 + 15 = 40
    }

    // --- getAdmissionPriority tests ---

    @Test
    void getAdmissionPriority_scoreAbove70_returnsUrgent() {
        assertEquals("URGENT", admission.getAdmissionPriority(80));
    }

    @Test
    void getAdmissionPriority_scoreBetween30And70_returnsModerate() {
        assertEquals("MODERATE", admission.getAdmissionPriority(40));
    }

    @Test
    void getAdmissionPriority_scoreBelow30_returnsRoutine() {
        assertEquals("ROUTINE", admission.getAdmissionPriority(10));
    }

    // --- isValidPatientName tests ---

    @Test
    void isValidPatientName_validName_returnsTrue() {
        assertTrue(admission.isValidPatientName("Maria Santos"));
    }

    @Test
    void isValidPatientName_nullName_returnsFalse() {
        assertFalse(admission.isValidPatientName(null));
    }

    @Test
    void isValidPatientName_emptyString_returnsFalse() {
        assertFalse(admission.isValidPatientName(""));
    }
    @Test
    void calculateRiskScore_temperatureExactlyAt39_5_returns50() {
        int score = admission.calculateRiskScore(39.5, 30);
        assertEquals(50, score);  // boundary: exactly 39.5 = high temp
    }

    @Test
    void calculateRiskScore_ageExactly65_returnsPlus30() {
        int score = admission.calculateRiskScore(36.5, 65);
        assertEquals(30, score);  // boundary: exactly 65 = elderly
    }

    @Test
    void isValidPatientName_exactly100Characters_returnsTrue() {
        String name = "A".repeat(100);
        assertTrue(admission.isValidPatientName(name));
    }

    @Test
    void isValidPatientName_101Characters_returnsFalse() {
        String name = "A".repeat(101);
        assertFalse(admission.isValidPatientName(name));
    }
    @Test
    void calculateRiskScore_temperatureBelow30_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(20.0, 40);
        });
    }

    @Test
    void calculateRiskScore_temperatureAbove45_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(46.0, 40);
        });
    }
    @ParameterizedTest
    @CsvSource({
            "40.0, 70, 80",    // high temp + elderly = 50 + 30
            "38.0, 55, 40",    // moderate temp + middle age = 25 + 15
            "36.5, 25, 0",     // normal temp + young = 0 + 0
            "39.5, 30, 50",    // boundary high temp + young = 50 + 0
            "37.5, 50, 40"     // boundary moderate temp + boundary age = 25 + 15
    })
    void calculateRiskScore_variousInputs_returnsCorrectScore(
            double temp, int age, int expectedScore) {
        assertEquals(expectedScore, admission.calculateRiskScore(temp, age));
    }
    @Test
    void isEligibleForPriorityCare_elderlyNoChronic_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(70, false));
    }

    @Test
    void isEligibleForPriorityCare_youngWithChronic_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(30, true));
    }

    @Test
    void isEligibleForPriorityCare_youngHealthy_returnsFalse() {
        assertFalse(admission.isEligibleForPriorityCare(30, false));
    }

    @Test
    void isEligibleForPriorityCare_elderlyWithChronic_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(70, true));

    }
    // --- formatPatientReport tests (5 acceptance criteria + 3 edge cases) ---

    @Test
    void formatPatientReport_validInputs_returnsFormattedString() {
        assertEquals("Patient: John Doe | Risk: 80 | Priority: URGENT",
                admission.formatPatientReport("John Doe", 80, "URGENT"));
    }

    @Test
    void formatPatientReport_nullName_returnsUnknown() {
        assertEquals("Patient: UNKNOWN | Risk: 50 | Priority: MODERATE",
                admission.formatPatientReport(null, 50, "MODERATE"));
    }

    @Test
    void formatPatientReport_negativeScore_returnsZero() {
        assertEquals("Patient: Jane | Risk: 0 | Priority: ROUTINE",
                admission.formatPatientReport("Jane", -10, "ROUTINE"));
    }

    @Test
    void formatPatientReport_nullPriority_returnsUnassigned() {
        assertEquals("Patient: Bob | Risk: 30 | Priority: UNASSIGNED",
                admission.formatPatientReport("Bob", 30, null));
    }

    @Test
    void formatPatientReport_emptyPriority_returnsUnassigned() {
        assertEquals("Patient: Alice | Risk: 30 | Priority: UNASSIGNED",
                admission.formatPatientReport("Alice", 30, ""));
    }

// Edge cases

    @Test
    void formatPatientReport_whitespacePriority_returnsUnassigned() {
        assertEquals("Patient: Tom | Risk: 40 | Priority: UNASSIGNED",
                admission.formatPatientReport("Tom", 40, "   "));
    }

    @Test
    void formatPatientReport_allNullInputs_returnsSafeDefaults() {
        assertEquals("Patient: UNKNOWN | Risk: 0 | Priority: UNASSIGNED",
                admission.formatPatientReport(null, -5, null));
    }

    @Test
    void formatPatientReport_veryLongName_preservesName() {
        String longName = "A".repeat(100);
        assertEquals("Patient: " + longName + " | Risk: 10 | Priority: ROUTINE",
                admission.formatPatientReport(longName, 10, "ROUTINE"));
    }
}